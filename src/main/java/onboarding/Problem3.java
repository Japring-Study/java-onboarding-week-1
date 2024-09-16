package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(number < 1 || number > 10000) {
            return -1;
        }

        List<Integer> clapNumbers = Arrays.asList(3, 6, 9);

        for(int i = 1; i <= number; i++) {
            List<Integer> digits = Problem1.splitDigits(i);
            for (Integer digit : digits) {
                if (clapNumbers.contains(digit)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
