package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

    private final static List<Integer> special = List.of(3, 6, 9);

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int[] countClap(int last) {

        int[] count = new int[last + 1];
        for (int num = 1; num <= last; num++) {

            int lastDigitCount = special.contains(num % 10) ? 1 : 0;
            count[num] = count[num/10] + lastDigitCount;
        }

        return count;
    }
}
