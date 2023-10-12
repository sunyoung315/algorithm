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
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//격자의 크기
		int N = Integer.parseInt(st.nextToken());
		
		//파이어볼의 개수
		int M = Integer.parseInt(st.nextToken());
		//명령의 개수
		int K = Integer.parseInt(st.nextToken());
		
		Queue<FireBall> q = new LinkedList<>();
		
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
		}
		
		List<FireBall> result = new ArrayList<>();
		
		for(int k = 1; k <= K; k++) {
			
			while(!q.isEmpty()) {
				FireBall pick = q.poll();
			}
			
		}//K
	

	}//main
}//class
