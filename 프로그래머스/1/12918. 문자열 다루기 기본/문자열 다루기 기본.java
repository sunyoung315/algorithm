class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6)
            return false;
        
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; i++) {
            if((int) sArr[i] > 57) {
                return false;
            }
        }
        return true;
    }
}