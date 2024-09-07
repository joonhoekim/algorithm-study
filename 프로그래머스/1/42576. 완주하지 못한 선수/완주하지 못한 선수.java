import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        // 후보자 기준으로 일단 다 세준다.
        for(String candidate : participant) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }
        
        // 완주자 기준으로 하나씩 빼 준다.
        for(String completed : completion) {
            map.put(completed, map.getOrDefault(completed,0) - 1);
        }
        
        // 이터레이터로 0이 아닌 candidate 이름을 찾는다.
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}