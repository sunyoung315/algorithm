import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        // 원하는 품목과 수량 map에 넣기
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        out: for(int i = 0; i <= discount.length - 10; i++) {
            // map 복제
            Map<String, Integer> newMap = new HashMap<>(map);
            
            // discount의 연속 10개씩 확인
            for(int j = i; j < i + 10; j++) {
                // 사고 싶은 품목에 없거나 사야할 개수가 0이면 종료
                if(!newMap.containsKey(discount[j]) || newMap.get(discount[j]) == 0)
                    continue out;
                else
                    // 사야할 품목이 있으면 개수 감소
                    newMap.put(discount[j], newMap.get(discount[j]) - 1);  
            }
            // 반복문을 통과해 여기 오면 모든 품목을 살 수 있는 경우이므로 answer 증가
            answer++;
        }
        
        return answer;
    }
}