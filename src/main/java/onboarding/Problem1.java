package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore;
        int crongScore;

        try {

            pobiScore = getScore(pobi);
            crongScore = getScore(crong);

        } catch (RuntimeException e) {
            return -1;
        }

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int getScore(List<Integer> pages) {
        return pages.stream()
                .map(Problem1::getMaxOfDigitSumAndMultiply)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("동작 오류"));
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