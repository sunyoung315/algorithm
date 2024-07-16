import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        
        // 왼쪽으로 회전했을 때의 시작점
        out: for(int i = 0; i < s.length() - 1; i++) {
            // 회전시킨 문자열 순회
            for(int j = i; j < i + s.length(); j++) {
                char c = s.charAt(j % s.length());
                // 1. 닫힌 괄호일 때
                if(c == ')' || c == ']' || c == '}') 
                    // 1-1. stack이 비어있으면 올바르지 않은 괄호임
                    if(stack.isEmpty()) {
                        continue out;
                    }
                    // 1-2. stack이 비어있지 않으면
                    else {
                        // 1-2(1). 짝이 맞으면 stack에서 제거
                        if((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[')
                        || (c == '}' && stack.peek() == '{'))
                            stack.pop();
                        // 1-2(2). 짝이 맞지 않으면 올바르지 않은 괄호이므로 종료
                        else {
                            stack.clear();
                            continue out;
                        }
                    }
                // 2. 열린 괄호일 때는 stack에 넣기
                else {
                    stack.push(c);
                }
            } // for j
            
            // 문자열 순회 종료 후, stack이 비어있으면 올바른 괄호
            if(stack.isEmpty())
                answer++;             
        } // for i
        
        return answer;
    }
}