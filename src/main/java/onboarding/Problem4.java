package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 대문자 변환: 'A' -> 'Z', 'B' -> 'Y' ... 'Z' -> 'A'
                result.append((char) ('Z' - (c - 'A')));
            } else if (c >= 'a' && c <= 'z') {
                // 소문자 변환: 'a' -> 'z', 'b' -> 'y' ... 'z' -> 'a'
                result.append((char) ('z' - (c - 'a')));
            } else {
                // 알파벳이 아닌 문자는 그대로 추가
                result.append(c);
            }
        }

        return result.toString();
    }

}
