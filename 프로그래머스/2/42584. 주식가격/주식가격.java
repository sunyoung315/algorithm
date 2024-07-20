import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // prices의 인덱스를 저장하기 위한 스택
        Stack<Integer> stack = new Stack<>();
        // 0번 인덱스를 넣고 시작
        stack.push(0);
        
        // 1번부터 비교
        for(int i = 1; i < prices.length; i++) {
            // i번째 주식 가격이 stack에 들어있는 이전 주식가격보다 떨어졌는지 확인
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 떨어졌으면 stack에서 이전 인덱스 꺼내서 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            // 가격이 떨어지지 않았으면 stack에 인덱스 넣기
            stack.push(i);
        }
        
        // stack에 남아있는 인덱스들은 끝까지 가격이 떨어지지 않은 경우
        while(!stack.isEmpty()) {
            // 인덱스를 확인하여 기간 계산
            int i = stack.pop();
            answer[i] = prices.length - i - 1;
        }
        
        return answer;
    }
}