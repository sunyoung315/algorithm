import java.util.*;

class Solution {
    class Pos {
        public int r;
        public int c;
        public int dist;
        
        public Pos (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int h, w;
    
    public int solution(String[] maps) {
        // 미로의 세로 길이
        h = maps.length;
        // 미로의 가로 길이/ 미로의 가로 길이
        w = maps[0].length();
        
        // 시작 지점, 레버, 출구 찾기
        Pos start = findPoint(maps, 'S');
        Pos lever = findPoint(maps, 'L');
        Pos exit  = findPoint(maps, 'E');
        
        // 시작점에서 레버까지의 최단 거리 구하기
        int toLever = bfs(maps, start, lever);
        if(toLever == -1) return -1;
        
        // 레버에서 출구까지의 최단 거리 구하기
        int toExit = bfs(maps, lever, exit);
        if(toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public Pos findPoint(String[] maps, char target) {
        for(int i = 0; i < h; i++) {
            if(maps[i].contains(String.valueOf(target))) {
                int j = maps[i].indexOf(target);
                return new Pos(i, j, 0);
            }
        }
        return null;
    }
    
    public int bfs(String[] maps, Pos start, Pos end) {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        
        queue.add(start);
        visited[start.r][start.c] = true;
        
        while(!queue.isEmpty()) {
            Pos curr = queue.poll();
            
            if(curr.r == end.r && curr.c == end.c) {
                return curr.dist;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nowR = curr.r + dr[dir];
                int nowC = curr.c + dc[dir];
                
                if(nowR >= 0 && nowR < h && nowC >= 0 && nowC < w 
                  && !visited[nowR][nowC] && maps[nowR].charAt(nowC) != 'X') {
                    // 벽이 아니면 이동 가능
                    queue.add(new Pos(nowR, nowC, curr.dist + 1));
                    visited[nowR][nowC] = true;
                }                
            }
        }
        
        return -1;
    }
}