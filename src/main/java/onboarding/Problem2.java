package onboarding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(cryptogram == null || cryptogram.isBlank()){
            return cryptogram;
        }
        return Arrays.asList(cryptogram.split("")).stream()
                .distinct()
                .collect(Collectors.joining());
    }
}
