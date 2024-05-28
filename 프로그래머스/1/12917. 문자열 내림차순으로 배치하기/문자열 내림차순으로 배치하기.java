import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        
        for(int i = sArr.length - 1; i >= 0; i--) {
            answer += sArr[i];
        }
        
        return answer;
    }
}