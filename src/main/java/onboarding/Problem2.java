package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();  // 스택의 최상단 요소 제거
            } else {
                stack.push(c);
            }
        }

        // 스택에 남은 문자들을 합쳐 최종 문자열 반환
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

}