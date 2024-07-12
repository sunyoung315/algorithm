import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 스테이지별 도전자 수
        int[] challenger = new int[N + 2];
        for(int i = 0; i < stages.length; i++) {
            challenger[stages[i]]++;
        }
        
        // 각 스테이지 별 도전자 수
        double total = stages.length;
        
        // 스테이지 별 실패율
        Map<Integer, Double> fails = new HashMap<>();
        
        for(int n = 1; n <= N; n++) {
            // 스테이지에 도달한 유저가 없으면 실패율 0
            if(challenger[n] == 0) {
                fails.put(n, 0.0);
            } else {
                // 실패율 계산
                fails.put(n, challenger[n] / total);
                // 다음 스테이지의 도전자 수 계산
                total -= challenger[n];
            }
            
        }
        
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(fails.entrySet());
        // value를 기준으로 내림차순 정렬
        entryList.sort((e1, e2) -> fails.get(e2.getKey()).compareTo(fails.get(e1.getKey())));
        
        // Iterator를 이용한 반복문
        Iterator<Map.Entry<Integer, Double>> iter = entryList.iterator();
        int idx = 0;
        while(iter.hasNext()) {
            answer[idx++] = iter.next().getKey();
        }
        
        return answer;
        
        // return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}