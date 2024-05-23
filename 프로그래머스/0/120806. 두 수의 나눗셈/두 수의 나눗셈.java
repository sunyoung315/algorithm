class Solution {
    public int solution(int num1, int num2) {
        // num1과 num2가 정수형 int이기 때문에 '/' 연산자의 결과가 몫으로 나옴
        // '/'의 결과가 소수점까지 나오기 위해서는 
        // 피연산자 중 하나라도 double이나 float과 같은 실수형이여야 함!
        return (int) Math.floor(num1 / (double) num2 * 1000);
    }
}