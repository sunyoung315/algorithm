import java.util.*;

class Solution {
    // 루트노드를 저장할 배열
    private static int[] parent;
    
    public int solution(int n, int[][] costs) {
        // 건설 비용
        int answer = 0;
        // 연결된 다리의 개수
        int edges = 0;
        
        // 다리 건설비용 기준으로 정렬
        Arrays.sort(costs, (c1, c2) -> {
            return c1[2] - c2[2];
        });
        
        // 루트노드 자기 자신으로 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            // n-1개의 다리가 연결되면 모두 연결되었으므로 반복문 종료
            if(edges == n - 1)
                break;
            
            // 아직 연결되지 않은 구간이면 연결
            if(find(costs[i][0]) != find(costs[i][1])) {
                // 다리 연경
                union(costs[i][0], costs[i][1]);
                // 건설 비용 계산
                answer += costs[i][2];
                // 연결된 다리 개수 증가
                edges++;
            }
        }
        
        return answer;
    }
    
    // 해당 다리의 루드노드 찾기
    private static int find(int x) {
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }
    
    // 다리 연결하기
    private static void union(int x, int y) {
        int r1 = find(x);
        int r2 = find(y);
        
        parent[r2] = r1;
    }
}