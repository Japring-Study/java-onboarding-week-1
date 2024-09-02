package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();
        for(char w :word.toCharArray())
        {
            if(w>='A'&&w<='Z'){
                result.append((char) ('Z' - (w - 'A')));
            }
            else if(w>='a'&&w<='z'){
                result.append((char) ('z' - (w - 'a')));
            }
            else result.append(w);
        }
        return result.toString();
    }
}
