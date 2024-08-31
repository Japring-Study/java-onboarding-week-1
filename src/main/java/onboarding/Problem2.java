package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        while(true) {
            int count = 0;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    i--;
                    count++;
                }
            }
            if(count == 0) break;
        }

        answer = cryptogram;
        return answer;
    }
}
