package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i<list.size(); i++){
            if (money>=list.get(i)){
                answer.add(money/list.get(i));
                money= money%list.get(i);
            }else {
                answer.add(0);
            }
        }

        return answer;
    }
}
