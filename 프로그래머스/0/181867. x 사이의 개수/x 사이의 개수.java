import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        
        // x를 기준으로 문자열 나누기
        String[] str = myString.split("x");
        
        // 마지막 문자가 x일 경우 빈 문자가 str에 포함되지 않기 때문에 
        // str의 길이보다 1개 크게 answer 배열 생성
        if(myString.charAt(myString.length() - 1) == 'x')
            answer = new int[str.length + 1];
        else
            answer = new int[str.length];
        
        // str 배열에 담겨있는 각 문자열의 길이 입력
        for(int i = 0; i < str.length; i++) {
            answer[i] = str[i].length();
        }
        
        return answer;
    }
}