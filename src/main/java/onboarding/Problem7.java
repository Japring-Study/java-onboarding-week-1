package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
