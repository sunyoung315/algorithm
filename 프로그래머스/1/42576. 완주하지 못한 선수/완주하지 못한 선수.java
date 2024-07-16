import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 완주자 리스트를 set으로 변환
        Map<String, Integer> map = new HashMap<>();
        for(String p: completion) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        
        for(String p: participant) {
            // 완주자에 이름이 없으면 반환
            if(!map.containsKey(p)) {
                return p;
            } 
            // 완주자에 있으면 동명이인 체크
            else {
                if(map.get(p) == 1) {
                    map.remove(p);
                } else {
                    map.put(p, map.get(p) - 1);
                }
            }
        }
        
        return null;
    }
}