package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        if(forms.size() < 1 || forms.size() > 10000) {
            return null;
        }

        for(int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            // 이메일 검증: 이메일 형식이 올바르고 email.com 도메인만 허용
            if (!isValidEmail(email)) {
                continue;
            }

            // 닉네임 검증: 닉네임이 한글만 포함
            if (!isValidNickname(name)) {
                continue;
            }

            if(answer.contains(email)) continue;

            for(int j = i + 1; j < forms.size(); j++) {
                String compName = forms.get(j).get(1);
                String compEmail = forms.get(j).get(0);

                if(answer.contains(compEmail)) continue;

                for(int k = 0; k < compName.length() - 1; k++) {
                    String subString = compName.substring(k, k + 2);
                    if(name.contains(subString)) {
                        answer.add(forms.get(j).get(0));
                        if(!answer.contains(email)) {
                            answer.add(forms.get(i).get(0));
                        }
                        break;
                    }
                }

            }
        }
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    private static boolean isValidEmail(String email) {
        if(email.length() < 11 || email.length() >= 20) {
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
