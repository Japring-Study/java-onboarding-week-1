package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static boolean isValid(List<Integer> pages) {
        return pages.size() == 2 && pages.get(0) == pages.get(1) - 1;
    }

    private static int getScore(List<Integer> pages) {
        return pages.stream()
                .map(Problem1::getMaxOfDigitSumAndMultiply)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("동작 오류"));
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