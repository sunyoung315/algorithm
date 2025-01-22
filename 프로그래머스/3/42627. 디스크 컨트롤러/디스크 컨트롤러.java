import java.util.*;

class Solution {
    class Job {
        // 작업 번호
        int num;
        // 요청 시각
        int req;
        // 소요 시간
        int time;
        
        public Job(int num, int req, int time) {
            this.num = num;
            this.req = req;
            this.time = time;
        }
        
        public String toString() {
            return "num=" + num + " req=" + req + " time=" + time;
        }
    }
    public int solution(int[][] jobs) {
        // 누적 반환시간
        int answer = 0;
        
        // 요청 시각을 기준으로 작업 배열 정렬
        Arrays.sort(jobs, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
        // 작업 배열 -> 큐
        Queue<Job> jobQ = new LinkedList<>();
        for(int i = 0; i < jobs.length; i++) {
            jobQ.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        // 우선순위에 따른 대기큐
        PriorityQueue<Job> waitQ = new PriorityQueue<>((a, b) -> {
            if(a.time != b.time)
                return a.time - b.time;
            else if(a.req != b.req)
                return a.req - b.req;
            else
                return a.num - b.num;
        });
        
        // 새로운 작업을 시작할 시간
        int time = 0;
        
        // 첫번째 작업을 대기 큐에 넣고 첫번째 작업을 시작하는 시간 갱신
        Job first = jobQ.poll();
        time = first.req;
        waitQ.offer(first);
        
        while(!jobQ.isEmpty() || !waitQ.isEmpty()) {
            if(!waitQ.isEmpty()) {
                //현재 작업
                Job curr = waitQ.poll();
                
                // 다음 시작 시간 갱신
                time += curr.time;
                // 현재 작업의 반환시간 누적
                answer += (time - curr.req);
                
                // 작업이 수행되는 동안 대기큐에 들어온 작업들 넣기
                while(!jobQ.isEmpty()) {
                    if(jobQ.peek().req <= time)
                        waitQ.offer(jobQ.poll());
                    else
                        break;
                }
            } else {
                // 대기큐에 새로운 작업 넣기
                Job next = jobQ.poll();
                waitQ.offer(next);
                // 시작시간 갱신
                time = next.req;
            }
        }
        
        return answer / jobs.length;
    }
}