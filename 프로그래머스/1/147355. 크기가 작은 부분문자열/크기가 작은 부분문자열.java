class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
            for(int i = 0; i <= t.length() - p.length(); i++) {
                long tNum = Long.parseLong(t.substring(i, i + p.length()));
                long pNum = Long.parseLong(p);
                
                if(tNum <= pNum) {
                    answer++;
                }
            }    
        
        return answer;
    }
}