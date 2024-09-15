package onboarding;

public class Problem4 {
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
            if(c >= 97) { //소문자
                newChar = (char) (219 - c);
            } else { // 대문자
                newChar = (char) (155 - c);
            }
            answer += newChar;
        }

        return answer;
    }
}
