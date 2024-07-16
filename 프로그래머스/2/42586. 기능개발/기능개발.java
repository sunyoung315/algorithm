import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            // 각 기능별 배포일 계산
            int day = (100 - progresses[i]) / speeds[i];
            day = (100 - progresses[i]) % speeds[i] > 0 ? day + 1 : day;
            // queue에 넣기
            queue.add(day);
        }
        
        // 경계점 표시
        queue.add(0);
        
        // 같은 날 배포될 기능의 개수
        int count = 0;
        // 오래 걸리는 기간
        int maxDay = queue.peek();
        // 경계점에 걸릴 때까지 반복
        while(!queue.peek().equals(0)) {
            // maxDay보다 짧게 걸리는 기능은 같이 배포되므로 count 증가
            int theDay = queue.poll();
            if(maxDay >= theDay) {
                count++;
            // 더 오래 걸리는 기능이 나오면 queue에 넣고 maxDay 갱신
            } else {
                queue.add(count);
                maxDay = theDay;
                count = 1;
            }
        }
        
        // 마지막 기능 배포 개수 queue에 넣기
        queue.add(count);
        // 경계점인 0 제거
        queue.poll();
        
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}