class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        char[] numArr = String.valueOf(x).toCharArray();
        for(int i = 0; i < numArr.length; i++) {
            sum += numArr[i] - '0';
        }
        
        return x % sum == 0;
    }
}