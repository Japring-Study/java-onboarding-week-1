package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> duplicateEmails = new HashSet<>();

        // 각 닉네임에 대해 두 글자씩 슬라이딩하면서 부분 문자열을 추출하여 비교
        for (int i = 0; i < forms.size(); i++) {
            String email1 = forms.get(i).get(0);
            String nickname1 = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); j++) {
                String email2 = forms.get(j).get(0);
                String nickname2 = forms.get(j).get(1);

                if (hasCommonSubstring(nickname1, nickname2)) {
                    duplicateEmails.add(email1);
                    duplicateEmails.add(email2);
                }
            }
        }

        // Set에 있는 이메일을 리스트로 변환하고 오름차순 정렬
        List<String> result = new ArrayList<>(duplicateEmails);
        Collections.sort(result);

        return result;
    }

    // 두 닉네임에서 2글자 이상의 연속된 공통 부분 문자열이 있는지 확인
    private static boolean hasCommonSubstring(String nickname1, String nickname2) {
        for (int i = 0; i < nickname1.length() - 1; i++) {
            String substring = nickname1.substring(i, i + 2);
            if (nickname2.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}
