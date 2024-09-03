package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 일단 forms 순회 - 타겟 선정
        for (int i = 0; i<forms.size(); i++){
            List<String> target = forms.get(i);
            int targetIndex = i;

            // 선정한 타겟의 두글자 순회
            String targetStr = target.get(1);
            for (int t = 0; t<targetStr.length(); t++) {
                if (t == targetStr.length()-1){
                    break;
                }
                // 두글자 생성
                String checkS = "" + targetStr.charAt(t) + targetStr.charAt(t+1);

                // 타겟 이외의 것들 순회
                for (int j = 0; j < forms.size(); j++) {
                    if (targetIndex == j) {
                        continue;
                    }
                    List<String> target2 = forms.get(j);
                    String targetStr2 = target2.get(1);
                    // 비교할 새로운 두글자 생성
                    int check = 0;
                    for (int tt = 0; tt<targetStr2.length(); tt++) {
                        if (check==1){
                            answer.add(target2.get(0));
                            check = 0;
                            break;
                        }

                        if (tt == targetStr2.length() - 1) {
                            break;
                        }
                        // 두글자 생성
                        String checkSS = "" + targetStr2.charAt(tt) + targetStr2.charAt(tt + 1);

                        if (checkS.equals(checkSS)){
                            check = 1;
                        }
                    }
                }
            }
        }

        Set<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);

        return answer;
    }
}
