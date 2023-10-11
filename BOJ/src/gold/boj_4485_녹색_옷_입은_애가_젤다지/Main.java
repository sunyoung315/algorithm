package gold.boj_4485_녹색_옷_입은_애가_젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Pos implements Comparable<Pos>{
		int r, c, rupy;
		public Pos(int r, int c, int rupy) {
			this.r = r;
			this.c = c;
			this.rupy = rupy;
		}
		@Override
		public int compareTo(Pos o) {
			return this.rupy - o.rupy;
		}
	}
	static int N, k;
	static int[][] cave, rupies;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//동굴의 크기
		N = Integer.parseInt(br.readLine());
		int tc = 1;
		while(N != 0) {
			cave = new int[N][N];
			rupies = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				Arrays.fill(rupies[r], Integer.MAX_VALUE);
			}
			
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					cave[r][c] = Integer.parseInt(st.nextToken());
				}
			}//동굴 입력 끝
			
			dijkstra(0, 0);
			
			System.out.println("Problem " + tc + ": " + rupies[N-1][N-1]);
			
			N = Integer.parseInt(br.readLine());
			tc++;
		}//N
		
	}//main
	
	static void dijkstra(int r, int c) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(r, c, cave[r][c]));
		rupies[r][c] = cave[r][c];
		
		while(!pq.isEmpty()) {
			Pos  curr = pq.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
					int nextRupy = rupies[curr.r][curr.c] + cave[nextR][nextC];
					if(nextRupy < rupies[nextR][nextC]) {
						rupies[nextR][nextC] = nextRupy;
						pq.add(new Pos(nextR, nextC, cave[nextR][nextC]));
					}
				}
			}
		}
	}
	
}//class
