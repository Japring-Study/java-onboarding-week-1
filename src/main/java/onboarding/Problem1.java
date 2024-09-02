package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getMaxOfDigitSumAndMultiply(int num) {

        List<Integer> digits = getDigits(num);

        Integer sum = digits.stream()
                .reduce(0, Integer::sum);
        Integer multiply = digits.stream()
                .reduce(1, (x, y) -> x * y);

        return Integer.max(sum, multiply);
    }

    private static List<Integer> getDigits(int num) {

        List<Integer> digits = new ArrayList<>();

        int cur = num;
        while (cur > 0) {
            digits.add(0, cur % 10);
            cur /= 10;
        }

        if (digits.isEmpty()) {
            digits.add(0);
        }

        return digits;
    }
}