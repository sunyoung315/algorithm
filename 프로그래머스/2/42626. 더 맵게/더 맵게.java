import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            foods.offer(scoville[i]);
        }
        
        while(foods.peek() < K && foods.size() > 1) {
            int first = foods.poll();
            int second = foods.poll();
            
            foods.offer(first + second * 2);
            
            answer++;
        }
        
        if(foods.peek() >= K)
            return answer;
        return -1;
    }
}