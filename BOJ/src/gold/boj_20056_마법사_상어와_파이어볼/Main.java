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
			int r = Integer.parseInt(st.nextToken())-1;
			//위치 c열
			int c = Integer.parseInt(st.nextToken())-1;
			//질량
			int m = Integer.parseInt(st.nextToken());
			//속력
			int s = Integer.parseInt(st.nextToken());
			//방향
			int d = Integer.parseInt(st.nextToken());
			
			q.add(new FireBall(r, c, m, s, d));
			board[r][c].add(new FireBall(r, c, m, s, d));
		}//입력 끝
		
		for(int k = 1; k <= K; k++) {
			move();
		}

		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j].size() != 0) {
					sum += sum(board[i][j]);
				}
			}
		}
		System.out.println(sum);
		
	}//main

	static int sum(List<FireBall> list) {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i).m;
		}
		return sum;
	}

	static void move() {
		while(!q.isEmpty()) {
			FireBall curr = q.poll();
			int R = curr.r;
			int C = curr.c;
			int M = curr.m;
			int D = curr.d;
			int S = curr.s;
			
			int nextR = (R + dr[D] * S) % N;
			int nextC = (C + dc[D] * S) % N;
			if(nextR < 0) nextR += N;
			if(nextC < 0) nextC += N;
			
			board[R][C].remove(0);
			board[nextR][nextC].add(new FireBall(nextR, nextC, M, S, D));
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j].size() >= 2) {
					combine(i, j, board[i][j]);
				}else if(board[i][j].size() == 1) {
					q.add(new FireBall(i, j, board[i][j].get(0).m, board[i][j].get(0).s, board[i][j].get(0).d));
				}
			}
		}
	}

	static void combine(int r, int c, List<FireBall> list) {
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		
		int mSum = 0;
		int sSum = 0;
		for(int i = 0; i < list.size(); i++) {
			mSum += list.get(i).m;
			sSum += list.get(i).s;
			
			if(list.get(i).d % 2 == 1) odd.add(list.get(0).d);
			else even.add(list.get(i).d);
		}
		
		int newM = mSum / 5;
		int newS = sSum / list.size();
		
		if(newM != 0) {
			if(odd.size() == 0 || even.size() == 0) {
				board[r][c].clear();
				board[r][c].add(new FireBall(r, c, newM, newS, 0));
				q.add(new FireBall(r, c, newM, newS, 0));
				board[r][c].add(new FireBall(r, c, newM, newS, 2));
				q.add(new FireBall(r, c, newM, newS, 2));
				board[r][c].add(new FireBall(r, c, newM, newS, 4));
				q.add(new FireBall(r, c, newM, newS, 4));
				board[r][c].add(new FireBall(r, c, newM, newS, 6));
				q.add(new FireBall(r, c, newM, newS, 6));
			}else {
				board[r][c].clear();
				board[r][c].add(new FireBall(r, c, newM, newS, 1));
				q.add(new FireBall(r, c, newM, newS, 1));
				board[r][c].add(new FireBall(r, c, newM, newS, 3));
				q.add(new FireBall(r, c, newM, newS, 3));
				board[r][c].add(new FireBall(r, c, newM, newS, 5));
				q.add(new FireBall(r, c, newM, newS, 5));
				board[r][c].add(new FireBall(r, c, newM, newS, 7));
				q.add(new FireBall(r, c, newM, newS, 7));
			}
		}else {
			board[r][c].clear();
		}
	}
	
}//class
