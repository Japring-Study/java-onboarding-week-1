package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        String pleft = String.valueOf(pobi.get(0));
        String pright = String.valueOf(pobi.get(1));

        int pleftNum = Integer.parseInt(pleft);  // pleft를 int로 변환
        int prightNum = Integer.parseInt(pright);  // pright를 int로 변환

        if (pleftNum+1 != prightNum){
            answer = -1;
            return answer;
        }

        int lsum = 0;
        for (int i = 0; i < pleft.length(); i++){
            char ch = pleft.charAt(i);
            lsum += Character.getNumericValue(ch);
        }
        int lmulti = 1;
        for (int i = 0; i < pleft.length(); i++){
            char ch = pleft.charAt(i);
            lmulti *= Character.getNumericValue(ch);
        }

        int rsum = 0;
        for (int i = 0; i < pright.length(); i++){
            char ch = pright.charAt(i);
            rsum += Character.getNumericValue(ch);
        }

        int rmulti = 1;
        for (int i = 0; i < pright.length(); i++){
            char ch = pright.charAt(i);
            rmulti *= Character.getNumericValue(ch);
        }

        int pmaxValue = Math.max(Math.max(lsum, lmulti), Math.max(rsum, rmulti));

        String cleft = String.valueOf(crong.get(0));
        String cright = String.valueOf(crong.get(1));

        int cleftNum = Integer.parseInt(cleft);  // pleft를 int로 변환
        int crightNum = Integer.parseInt(cright);  // pright를 int로 변환

        if (cleftNum+1 != crightNum){
            answer = -1;
            return answer;
        }

        int clsum = 0;
        for (int i = 0; i < cleft.length(); i++){
            char ch = cleft.charAt(i);
            clsum += Character.getNumericValue(ch);
        }
        int clmulti = 1;
        for (int i = 0; i < cleft.length(); i++){
            char ch = cleft.charAt(i);
            clmulti *= Character.getNumericValue(ch);
        }

        int crsum = 0;
        for (int i = 0; i < cright.length(); i++){
            char ch = cright.charAt(i);
            crsum += Character.getNumericValue(ch);
        }

        int crmulti = 1;
        for (int i = 0; i < cright.length(); i++){
            char ch = cright.charAt(i);
            crmulti *= Character.getNumericValue(ch);
        }

        int cmaxValue = Math.max(Math.max(clsum, clmulti), Math.max(crsum, crmulti));

        System.out.println("pmaxValue"+ pmaxValue+ "cmaxValue"+ cmaxValue);

        if (pmaxValue > cmaxValue){
            answer = 1;
        } else if (pmaxValue < cmaxValue) {
            answer = 2;
        }  else {
            answer = 0;
        }

        return answer;
    }
}