package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseString(word);
    }

    private static String reverseString(String word) {

        StringBuilder result = new StringBuilder();

        for (char c: word.toCharArray()) {
            result.append(reverseChar(c));
        }
        return result.toString();
    }

    private static char reverseChar(char c) {
        if (Character.isLowerCase(c)) {
            return (char) ('a' + 'z' - c);
        }
        if (Character.isUpperCase(c)) {
            return (char) ('A' + 'Z' - c);
        }

        return c;
    }
}
