package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        Set<String> userFriends = new HashSet<>();

        // 사용자와 직접 친구인 사람들을 Set에 추가
        for (List<String> pair : friends) {
            String friendA = pair.get(0);
            String friendB = pair.get(1);

            // user와 직접 연결된 친구 목록 수집
            if (friendA.equals(user)) {
                userFriends.add(friendB);
            } else if (friendB.equals(user)) {
                userFriends.add(friendA);
            }
        }

        // 사용자와 공통으로 아는 친구가 있는 경우 점수 추가
        for (List<String> pair : friends) {
            String friendA = pair.get(0);
            String friendB = pair.get(1);

            // friendA와 friendB가 모두 사용자의 친구가 아니고, 사용자 자신도 아닐 때
            if (userFriends.contains(friendA) && !userFriends.contains(friendB) && !friendB.equals(user)) {
                scoreMap.put(friendB, scoreMap.getOrDefault(friendB, 0) + 10);
            }
            if (userFriends.contains(friendB) && !userFriends.contains(friendA) && !friendA.equals(user)) {
                scoreMap.put(friendA, scoreMap.getOrDefault(friendA, 0) + 10);
            }
        }

        // 타임라인 방문 점수 추가
        for (String visitor : visitors) {
            // 방문자가 사용자의 직접 친구가 아닌 경우만 점수 추가
            if (!userFriends.contains(visitor) && !visitor.equals(user)) {
                scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
            }
        }

        // 점수가 0이 아닌 사용자만 필터링하고 정렬
        List<String> recommendations = new ArrayList<>(scoreMap.keySet());
        recommendations.sort((a, b) -> {
            int scoreCompare = scoreMap.get(b) - scoreMap.get(a);
            if (scoreCompare == 0) {
                return a.compareTo(b);
            }
            return scoreCompare;
        });

        // 최대 5명만 반환
        return recommendations.subList(0, Math.min(5, recommendations.size()));
    }
}
