package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 화폐 단위를 큰 순서대로 리스트에 저장
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        // 각 화폐 단위에 대해 몫을 구하고 나머지를 계산
        for (int unit : units) {
            result.add(money / unit);  // 화폐 개수
            money %= unit;  // 남은 금액
        }

        return result;
    }

}
