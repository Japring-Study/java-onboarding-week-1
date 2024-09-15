package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(number < 1 || number > 10000) {
            return -1;
        }

        for(int i = 1; i <= number; i++) {
            List<Integer> digits = Problem1.splitDigit(i);
            for(int j = 0; j < digits.size(); j++) {
                if(digits.get(j) == 3 || digits.get(j) == 6 || digits.get(j) == 9) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
