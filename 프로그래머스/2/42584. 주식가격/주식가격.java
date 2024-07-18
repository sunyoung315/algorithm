import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        out: for (int i = 0; i < prices.length; i++) {            
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[i] <= prices[j]) {
                    answer[i]++;
                } else {
                    answer[i]++;
                    continue out;
                }
            }
        }
        
        return answer;
    }
}