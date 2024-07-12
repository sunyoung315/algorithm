import java.util.*;

class Solution {
    static int[] oneArr = {1, 2, 3, 4, 5};
    static int[] twoArr = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] treeArr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == oneArr[i % oneArr.length])
                map.put(1, map.getOrDefault(1, 0) + 1);
            if(answers[i] == twoArr[i % twoArr.length])
                map.put(2, map.getOrDefault(2, 0) + 1);
            if(answers[i] == treeArr[i % treeArr.length])
                map.put(3, map.getOrDefault(3, 0) + 1);
        }
        
        int maxScore = Collections.max(map.values());
        
        List<Integer> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
            if(entry.getValue() == maxScore)
                arr.add(entry.getKey());
        
        return arr.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}