package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> recommendedFriends = new ArrayList<>(5);
        HashMap<String, Integer> friendScores = new HashMap<>();

        List<String> userFriends = calculateFriendPoints(user, friends, friendScores);
        calculateVisitorPoints(visitors, userFriends, friendScores);

        List<Map.Entry<String, Integer>> sortedFriendEntries = new ArrayList<>(friendScores.entrySet());

        sortedFriendEntries.sort((entry1, entry2) -> {
            int scoreComparison = entry2.getValue().compareTo(entry1.getValue());
            if(scoreComparison == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            } else {
                return scoreComparison;
            }
        });

        for(int i = 0; i < Math.min(5, sortedFriendEntries.size()); i++) {
            recommendedFriends.add(sortedFriendEntries.get(i).getKey());
        }

        return recommendedFriends;
    }

    private static List<String> calculateFriendPoints(String user, List<List<String>> friends, HashMap<String, Integer> friendScores) {
        List<String> userFriends = new ArrayList<>();

        for(List<String> friendPair : friends) {
            if(friendPair.contains(user)) {
                String friend = friendPair.get(0).equals(user) ? friendPair.get(1) : friendPair.get(0);
                userFriends.add(friend);

                for (List<String> mutualFriendPair : friends) {
                    if (mutualFriendPair.contains(friend) && !mutualFriendPair.contains(user)) {
                        String mutualFriend = mutualFriendPair.get(0).equals(friend) ? mutualFriendPair.get(1) : mutualFriendPair.get(0);

                        int currentScore = friendScores.getOrDefault(mutualFriend, 0);
                        friendScores.put(mutualFriend, currentScore + 10);
                    }
                }
            }
        }
        return userFriends;
    }

    private static void calculateVisitorPoints(List<String> visitors, List<String> userFriends, HashMap<String, Integer> friendScores) {
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                int currentScore = friendScores.getOrDefault(visitor, 0);
                friendScores.put(visitor, currentScore + 1);
            }
        }
    }
}
