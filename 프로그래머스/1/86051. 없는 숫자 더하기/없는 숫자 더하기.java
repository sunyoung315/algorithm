class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] exist = new boolean[10];
        for(int i = 0; i < numbers.length; i++) {
            exist[numbers[i]] = true;
        }
        
        for(int i = 0; i < exist.length; i++) {
            if(!exist[i]) 
                answer += i;
        }
        
        return answer;
    }
}