package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

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
}
