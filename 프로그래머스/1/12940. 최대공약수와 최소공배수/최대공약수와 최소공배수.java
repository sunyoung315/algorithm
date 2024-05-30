import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {1, 1};
        
        int big = n > m ? n : m;
        
        int N = n;
        int M = m;        
        for(int i = big; i >= 1; i--) {
            if(N % i == 0 && M % i == 0) {
                answer[0] *= i;
                N /= i;
                M /= i;            
            }
        }
        
        answer[1] = answer[0] * (n / answer[0]) * (m / answer[0]);
        
        return answer;
    }
}