class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        
        int n = cipher.length() / code;
        
        for(int i = 1; i <= n; i++) {
            answer += cipher.charAt(i * code - 1);
        }
        
        return answer;
    }
}