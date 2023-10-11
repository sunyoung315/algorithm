package gold.boj_7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class tomato {
		int r, c;
		public tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int M, N, days;
	static int[][] box;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//상자의 가로 칸의 수
		M = Integer.parseInt(st.nextToken());
		//상자의 세로 칸의 수
		N = Integer.parseInt(st.nextToken());
		
		//토마토가 들어있는 상자 배열
		box = new int[N][M];
		
		//1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않은 칸
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	
		int max = 0;
		out: for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(box[r][c] == 0) {
					max = 0;
					break out;
				}else {
					max = max < box[r][c] ? box[r][c] : max;
				}
			}
		}
		
		System.out.println(max-1);
	}
	
	static void bfs() {
		Queue<tomato> q = new LinkedList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(box[r][c] == 1) q.add(new tomato(r, c));
			}
		}
		while(!q.isEmpty()) {
			tomato curr = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				days = box[curr.r][curr.c] + 1;
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M
						&& box[nextR][nextC] == 0) {
					box[nextR][nextC] = days;
					q.add(new tomato(nextR, nextC));
				}
			}
		}
	}//bfs
	
}//class
