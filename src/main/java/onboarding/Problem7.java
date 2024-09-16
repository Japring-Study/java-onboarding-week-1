package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 예외 처리 함수 호출
        validateInput(user, friends, visitors);

        List<String> recommendedFriends = new ArrayList<>(5);
        HashMap<String, Integer> friendScores = new HashMap<>();

        List<String> userFriends = extractUserFriends(user, friends);
        addMutualFriendPoints(user, friends, friendScores, userFriends);
        calculateVisitorPoints(visitors, userFriends, friendScores);

        List<Map.Entry<String, Integer>> sortedFriendEntries = sortFriendScores(friendScores);

        for (int i = 0; i < Math.min(5, sortedFriendEntries.size()); i++) {
            recommendedFriends.add(sortedFriendEntries.get(i).getKey());
        }

        return recommendedFriends;
    }

    // 예외 처리 함수
    private static void validateInput(String user, List<List<String>> friends, List<String> visitors) {
        // 사용자 ID 길이 및 알파벳 소문자 검증
        if (user == null || user.length() < 1 || user.length() > 30 || !user.matches("[a-z]+")) {
            throw new IllegalArgumentException("사용자 ID는 1자 이상 30자 이하의 알파벳 소문자여야 합니다.");
        }

        // friends 리스트 크기 및 각 원소 검증
        if (friends == null || friends.size() < 1 || friends.size() > 10000) {
            throw new IllegalArgumentException("friends 리스트는 1 이상 10,000 이하이어야 합니다.");
        }
        for (List<String> friendPair : friends) {
            if (friendPair == null || friendPair.size() != 2) {
                throw new IllegalArgumentException("friends 리스트의 각 원소는 정확히 2개의 아이디로 이루어져야 합니다.");
            }
            for (String id : friendPair) {
                if (id == null || id.length() < 1 || id.length() > 30 || !id.matches("[a-z]+")) {
                    throw new IllegalArgumentException("친구 아이디는 1자 이상 30자 이하의 알파벳 소문자여야 합니다.");
                }
            }
        }

        // visitors 리스트 크기 및 각 원소 검증
        if (visitors == null || visitors.size() > 10000) {
            throw new IllegalArgumentException("visitors 리스트는 0 이상 10,000 이하이어야 합니다.");
        }
        for (String visitor : visitors) {
            if (visitor == null || visitor.length() < 1 || visitor.length() > 30 || !visitor.matches("[a-z]+")) {
                throw new IllegalArgumentException("방문자 아이디는 1자 이상 30자 이하의 알파벳 소문자여야 합니다.");
            }
        }
    }

    // 사용자 친구 목록 추출
    private static List<String> extractUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friendPair : friends) {
            if (friendPair.contains(user)) {
                String friend = friendPair.get(0).equals(user) ? friendPair.get(1) : friendPair.get(0);
                userFriends.add(friend);
            }
        }
        return userFriends;
    }

    // 함께 아는 친구에게 점수 추가
    private static void addMutualFriendPoints(String user, List<List<String>> friends, HashMap<String, Integer> friendScores, List<String> userFriends) {
        for (String friend : userFriends) {
            for (List<String> mutualFriendPair : friends) {
                if (mutualFriendPair.contains(friend) && !mutualFriendPair.contains(user)) {
                    String mutualFriend = mutualFriendPair.get(0).equals(friend) ? mutualFriendPair.get(1) : mutualFriendPair.get(0);

                    int currentScore = friendScores.getOrDefault(mutualFriend, 0);
                    friendScores.put(mutualFriend, currentScore + 10);
                }
            }
        }
    }

    private static void calculateVisitorPoints(List<String> visitors, List<String> userFriends, HashMap<String, Integer> friendScores) {
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                int currentScore = friendScores.getOrDefault(visitor, 0);
                friendScores.put(visitor, currentScore + 1);
            }
        }
    }

    // 정렬 함수
    private static List<Map.Entry<String, Integer>> sortFriendScores(HashMap<String, Integer> friendScores) {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(friendScores.entrySet());

        sortedEntries.sort((entry1, entry2) -> {
            int scoreComparison = entry2.getValue().compareTo(entry1.getValue());
            if (scoreComparison == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return scoreComparison;
        });

        return sortedEntries;
    }
}