package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++){

            int target = (int)word.charAt(i);
            if (target>=65 && target<=90){
                int subvar = target-65;
                int result = 90-subvar;
                answer += (char)result;
            } else if (target>=97 && target<=122) {
                int subvar = target-97;
                int result = 122-subvar;
                answer += (char)result;
            } else{
                answer +=(char)target;
            }
        }
        return answer;
    }
}
