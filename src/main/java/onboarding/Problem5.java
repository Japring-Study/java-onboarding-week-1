package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        if (money < 1 || money > 1000000) {
            return null;
        }

        List<Integer> answer = new ArrayList<>();
        final List<Integer> moneyUnit = List.of(
                50000,
                10000,
                5000,
                1000,
                500,
                100,
                50,
                10,
                1
        );

        for (int i = 0; i < moneyUnit.size(); i++) {
            answer.add(money / moneyUnit.get(i));
            money = money % moneyUnit.get(i);
        }
        return answer;
    }
}
