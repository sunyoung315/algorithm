package gold.boj_2638_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//세로 격자의 수
		N = Integer.parseInt(st.nextToken());
		//가로 격자의 수
		M = Integer.parseInt(st.nextToken());
		
		//격자 배열
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		br.close();
		
		
		//시간
		int hour = 0;

		boolean flag = false;
		while(!flag) {
			//바깥 공기를 체크
			bfs();
	
			//사라질 치즈 체크
			check();
			
			//치즈가 남아있는지 체크
			flag = true;
			out: for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(arr[r][c] == 1) {
						flag = false;
						break out;
					}
				}
			}
			
			hour++;
		}
		
		System.out.println(hour);

	}//main

	static void check() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				//치즈가 있는 곳에서 4방향 탐색
				if(arr[r][c] == 1) {
					int cnt = 0;
					for(int dir = 0; dir < 4; dir++) {
						int nextR = r + dr[dir];
						int nextC = c + dc[dir];
						//3(바깥공기) 카운트
						if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && arr[nextR][nextC] == 3) {
							cnt++;
						}
					}
					//3이 2개 이상이면 치즈는 사라짐
					if(cnt >= 2) {
						arr[r][c] = 0;
					}
				}
			}
		}
	}//check

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new Pos(0, 0));
		visited[0][0] = true;
		
		//치즈 내부의 공간은 외부 공기와 접촉하지 않은 것이므로 내부와 외부를 분리
		//치즈 외부 공기 -> 3으로 바꾸기
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			for(int dir = 0; dir < 4; dir++) {
				int nextR = r + dr[dir];
				int nextC = c + dc[dir];
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC] 
						&& (arr[nextR][nextC] == 0 || arr[nextR][nextC] == 3)) {
						visited[nextR][nextC] = true;
						arr[nextR][nextC] = 3;
						q.add(new Pos(nextR, nextC));
				}
			}
		}
	}//bfs

}//class

