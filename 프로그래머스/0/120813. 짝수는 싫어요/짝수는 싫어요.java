class Solution {
    public int[] solution(int n) {
        int length = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] answer = new int[length];
        
        int index = length - 1;
        int N = n % 2 == 0 ? n - 1 : n;
        while(N > 0) {
            answer[index--] = N;
            N -= 2;
        }
        return answer;
    }
}