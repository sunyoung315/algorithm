import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        // TreeSet<Integer> treeset = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                // treeset.add(numbers[i] + numbers[j]);
                hashSet.add(numbers[i] + numbers[j]);
            }
        }
        
        // answer = new int[treeset.size()];
        // for(int i = 0; i < answer.length; i++) {
        //     answer[i] = treeset.pollFirst();
        // }
        
        // return answer;
        
        return hashSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}