package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiLeftSum = 0, pobiLeftMulti = 1;
        while (pobiLeft > 0) {
            int index = pobiLeft % 10;
            pobiLeftSum += index;
            pobiLeftMulti *= index;
            pobiLeft /= 10;
        }
        //pobi Left

        int pobiRight = pobi.get(1);
        int pobiRightSum = 0, pobiRightMulti = 1;

        while (pobiRight > 0) {
            int index = pobiRight % 10;
            pobiRightSum += index;
            pobiRightMulti *= index;
            pobiRight /= 10;
        }
        //pobiRight

        int pobiScore = Math.max(pobiLeftSum, pobiLeftMulti);
        pobiScore = Math.max(pobiScore, Math.max(pobiRightSum, pobiRightMulti));
        //pobiSocore

        int crongLeft = crong.get(0);
        int crongLeftSum = 0, crongLeftMulti = 1;
        while (crongLeft > 0) {
            int index = crongLeft % 10;
            crongLeftSum += index;
            crongLeftMulti *= index;
            crongLeft /= 10;
        }
        //crongLeft

        int crongRight = crong.get(1);
        int crongRightSum = 0, crongRightMulti = 1;
        while (crongRight > 0) {
            int index = crongRight % 10;
            crongRightSum += index;
            crongRightMulti *= index;
            crongRight /= 10;
        }
        //crongRight

        int crongScore = Math.max(crongLeftSum, crongLeftMulti);
        crongScore = Math.max(crongScore, Math.max(crongRightSum, crongRightMulti));
        //crongScore

        if (pobiScore > crongScore) return 1;
        else if (crongScore > pobiScore) return 2;
        else return 0;


    }
}