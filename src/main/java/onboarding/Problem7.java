package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Problem7 {

    private final static int FRIEND_OF_FRIEND_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> friendsPerUser = getFriends(friends);

        Map<String, Integer> friendsScore = getFriendsScore(user, friendsPerUser);
        Map<String, Integer> friendsScoreWithVisitors = addVisitorsToScore(visitors, friendsScore);

        return getRecommend(friendsScoreWithVisitors, friendsPerUser.getOrDefault(user, new ArrayList<>()));
    }

    private static List<String> getRecommend(Map<String, Integer> friendsScoreWithVisitors, List<String> userFriends) {
        return friendsScoreWithVisitors.entrySet().stream()
                .filter(e -> !userFriends.contains(e.getKey()))
                .filter(e -> e.getValue() != 0)
                .sorted(Problem7::compareToScore)
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static int compareToScore(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue().equals(e2.getValue())) {
            return e1.getKey().compareTo(e2.getKey());
        }
        return e2.getValue() - e1.getValue();
    }

    private static Map<String, Integer> addVisitorsToScore(List<String> visitors, Map<String, Integer> friendsScore) {
        HashMap<String, Integer> friendsScoreWithVisitors = new HashMap<>(friendsScore);

        for (String visitor : visitors) {
            friendsScoreWithVisitors.put(visitor, friendsScoreWithVisitors.getOrDefault(visitor, 0) + 1);
        }
        return friendsScoreWithVisitors;
    }

    private static Map<String, Integer> getFriendsScore(String user, Map<String, List<String>> friendsPerUser) {
        Map<String, Integer> score = new HashMap<>();

        for (String friend: friendsPerUser.getOrDefault(user, new ArrayList<>())) {
            for (String friendOfFriend : friendsPerUser.getOrDefault(friend, new ArrayList<>())) {
                if (!friendOfFriend.equals(user)) {
                    score.put(friendOfFriend, score.getOrDefault(friendOfFriend, 0) + FRIEND_OF_FRIEND_SCORE);
                }
            }
        }
        return score;
    }

    private static Map<String, List<String>> getFriends(List<List<String>> friends) {
        Map<String, List<String>> friendsPerUser = new HashMap<>();

        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if (!friendsPerUser.containsKey(user1)) {
                friendsPerUser.put(user1, new ArrayList<>());
            }
            if (!friendsPerUser.containsKey(user2)) {
                friendsPerUser.put(user2, new ArrayList<>());
            }
            friendsPerUser.get(user1).add(user2);
            friendsPerUser.get(user2).add(user1);
        }

        return friendsPerUser;
    }
}
