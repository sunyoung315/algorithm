import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] com = commands[i];
            
            List<Integer> arr = new ArrayList<>();
            for(int j = com[0] - 1; j <= com[1] - 1; j++) {
                arr.add(array[j]);
            }
            
            Collections.sort(arr);
            
            answer[i] = arr.get(com[2] - 1);
        }
        return answer;
    }
}