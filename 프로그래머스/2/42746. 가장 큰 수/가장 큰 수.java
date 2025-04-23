import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // int배열을 String배열로 변환 
        String[] stringNums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            stringNums[i] = String.valueOf(numbers[i]);
        }
        
        // 두 수를 붙였을 때 더 큰 숫자가 앞으로 오도록 정렬
        Arrays.sort(stringNums, (a, b) -> (b + a).compareTo(a + b));
        
        // 1. 가장 큰 수가 0이면 모든 배열의 숫자가 0이므로 0을 반환
        if(stringNums[0].equals("0"))
            return "0";
        
        // 2. 가장 큰 수가 0이 아니면 문자열 이어서 반환
        StringBuilder sb = new StringBuilder();
        for(String s : stringNums) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}