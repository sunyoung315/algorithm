import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i = 0; i < n ; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int curr, int[][] computers) {
        visited[curr] = true;
        
        for(int i = 0; i < computers[curr].length; i++) {
            if(computers[curr][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}