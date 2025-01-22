import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        minPQ.offer(Integer.parseInt(operations[0].split(" ")[1]));
        
        out: for(int i = 1; i < operations.length; i++) {
            String[] arr = operations[i].split(" ");
            String order = arr[0];
            int num = Integer.parseInt(arr[1]);
            if(order.equals("I")) {
                if(minPQ.isEmpty())
                    maxPQ.offer(num);
                else
                    minPQ.offer(num);
            } else {
                if(maxPQ.isEmpty() && minPQ.isEmpty())
                    continue out;
                if(num == 1) {
                    if(maxPQ.isEmpty()) {
                        while(!minPQ.isEmpty()) {
                            maxPQ.offer(minPQ.poll());
                        }
                    }
                    maxPQ.poll();
                } else {
                    if(minPQ.isEmpty()) {
                        while(!maxPQ.isEmpty()) {
                            minPQ.offer(maxPQ.poll());
                        }
                    }
                    minPQ.poll();
                }
            }
        }
        
        if(!maxPQ.isEmpty()) {
            answer[0] = maxPQ.poll();
            while(maxPQ.size() > 1)
                maxPQ.poll();
            if(maxPQ.size() == 1)
                answer[1] = maxPQ.poll();
            else
                answer[1] = answer[0];
        } else if(!minPQ.isEmpty()) {
            answer[1] = minPQ.poll();
            while(minPQ.size() > 1)
                minPQ.poll();
            if(minPQ.size() == 1) 
                answer[0] = minPQ.poll();
            else 
                answer[0] = answer[1];
        }
        
        return answer;
    }
}