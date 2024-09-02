package onboarding;

import java.util.*;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> duplicateEmails = new HashSet<>();

        // 각 크루의 신청 정보를 순회하며 조건에 맞는지 검사
        for (int i = 0; i < forms.size(); i++) {
            String email1 = forms.get(i).get(0);
            String nickname1 = forms.get(i).get(1);

            // 이메일과 닉네임의 조건을 검사
            if (!isValidEmail(email1) || !isValidNickname(nickname1)) {
                continue; // 조건에 맞지 않는 경우 건너뜀
            }

            // 닉네임에서 중복 패턴 추출
            List<String> patterns = extractPatterns(nickname1);

            // 다른 닉네임들과 중복된 패턴이 있는지 확인
            for (String pattern : patterns) {
                for (int j = i + 1; j < forms.size(); j++) {
                    String email2 = forms.get(j).get(0);
                    String nickname2 = forms.get(j).get(1);

                    // 이메일과 닉네임의 조건을 검사
                    if (!isValidEmail(email2) || !isValidNickname(nickname2)) {
                        continue; // 조건에 맞지 않는 경우 건너뜀
                    }

                    // 다른 닉네임에 패턴이 포함되는지 확인
                    if (nickname2.contains(pattern)) {
                        duplicateEmails.add(email1);
                        duplicateEmails.add(email2);
                    }
                }
            }
        }

        // 결과를 오름차순으로 정렬하고 중복 제거
        List<String> result = new ArrayList<>(duplicateEmails);
        Collections.sort(result);
        return result;
    }

    // 이메일 형식 검증 메서드
    private static boolean isValidEmail(String email) {
        return email.endsWith("@email.com") && email.length() >= 11 && email.length() < 20;
    }

    // 닉네임 형식 검증 메서드 (한글만 포함하고 길이가 1자 이상 20자 미만)
    private static boolean isValidNickname(String nickname) {
        return nickname.matches("^[가-힣]+$") && nickname.length() >= 1 && nickname.length() < 20;
    }

    // 닉네임에서 중복 패턴 추출 메서드
    private static List<String> extractPatterns(String nickname) {
        List<String> patterns = new ArrayList<>();
        // 2글자 이상의 모든 연속된 문자열 패턴 추출
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                patterns.add(nickname.substring(i, j));
            }
        }
        return patterns;
    }
}
