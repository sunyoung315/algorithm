import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // key: 신고 당한 user, value: key를 신고한 users
        Map<String, Set<String>> stopUser = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            // 0: 신고한 user, 1: 신고 당한 user
            String[] users = report[i].split(" ");
            
            // 신고당한 user를 key로, 신고한 user를 set에 넣어 중복 제거한 후 value로
            if(stopUser.containsKey(users[1])) {
                Set<String> set = stopUser.get(users[1]);
                set.add(users[0]);
                stopUser.put(users[1], set);
            } else {
                Set<String> set = new HashSet<>();
                set.add(users[0]);
                stopUser.put(users[1], set);
            }
        } 
        
        for(int i = 0; i < id_list.length; i++) {
            // 신고한 user
            String user = id_list[i];
            
            // 처리 결과 메일을 받은 횟수
            int num = 0;
            
            // map을 순환하기 위한 iterator
            Iterator iter = stopUser.keySet().iterator();
            // map 순회
            while(iter.hasNext()) {
                // map의 key
                String key = (String) iter.next();
                // 해당 key의 set
                Set<String> set = stopUser.get(key);
                // 신고한 user가 set에 있고 key인 user를 신고한 사람이 k명 이상이면 
                // 처리 결과 메일을 받으므로 num 증가
                if(set.contains(user) && set.size() >= k) {
                    num++;
                }
            }
            
            answer[i] = num;
        }
        return answer;
    }
}