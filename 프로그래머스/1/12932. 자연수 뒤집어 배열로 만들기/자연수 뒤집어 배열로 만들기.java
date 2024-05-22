import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        String num = Long.toString(n);
        answer = new int[num.length()];
        
        int idx = 0;
        for(int i = num.length() - 1; i >= 0; i--) {
            answer[idx++] = num.charAt(i) - '0';
        }
        
        return answer;
    }
}