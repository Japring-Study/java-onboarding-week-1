package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        // 예외 처리 함수 호출
        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return -1;
        }

        int pobiMaxScore = calculateMaxPageScore(pobi);
        int crongMaxScore = calculateMaxPageScore(crong);
        if (pobiMaxScore > crongMaxScore) return 1;
        else if (pobiMaxScore < crongMaxScore) return 2;

        return answer;
    }

    // 예외 처리 함수
    public static boolean isValidInput(List<Integer> pages) {
        if (pages.size() != 2) {
            return false;
        }
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 페이지 번호가 범위를 벗어나는 경우
        if (leftPage <= 1 || rightPage >= 400) {
            return false;
        }

        // 페이지 순서가 잘못되었거나 차이가 1이 아닌 경우
        if (rightPage <= leftPage || rightPage - leftPage != 1) {
            return false;
        }

        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수이어야 함
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }

        return true;
    }

    public static List<Integer> splitDigits(int number) {
        List<Integer> result = new ArrayList<>();

        while (number > 0) {
            result.add(0, number % 10);
            number = number / 10;
        }
        return result;
    }

    public static Integer sumDigits(List<Integer> digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static Integer multiplyDigits(List<Integer> digits) {
        int product = 1;
        for (int digit : digits) {
            product *= digit;
        }
        return product;
    }

    public static Integer calculateMaxSumOrProduct(Integer page) {
        List<Integer> pageDigits = splitDigits(page);
        int sumOfDigits = sumDigits(pageDigits);
        int productOfDigits = multiplyDigits(pageDigits);
        return Math.max(sumOfDigits, productOfDigits);
    }

    public static Integer calculateMaxPageScore(List<Integer> user) {
        int maxLeftPageScore = calculateMaxSumOrProduct(user.get(0));
        int maxRightPageScore = calculateMaxSumOrProduct(user.get(1));

        return Math.max(maxLeftPageScore, maxRightPageScore);
    }
}
