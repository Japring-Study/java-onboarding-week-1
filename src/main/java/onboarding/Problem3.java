package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

    private final static List<Integer> special = List.of(3, 6, 9);

    public static int solution(int number) {
        return sumClap(countClap(number));
    }

    private static int sumClap(int[] counts) {
        return Arrays.stream(counts).sum();
    }

    private static int[] countClap(int last) {

        int[] counts = new int[last + 1];
        for (int num = 1; num <= last; num++) {

            int lastDigitCount = special.contains(num % 10) ? 1 : 0;
            counts[num] = counts[num/10] + lastDigitCount;
        }

        return counts;
    }
}
