import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        // 배열을 queue로 변환
        Queue<String> q1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> q2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalQ = new LinkedList<>(Arrays.asList(goal));
        
        // goal에 있는 단어 하나씩 확인
        while(!goalQ.isEmpty()) {
            // cards1과 cards2에 가장 첫번째 단어 꺼내기(비어있으면 빈 문자열)
            String str1 = q1.isEmpty() ? "" : q1.peek();
            String str2 = q2.isEmpty() ? "" : q2.peek();
            
            // gaol에 있는 확인해야 하는 단어
            String g = goalQ.peek();
            
            // cards1에 있으면 cards1과 goal에서 둘 다 제거
            if(str1.equals(g)) {
                q1.poll();
                goalQ.poll();
            }
            // cards2에 있으면 cards2과 goal에서 둘 다 제거
            else if(str2.equals(g)) {
                q2.poll();
                goalQ.poll();
            }
            // 둘 다 없으면 순서대로 꺼내서 단어 배열을 만들 수 없으므로 반복문 종료
            else {
                break;
            }
        }
        
        // goal에 단어가 남아있는지 확인
        if(goalQ.isEmpty())
            return "Yes";
        return "No";
    }
}