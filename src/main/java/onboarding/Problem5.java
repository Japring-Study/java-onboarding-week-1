package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        if(money < 1 || money > 1000000) {
            return null;
        }

        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnit = new ArrayList<>() {{
            add(50000);
            add(10000);
            add(5000);
            add(1000);
            add(500);
            add(100);
            add(50);
            add(10);
            add(1);
        }};

        for(int i = 0; i < moneyUnit.size(); i++) {
            answer.add(money / moneyUnit.get(i));
            money = money % moneyUnit.get(i);
        }
        return answer;
    }
}
