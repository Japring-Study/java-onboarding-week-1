package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 길이 검증
        if (cryptogram == null || cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return "error";
        }
        // 알파벳 소문자 검증
        if (!cryptogram.matches("^[a-z]+$")) {
            return "error";
        }

        StringBuilder sb = new StringBuilder(cryptogram);

        while (true) {
            boolean changed = false;
            int count = 1;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    count++;
                    if(i + 1 == sb.length() - 1) {
                        sb.delete(i - count + 2, sb.length());
                        return sb.toString();
                    }
                } else {
                    if (count > 1) {
                        sb.delete(i - count + 1, i + 1);
                        changed = true;
                        i = Math.max(-1, i - count - 1); // 변경 후 이전 위치부터 다시 검사
                    }
                    count = 1;
                }
            }
            if (!changed) break;
        }

        return sb.toString();
    }
}
