package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";


        return answer;
    }

    private static String decode(String cryptogram) {

        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
                continue;
            }

            stack.pop();
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
