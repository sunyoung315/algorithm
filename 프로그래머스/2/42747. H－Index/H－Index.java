import java.util.*; 

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 인용 횟수 오름차순 정렬
        Arrays.sort(citations);
        
        for(int n = 0; n < citations.length; n++) {
            // citations[n]번 이상 인용된 논문이 citations.length - n편 이상이면
            if(citations[n] >= citations.length - n)
                // H-Index는 citations.length - n
                return citations.length - n;
        }
        
        return answer;
    }
}