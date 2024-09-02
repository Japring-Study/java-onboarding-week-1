package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        Set<String> userFriends = new HashSet<>();

        // 사용자와 친구인 사람들 기록
        for (List<String> pair : friends) {
            String friendA = pair.get(0);
            String friendB = pair.get(1);

            if (friendA.equals(user)) {
                userFriends.add(friendB);
            } else if (friendB.equals(user)) {
                userFriends.add(friendA);
            }
        }

        // 함께 아는 친구 점수 계산
        for (List<String> pair : friends) {
            String friendA = pair.get(0);
            String friendB = pair.get(1);

            if (userFriends.contains(friendA) && !friendB.equals(user)) {
                scoreMap.put(friendB, scoreMap.getOrDefault(friendB, 0) + 10);
            }

            if (userFriends.contains(friendB) && !friendA.equals(user)) {
                scoreMap.put(friendA, scoreMap.getOrDefault(friendA, 0) + 10);
            }
        }

        // 타임라인 방문 점수 계산
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }

        // 사용자와 이미 친구인 사람들은 추천 목록에서 제거
        for (String friend : userFriends) {
            scoreMap.remove(friend);
        }

        // 점수 기준으로 정렬, 점수가 같다면 이름순으로 정렬
        List<String> result = new ArrayList<>(scoreMap.keySet());
        result.sort((a, b) -> {
            int scoreCompare = scoreMap.get(b) - scoreMap.get(a);
            if (scoreCompare != 0) {
                return scoreCompare;
            }
            return a.compareTo(b);
        });

        // 최대 5명까지만 추천
        if (result.size() > 5) {
            result = result.subList(0, 5);
        }

        return result;
    }

}
