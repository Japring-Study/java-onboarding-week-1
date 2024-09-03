package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> map = new TreeMap<>();

        // user의 친구리스트 생성
        List<String> list = new ArrayList<>();

        for(int i = 0; i< friends.size(); i++){
            List<String> target = friends.get(i);
            String target1 = target.get(0);
            String target2 = target.get(1);
            if (target1.equals(user)){
                list.add(target2);
            } else if (target2.equals(user)){
                list.add(target1);
            }
        }


        // 친구의 친구 조회후 값 추가
        for(int j = 0; j<list.size(); j++){
            for (int jj = 0; jj<friends.size(); jj++) {
                List<String> target = friends.get(jj);
                String target1 = target.get(0);
                String target2 = target.get(1);

                if (list.get(j).equals(target1)) {
                    if (map.containsKey(target2)) {
                        int tmpV = map.get(target2);
                        tmpV += 10;
                        map.put(target2, tmpV);
                    } else {
                        map.put(target2, 10);
                    }
                } else if (list.get(j).equals(target2)) {
                    if (map.containsKey(target1)) {
                        int tmpV = map.get(target1);
                        tmpV += 10;
                        map.put(target1, tmpV);
                    } else {
                        map.put(target1, 10);
                    }
                }
            }
        }

        for(int v = 0; v<visitors.size(); v++){
            String target = visitors.get(v);
            if (map.containsKey(target)){
                int tmpV = map.get(target);
                tmpV+=1;
                map.put(target, tmpV);
            } else{
                map.put(target, 1);
            }
        }


        // user가 속하면 삭제
        if(map.containsKey(user)){
            map.remove(user);
        }

        // 친구가 속하면 삭제

        for(int i = 0; i<list.size(); i++){
            String targetF = list.get(i);
            System.out.println("targetF"+ targetF);
            if(map.containsKey(targetF)){
                map.remove(targetF);
            }
        }

        // map을 value값으로 정렬하기
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            if (valueComparison == 0){
                return entry1.getKey().compareTo(entry2.getKey());
            } else{
                return valueComparison;
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        List<String> answer = new ArrayList<>(sortedMap.keySet());

        return answer;
    }
}
