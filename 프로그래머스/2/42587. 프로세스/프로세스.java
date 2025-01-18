import java.util.*;

class Solution {
    
    class Node implements Comparable {
        int index;
        int priority;
        
        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            return this.priority > node.priority ? 1 : -1;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Node(i, priorities[i]));
        }
        
        while(!queue.isEmpty()) {
            // 현재 실행대기 큐에 있는 최대 우선순위 값
            int max = Collections.max(queue).priority;
            
            Node curr = queue.poll();
            
            if(curr.priority != max) {
                queue.offer(curr);
            }
            else {
                if(curr.index != location)
                    answer++;
                else
                    return answer + 1;
            }
                
        }
        
        return answer;
    }
}