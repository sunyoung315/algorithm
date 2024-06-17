class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            char alphabet = my_string.charAt(i);
            if((int) alphabet >= 97)
                answer += (char) ((int) alphabet - 32);
            else
                answer += (char) ((int) alphabet + 32);
        }
        
        return answer;
    }
}