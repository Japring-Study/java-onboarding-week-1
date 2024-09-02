package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char reverseChar(char c) {
        if (Character.isLowerCase(c)) {
            return (char) ('a' + 'z' - c);
        }
        return (char) ('A' + 'Z' - c);
    }
}
