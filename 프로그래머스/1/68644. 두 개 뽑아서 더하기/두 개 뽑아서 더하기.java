import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                ts.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = new int[ts.size()];
        
        int idx = 0;
        Iterator<Integer> iter = ts.iterator();
        while(iter.hasNext()) {
            answer[idx++] = iter.next().intValue();
        }
           
        
        return answer;
    }
}