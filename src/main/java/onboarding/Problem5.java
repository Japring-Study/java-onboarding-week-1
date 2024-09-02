package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int oman = money/50000;
        int man = money%50000/10000;
        int ochun = money%50000%10000/5000;
        int chun = money%50000%10000%5000/1000;
        int obaek = money%50000%10000%5000%1000/500;
        int baek = money%50000%10000%5000%1000%500/100;
        int osip = money%50000%10000%5000%1000%500%100/50;
        int sip = money%50000%10000%5000%1000%500%100%50/10;
        int il = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10;

        answer.add(oman);
        answer.add(man);
        answer.add(ochun);
        answer.add(chun);
        answer.add(obaek);
        answer.add(baek);
        answer.add(osip);
        answer.add(sip);
        answer.add(il);

        return answer;
    }
}
