import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = d.length;
        
        Arrays.sort(d);
        
        int sum = 0;
        
        for(int i = 0; i < d.length; i++){
            sum += d[i];
        }
        
        for(int i = d.length - 1; i >= 0; i--) {
            if(budget < sum) {
                sum -= d[i];
                answer--;
            } else
                return answer;
        }
        
        return answer;
    }
}