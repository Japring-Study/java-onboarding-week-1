package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static List<Integer> currencies = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return getCounts(money);
    }

    private static List<Integer> getCounts(int money) {

        int currentMoney = money;

        List<Integer> counts = new ArrayList<>();
        for (int currency: currencies) {

            int count = getCount(currentMoney, currency);

            counts.add(count);
            currentMoney -= count * currency;
        }
        return counts;
    }

    private static int getCount(int money, int currency) {
        return money / currency;
    }
}
