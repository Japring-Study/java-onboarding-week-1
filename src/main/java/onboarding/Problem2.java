package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String tmp ="";
        while (true) {
            int rememberIndex = 0;
            int check = 0;

            if (cryptogram.isEmpty()){
                break;
            }

            for (int i = 0; i < cryptogram.length(); i++) {
                if (i == cryptogram.length() - 1) {
                    break;
                }
                char target = cryptogram.charAt(i);

                if (target == cryptogram.charAt(i + 1)) {
                    check = 1;
                    rememberIndex = i;
                    break;
                }
            }

            if (check == 1) {
                tmp="";
                for (int i = 0, j = 0; i < cryptogram.length(); i++) {
                    if (i != rememberIndex && i != (rememberIndex+1)) {
                        tmp = tmp + cryptogram.charAt(i);
                    }
                }

                cryptogram=tmp;

            }else{
                break;
            }

            check = 0;
        }
        answer = tmp;

        return answer;
    }
}
