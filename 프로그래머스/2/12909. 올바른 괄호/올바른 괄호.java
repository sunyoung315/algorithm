import java.util.Stack;

class Solution {
    boolean solution(String s) {        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            // 1. 닫힌 괄호
            if(s.charAt(i) == ')')
                // 1-1. stack이 비어있는데 닫는 괄호가 들어가면 괄호가 완성될 수 없음
                if(stack.isEmpty())
                    return false;
                // 1-2. stack이 비어있지 않으면 열린 괄호가 있는 것
                // 괄호를 완성시키기 위해 마지막에 들어간 열린 괄호 꺼내기
                else 
                    stack.pop();
            // 2. 열린 괄호가 나오면 stack에 넣기 
            else if(s.charAt(i) == '(') 
                stack.push('(');
        }
        
        if(!stack.isEmpty())
            return false;
        return true;
    }
}