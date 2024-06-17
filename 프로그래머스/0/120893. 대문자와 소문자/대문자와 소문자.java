class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            char alphabet = my_string.charAt(i);
            if(alphabet >= 97)
                answer += (char)(alphabet - 32);
            else
                answer += (char)(alphabet + 32);
        }
        
        return answer;
    }
}