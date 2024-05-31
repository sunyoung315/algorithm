class Solution {
    public int solution(int price) {
        int answer = price  >= 500000 ? (int) Math.floor(price * 0.8) : price >= 300000 ? (int) Math.floor(price * 0.9) : price >= 100000 ?  (int) Math.floor(price * 0.95) : price;
        return answer;
    }
}