package onboarding;

import java.util.*;

public class Problem7 {

    static HashMap<String, Integer> map = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(5);

        List<String> userFriend = friendPoint(user, friends);
        visitorPoint(visitors, userFriend);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((entry1, entry2) -> {
            int valueComp = entry2.getValue().compareTo(entry1.getValue());
            if(valueComp == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            } else {
                return valueComp;
            }
        });

        for(int i = 0; i < Math.min(5, entries.size()); i++) { //리스트의 크기가 5보다 작은 경우, 범위를 리스트 크기에 맞추기 위해 사용
            answer.add(entries.get(i).getKey());
        }

        return answer;
    }

    public static List<String> friendPoint(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).contains(user)) {
                String friendName;
                if(friends.get(i).get(0) == user) friendName = friends.get(i).get(1);
                else friendName = friends.get(i).get(0);
                userFriend.add(friendName);

                for(int j = 0; j < friends.size(); j++) {
                    if(friends.get(j).contains(friendName) && !friends.get(j).contains(user)) {
                        String togetherKnownFriend;
                        if(friends.get(j).get(0) == friendName) togetherKnownFriend = friends.get(j).get(1);
                        else togetherKnownFriend = friends.get(j).get(0);
                        if(!map.containsKey(togetherKnownFriend))  {
                            map.put(togetherKnownFriend, 10);
                        } else {
                            int point = map.get(togetherKnownFriend);
                            map.put(togetherKnownFriend, point + 10);
                        }
                    }
                }
            }
        }
        return userFriend;
    }

    public static void visitorPoint(List<String> visitors, List<String> userFriend) {
        for(int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!userFriend.contains(name)) {
                if (map.containsKey(name)) {
                    int point = map.get(name);
                    map.put(name, point + 1);
                } else {
                    map.put(name, 1);
                }
            }
        }
    }
}
