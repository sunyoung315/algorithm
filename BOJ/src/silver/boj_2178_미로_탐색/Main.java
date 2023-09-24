package silver.boj_2178_미로_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pos {
		int r, c, dist;
		public Pos(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	//좌, 상, 우, 하
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//1: 통로, 2: 벽
		int[][] maze = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		//시작 위치 큐에 넣기
		q.add(new Pos(0, 0, 1));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			//상, 우, 좌, 하 4방향 탐색
			for(int dir = 0; dir < dr.length; dir++) {
				int nextR = cur.r + dr[dir];
				int nextC = cur.c + dc[dir];
				int nextDist = cur.dist + 1;
				
				//미로의 범위를 벗어나거나,
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M 
						//이미 방문한 곳이거나, 벽일 경우
						|| visited[nextR][nextC] == true || maze[nextR][nextC] == 0) {
					//탐색에서 제외
					continue;
				}
				
				//도착지에 도달한 경우
				if(nextR == N-1 && nextC == M-1) {
					//거리 출력 후 종료
					System.out.println(nextDist);
					return;
				}
		
				//큐에 다음 탐색할 곳을 넣기
				q.add(new Pos(nextR, nextC, nextDist));
				//큐에 넣은 곳 방문 체크
				visited[nextR][nextC] = true;
				
			}
		}
		
	}//main
}//class
