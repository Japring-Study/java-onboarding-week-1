package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static Set<String> getDuplicated(List<List<String>> forms) {

        Set<String> duplicated = new HashSet<>();

        Map<String, Set<String>> emailsPerTwoLetter = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            for (String letter : getTwoLetters(nickName)) {
                if (!emailsPerTwoLetter.containsKey(letter)) {
                    emailsPerTwoLetter.put(letter, new HashSet<>(){{add(email);}});
                    continue;
                }
                emailsPerTwoLetter.get(letter).add(email);
                duplicated.addAll(emailsPerTwoLetter.get(letter));
            }
        }
        return duplicated;
    }

    private static Set<String> getTwoLetters(String nickName) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nickName.length() - 1; i++) {
            set.add(nickName.substring(i, i + 2));
        }
        return set;
    }
}
