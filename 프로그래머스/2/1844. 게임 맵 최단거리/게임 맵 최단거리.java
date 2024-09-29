import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 방문체크 배열
    static boolean[][] visited;
    // 이동하는 좌표를 담을 큐
    static Queue<Pos> queue;
    // 맵의 가로, 세로 길이
    static int n;
    static int m;
    
    // 좌표 
    static class Pos {
        int r;
        int c;
        int dist;
        
        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        
        return bfs(0, 0, 1, maps);
    }
    
    public int bfs(int r, int c, int dist, int[][] maps) {
        // 방문 처리하고
        visited[r][c] = true;
        // 큐에 넣기
        queue.add(new Pos(r, c, dist));
        
        while(!queue.isEmpty()) {
            Pos curr = queue.poll();
            
            // 상하좌우 이동
            for(int i = 0; i < 4; i++) {
                // 다음 좌표
                int nextR = curr.r + dr[i];
                int nextC = curr.c + dc[i];
                // 다음 좌표까지 이동한 길이
                int nextDist =  curr.dist + 1;
                
                // 갈 수 없는 길이거나 이미 방문한 길이면 스킵
                if(nextR < 0 || nextR > n-1 || nextC < 0 || nextC > m-1
                  || visited[nextR][nextC] || maps[nextR][nextC] == 0) {
                    continue;
                }
                
                // 상대팀 진영에 도착했다면 거리 출력
                if(nextR == n-1 && nextC == m-1) {
                    return nextDist;
                }
                
                // 갈 수 있는 길이이고, 아직 도착하지 못했다면 탐색 계속
                // 방문처리하고
                visited[nextR][nextC] = true;
                // 큐에 넣기
                queue.add(new Pos(nextR, nextC, nextDist));
            }
        }
        
        // 모든 탐색을 마쳤지만, 상태팀 진영에 도착하지 못했다면 -1출력
        return -1;
    }
}