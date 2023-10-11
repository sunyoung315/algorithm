package 모의SW.swea_1953_탈주범_검거;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M, R, C, L;
	static int[][] map, hours;
	static boolean[][] visited;
	//상, 하, 좌, 우 4방향 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Pos {
		int r, c, type;
		public Pos(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", type=" + type + "]";
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_1953_탈주범_검거/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 개수
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			//지하터널 지도의 세로 크기
			N = sc.nextInt();
			//지하터널 지도의 가로 크기
			M = sc.nextInt();
			//멘홀 뚜껑이 위치한 장소의 세로 위치
			R = sc.nextInt();
			//멘홀 뚜껑이 위치한 장소의 가로 위치
			C = sc.nextInt();
			//탈출 후 소요된 시간
			L = sc.nextInt();
			
			//N*M 크기의 지하터널 지도
			map = new int[N][M];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			//이미 지나간 파이프인지 확인하기 위한 boolean 배열
			visited = new boolean[N][M];
			//소요 시간
			hours = new int[N][M];
			
			//맨홀 뚜껑 위치에서부터 bfs 탐색
			bfs(R, C);
			
			//L시간에 탈주범이 위치할 수 있는 곳의 개수
			int cnt = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(hours[r][c] <= L && hours[r][c] != 0)
						cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
			
		}//tc
		
	}//main
	
	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c, map[r][c]));
		//1시간 뒤 도달할 수 있는 위치는 들어간 맨홀의 위치 -> 1로 저장하고 시작
		hours[r][c] = 1;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			//현재 위치(nr, nc)
			int nr = curr.r;
			int nc = curr.c;
			//현재 있는 터널 구조물 타입
			int nType = curr.type;
			//방문 체크
			visited[nr][nc]= true; 
			
			//구조물 타입(1~7) : 갈 수 있는 방향
			//각 구조물마다 갈 수 있는 방향에 맞는 구조물이 있는지 확인하기 -> isGoUp, isGoDown, isGoLeft, isGoRight
			//1. 상, 하, 좌, 우
			if(nType == 1) {
				if(isGoUp(nr-1, nc) && !visited[nr-1][nc]) {
					q.add(new Pos(nr-1, nc, map[nr-1][nc]));
					hours[nr-1][nc] = hours[nr][nc] + 1;
					visited[nr-1][nc] = true;
				}
				if(isGoDown(nr+1, nc) && !visited[nr+1][nc]) {
					q.add(new Pos(nr+1, nc, map[nr+1][nc]));
					hours[nr+1][nc] = hours[nr][nc] + 1;
					visited[nr+1][nc] = true;
				}
				if(isGoLeft(nr, nc-1) && !visited[nr][nc-1]) {
					q.add(new Pos(nr, nc-1, map[nr][nc-1]));
					hours[nr][nc-1] = hours[nr][nc] + 1;
					visited[nr][nc-1] = true;
				}
				if(isGoRight(nr, nc+1) && !visited[nr][nc+1]) {
					q.add(new Pos(nr, nc+1, map[nr][nc+1]));
					hours[nr][nc+1] = hours[nr][nc] + 1;
					visited[nr][nc+1] = true;
				}
			}
			//2. 상, 하
			else if(nType == 2) {
				if(isGoUp(nr-1, nc) && !visited[nr-1][nc]) {
					q.add(new Pos(nr-1, nc, map[nr-1][nc]));
					hours[nr-1][nc] = hours[nr][nc] + 1;
					visited[nr-1][nc] = true;
				}
				if(isGoDown(nr+1, nc) && !visited[nr+1][nc]) {
					q.add(new Pos(nr+1, nc, map[nr+1][nc]));
					hours[nr+1][nc] = hours[nr][nc] + 1;
					visited[nr+1][nc] = true;
				}
			}
			//3. 좌, 우
			else if(nType == 3) {
				if(isGoLeft(nr, nc-1) && !visited[nr][nc-1]) {
					q.add(new Pos(nr, nc-1, map[nr][nc-1]));
					hours[nr][nc-1] = hours[nr][nc] + 1;
					visited[nr][nc-1] = true;
				}
				if(isGoRight(nr, nc+1) && !visited[nr][nc+1]) {
					q.add(new Pos(nr, nc+1, map[nr][nc+1]));
					hours[nr][nc+1] = hours[nr][nc] + 1;
					visited[nr][nc+1] = true;
				}
			}
			//4. 상, 우
			else if(nType == 4) {
				if(isGoUp(nr-1, nc) && !visited[nr-1][nc]) {
					q.add(new Pos(nr-1, nc, map[nr-1][nc]));
					hours[nr-1][nc] = hours[nr][nc] + 1;
					visited[nr-1][nc] = true;
				}
				if(isGoRight(nr, nc+1) && !visited[nr][nc+1]) {
					q.add(new Pos(nr, nc+1, map[nr][nc+1]));
					hours[nr][nc+1] = hours[nr][nc] + 1;
					visited[nr][nc+1] = true;
				}
			}
			//5. 하, 우
			else if(nType == 5) {
				if(isGoDown(nr+1, nc) && !visited[nr+1][nc]) {
					q.add(new Pos(nr+1, nc, map[nr+1][nc]));
					hours[nr+1][nc] = hours[nr][nc] + 1;
					visited[nr+1][nc] = true;
				}
				if(isGoRight(nr, nc+1) && !visited[nr][nc+1]) {
					q.add(new Pos(nr, nc+1, map[nr][nc+1]));
					hours[nr][nc+1] = hours[nr][nc] + 1;
					visited[nr][nc+1] = true;
				}
			}
			//6. 하, 좌
			else if(nType == 6) {
				if(isGoDown(nr+1, nc) && !visited[nr+1][nc]) {
					q.add(new Pos(nr+1, nc, map[nr+1][nc]));
					hours[nr+1][nc] = hours[nr][nc] + 1;
					visited[nr+1][nc] = true;
				}
				if(isGoLeft(nr, nc-1) && !visited[nr][nc-1]) {
					q.add(new Pos(nr, nc-1, map[nr][nc-1]));
					hours[nr][nc-1] = hours[nr][nc] + 1;
					visited[nr][nc-1] = true;
				}
			}
			//7. 상, 좌
			else if(nType == 7) {
				if(isGoUp(nr-1, nc) && !visited[nr-1][nc]) {
					q.add(new Pos(nr-1, nc, map[nr-1][nc]));
					hours[nr-1][nc] = hours[nr][nc] + 1;
					visited[nr-1][nc] = true;
				}
				if(isGoLeft(nr, nc-1) && !visited[nr][nc-1]) {
					q.add(new Pos(nr, nc-1, map[nr][nc-1]));
					hours[nr][nc-1] = hours[nr][nc] + 1;
					visited[nr][nc-1] = true;
				}
			}	
			
			if(hours[nr][nc] == L) return;
			
		}//q.isEmpty
	}//bfs
	
	//오른쪽으로 갈 수 있는지 체크
	static boolean isGoRight(int r, int c) {
		if(c < M && (map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 6 || map[r][c] == 7)) {
			return true;
		}
		return false;
	}

	//왼쪽으로 갈 수 있는지 체크
	static boolean isGoLeft(int r, int c) {
		if(c >= 0 && (map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 4 || map[r][c] == 5)) {
			return true;
		}
		return false;
	}

	//아래로 갈 수 있는지 체크
	static boolean isGoDown(int r, int c) {
		if(r < N && (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 4 || map[r][c] == 7)) {
			return true;
		}
		return false;
	}

	//위로 갈 수 있는지 체크
	static boolean isGoUp(int r, int c) {
		if(r >= 0 && (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 5 || map[r][c] == 6)) {
			return true;
		}
		return false;
	}
	
}//Solution
