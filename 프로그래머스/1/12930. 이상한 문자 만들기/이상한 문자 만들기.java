class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.substring(i, i+1).equals(" ")) {
                sb.append(" ");
                idx = 0;
            }
            else if(idx % 2 == 0) {
                sb.append(s.substring(i, i+1).toUpperCase());
                idx++;
            } else {
                sb.append(s.substring(i, i+1).toLowerCase());
                idx++;
            }
        }
        
        return sb.toString();
    }
}