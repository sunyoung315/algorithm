class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(); 
        
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            
            if(num >= 'a' && num <= 'z') {
                num = num + n > 'z' ? num + n - 26 : num + n;
            } else if(num >= 'A' && num <= 'Z') {
                num = num + n > 'Z' ? num + n - 26 : num + n;
            }
            
            sb.append((char) num);
        }
        
        return sb.toString();
    }
}