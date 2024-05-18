import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 종류를 확인하기 위한 Set
        Set<Integer> types = new HashSet<>();
        // nums 배열을 순회하면서 Set에 추가
        for(int i = 0; i < nums.length; i++) {
            types.add(nums[i]);
        }
        
        // 포켓몬 종류가 전체 포켓몬 수의 절반보다 크면 그 크기만큼 다양한 종류의 포켓몬을 가질 수 있음
        if(types.size() > nums.length / 2) answer = nums.length / 2;
        // 작으면 포켓몬 종류 수만큼 다양하게 가질 수 있음
        else answer = types.size();
        
        return answer;
    }
}