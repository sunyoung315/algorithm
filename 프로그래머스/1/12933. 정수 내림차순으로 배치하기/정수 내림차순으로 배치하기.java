import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] num = Long.toString(n).split("");
        Arrays.sort(num, Collections.reverseOrder());
        
        String str = "";
        for(int i = 0; i < num.length; i++) {
            str += num[i];
        }
        
        return Long.parseLong(str);
    }
}