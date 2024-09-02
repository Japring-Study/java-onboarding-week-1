package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;

        for (int i = 1; i <= number; i++) {
            String strNum = String.valueOf(i);
            for (char c : strNum.toCharArray()) {
                if (c == '3' || c == '6' || c == '9') {
                    clapCount++;
                }
            }
        }

        return clapCount;
    }
}
