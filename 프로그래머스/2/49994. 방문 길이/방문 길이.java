import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public class Point {
        int r;
        int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point p = (Point) obj;
                if(p.r == this.r && p.c == this.c) {
                    return true;
                }
            }
            return false;
        }
        
        public int hashCode() {
            return r * 31 + c;
        }
        
        public String toString() {
            return "(r=" + r + " c=" + c + ")";
        }
    }
    
    // 'U', 'D', 'R', 'L'
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        // 경로의 수
        int length = 0;
        
        // 위치 좌표
        int r = 0;
        int c = 0;
        
        // dr, dc에서 각 방향의 index
        Map<Character, Integer> dir = new HashMap<>();
        dir.put('U', 0);
        dir.put('D', 1);
        dir.put('R', 2);
        dir.put('L', 3);
        
        // 이동한 길을 저장하기 위한 map
        Map<Point, Set<Point>> road = new HashMap<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            // 이동 방향
            char d = dirs.charAt(i);
            // 방향에 따른 dr, dc의 인덱스
            int idx = dir.get(d);
            
            // 시작점
            Point start = new Point(r, c);
            
            // r, c가 경계선을 넘어가지 않을 경우
            if((d == 'R' && c < 5) || (d == 'L' && c > -5)
              || (d == 'U' && r < 5) || (d == 'D' && r > -5)) {
                r += dr[idx];
                c += dc[idx];
                // 도착점
                Point end = new Point(r, c);
                
                // 이미 지나간 길이면 skip
                if((road.containsKey(start) && road.get(start).contains(end)) 
                   || (road.containsKey(end) && road.get(end).contains(start))) {
                    continue;
                }
                // 도착점이나 시작점 중 하나라도 road에 key로 있으면 해당 key의 set에 추가
                else if(road.containsKey(start)) {
                    Set<Point> set = road.get(start);
                    set.add(end);
                    road.put(start, set);
                } else if(road.containsKey(end)) {
                    Set<Point> set = road.get(end);
                    set.add(start);
                    road.put(end, set);
                }
                // 둘 다 없으면 새로운 키로 추가
                else {
                    Set<Point> set = new HashSet<>();
                    set.add(end);
                    road.put(start, set);
                }
            } 
        }
        
        // map을 순회하면서 경로 수 합계 구하기
        Iterator<Point> iter = road.keySet().iterator();
        while(iter.hasNext()) {
            Point key = iter.next();
            length += road.get(key).size();
        }
        
        return length;
    }
}