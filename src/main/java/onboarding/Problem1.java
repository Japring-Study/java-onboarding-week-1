package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        // 예외 처리
        if(pobi.size() != 2 || crong.size() != 2) {
            return -1;
        }
        if(pobi.get(0) <= 1 || crong.get(0) <= 1 || pobi.get(1) >= 400 || crong.get(1) >= 400) {
            return -1;
        }
        if(pobi.get(1) <= pobi.get(0) || pobi.get(1) - pobi.get(0) != 1 || crong.get(1) <= crong.get(0) || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        if(pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            return -1;
        }

        int pobiSum = maxSum(pobi);
        int crongSum = maxSum(crong);
        if(pobiSum > crongSum) answer = 1;
        else if(pobiSum < crongSum) answer = 2;
        else answer = 0;

        return answer;
    }
    public static List<Integer> splitDigit(int number) {
        List<Integer> result = new ArrayList<>();

        while(number > 0) {
            result.add(0, number % 10);
            number = number / 10;
        }
        return result;
    }

    public static Integer plusAll(List<Integer> allDigit) {
        int sum = 0;
        for(int i = 0; i < allDigit.size(); i++) {
            sum += allDigit.get(i);
        }
        return sum;
    }

    public static Integer multiplyAll(List<Integer> allDigit) {
        int sum = 1;
        for(int i = 0; i < allDigit.size(); i++) {
            sum *= allDigit.get(i);
        }
        return sum;
    }

    public static Integer plusMultiplyComp(Integer LR) {
        List<Integer> LRDigit = splitDigit(LR);
        int plusLeftSum = plusAll(LRDigit);
        int multiplyLeftSum = multiplyAll(LRDigit);
        return Math.max(plusLeftSum, multiplyLeftSum);
    }

    public static Integer maxSum(List<Integer> user) {
        int maxLeftSum = plusMultiplyComp(user.get(0));
        int maxRightSum = plusMultiplyComp(user.get(1));

        return Math.max(maxLeftSum, maxRightSum);
    }
}