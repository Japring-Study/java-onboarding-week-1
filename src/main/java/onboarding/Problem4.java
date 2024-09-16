package onboarding;

public class Problem4 {

    private static final int LOWERCASE_TRANSFORM_BASE = 219;
    private static final int UPPERCASE_TRANSFORM_BASE = 155;

    public static String solution(String word) {
        String answer = "";

        if(word.length() < 1 || word.length() > 1000) {
            return "error";
        }

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(c == ' ') {
                answer += ' ';
                continue;
            }

            char newChar;
            if(c >= 'a' && c <= 'z') { //소문자
                newChar = (char) (LOWERCASE_TRANSFORM_BASE - c);
            } else if (c >= 'A' && c <= 'Z') {  // 대문자 변환
                newChar = (char) (UPPERCASE_TRANSFORM_BASE - c);
            } else {
                newChar = c;  // 알파벳이 아닌 경우 그대로 유지
            }
            answer += newChar;
        }

        return answer;
    }
}
