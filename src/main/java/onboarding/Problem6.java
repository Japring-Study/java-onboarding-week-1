package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        if (forms.size() < 1 || forms.size() > 10000) {
            return null;
        }

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);

            if (!isValidEmail(email) || !isValidNickname(name) || answer.contains(email)) {
                continue;
            }

            checkDuplicateSubstrings(forms, i, name, email, answer);
        }

        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    private static void checkDuplicateSubstrings(List<List<String>> forms, int currentIndex, String currentName, String currentEmail, List<String> answer) {
        for (int j = currentIndex + 1; j < forms.size(); j++) {
            String compName = forms.get(j).get(1);
            String compEmail = forms.get(j).get(0);

            if (answer.contains(compEmail)) {
                continue;
            }

            if (hasDuplicateSubstring(currentName, compName)) {
                answer.add(compEmail);
                if (!answer.contains(currentEmail)) {
                    answer.add(currentEmail);
                }
            }
        }
    }

    private static boolean hasDuplicateSubstring(String name1, String name2) {
        for (int k = 0; k < name2.length() - 1; k++) {
            String subString = name2.substring(k, k + 2);
            if (name1.contains(subString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidEmail(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            return false;
        }
        String emailPattern = "^[a-zA-Z0-9._%+-]+@email\\.com$";
        return email.matches(emailPattern);
    }

    private static boolean isValidNickname(String name) {
        if (name.length() < 1 || name.length() >= 20) {
            return false;
        }
        String nicknamePattern = "^[가-힣]+$";
        return name.matches(nicknamePattern);
    }
}