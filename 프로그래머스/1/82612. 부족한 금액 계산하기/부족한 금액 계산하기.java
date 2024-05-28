class Solution {
    public long solution(int price, int money, int count) {
        long cnt = count % 2 == 0 ? (1 + count) * (count / 2) : (1 + count) * (count / 2) + (count / 2) + 1;
        
        long answer = price * cnt - money;

        if(answer > 0)
            return answer;
        else
            return 0;
    }
}