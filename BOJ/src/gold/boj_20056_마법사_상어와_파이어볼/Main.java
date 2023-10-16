package gold.boj_20056_마법사_상어와_파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static class FireBall {
		int r, c, m, s, d;
		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		@Override
		public String toString() {
			return "(" + m + "," + s + "," + d + ")";
		}
	}
	static int N, M, K;
	static List<FireBall>[][] board;
	static Queue<FireBall> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N*N 크기의 격자
		N = Integer.parseInt(st.nextToken());
		//M개의 파이어볼
		M = Integer.parseInt(st.nextToken());
		//K개의 명령
		K = Integer.parseInt(st.nextToken());
		
		board = new ArrayList[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				board[r][c] = new ArrayList<>();
			}
		}
		
		q = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			//위치 r행
			int r = Integer.parseInt(st.nextToken());
			//위치 c열
			int c = Integer.parseInt(st.nextToken());
			//질량
			int m = Integer.parseInt(st.nextToken());
			//속력
			int s = Integer.parseInt(st.nextToken());
			//방향
			int d = Integer.parseInt(st.nextToken());
			
			q.add(new FireBall(r, c, m, s, d));
			board[r][c].add(new FireBall(r, c, m, s, d));
		}//입력 끝
		
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(board[r][c] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println(q);
		
		for(int k = 1; k <= K; k++) {
			move();
		}
		
		int sum = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
//				System.out.print(board[r][c] + " ");
				if(board[r][c].size() > 0)
					sum += board[r][c].get(0).m;
			}
//			System.out.println();
		}
		System.out.println(sum);
		
	}//main
	
	static void move() {
		for(int i = 1; i <= M; i++) {
			FireBall curr = q.poll();
			board[curr.r][curr.c].remove(0);

			int nextR = (curr.r + dr[curr.d] * curr.s) % N ;
			if(nextR < 0) nextR += N;
			int nextC = (curr.c + dc[curr.d] * curr.s) % N; 
			if(nextC < 0) nextC += N;
			
			board[nextR][nextC].add(new FireBall(nextR, nextC, curr.m, curr.s, curr.d));
			q.add(new FireBall(nextR, nextC, curr.m, curr.s, curr.d));
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println();
			

		}//i
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j].size() >= 2) {
					combine(i, j, board[i][j]);
				}
			}//j
		}//i
		
	}//move

	static void combine(int r, int c, List<FireBall> list) {
		int mSum = 0;
		int sSum = 0;
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			mSum += list.get(i).m;
			sSum += list.get(i).s;
			if(list.get(i).d % 2 == 0) even.add(list.get(i).d);
			else odd.add(list.get(i).d);
		}

		int newM = mSum / 5;
		int newS = sSum / list.size();
		
		M -= board[r][c].size();
		board[r][c].clear();
		
		if(newM != 0) {
			if(even.size() == 0 || odd.size() == 0) {
				for(int dir = 0; dir < 8; dir += 2) {
					int nextR = r + dr[dir] * newS;
					int nextC = c + dc[dir] * newS;
					
					if(nextR < 0) nextR += N;
					if(nextC < 0) nextC += N;
					
					q.add(new FireBall(nextR, nextC, newM, newS, dir));
					board[nextR][nextC].add(new FireBall(nextR, nextC, newM, newS, dir));
					M++;
				}
			}else {
				for(int dir = 1; dir < 8; dir += 2) {
					int nextR = r + dr[dir] * newS;
					int nextC = c + dc[dir] * newS;
					
					if(nextR < 0) nextR += N;
					if(nextC < 0) nextC += N;
					
					q.add(new FireBall(nextR, nextC, newM, newS, dir));
					board[nextR][nextC].add(new FireBall(nextR, nextC, newM, newS, dir));
					M++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j].size() >= 2) {
					combine(i, j, board[i][j]);
				}
			}//j
		}//i

	}//combine

}//class
