package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        for (int i = 0; i <= number; i++) {
            int current = i;

            while (current > 0) {
                int index = current % 10;
                if (index == 3 || index == 6 || index == 9) count++;
                current /= 10;
            }
        }
        return count;
    }
}
