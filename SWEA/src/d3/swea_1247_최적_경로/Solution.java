package d3.swea_1247_최적_경로;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] dist;
	static int[] order;
	static boolean[] visited;
	static int N, min;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d3/swea_1247_최적_경로/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//고객의 수
			N = sc.nextInt();
			
			order = new int[N+2];
			visited = new boolean[N+2];
			dist = new int[N+2][2];
			
			//회사의 x좌표, y좌표
			dist[0][0] = sc.nextInt();
			dist[0][1] = sc.nextInt();
			
			//집의 x좌표, y좌표
			dist[N+1][0] = sc.nextInt();
			dist[N+1][1] = sc.nextInt();
			
			//회사, 집, N명의 고객의 x좌표, y좌표 입력
			for(int i = 1; i <= N; i++) {
				//x좌표
				dist[i][0] = sc.nextInt();
				//y죄표
				dist[i][1] = sc.nextInt();
			}//입력 끝
			
			order[N+1] = N+1;
			
			min = Integer.MAX_VALUE;
			perm(1);
			System.out.println("#" + tc + " " + min);
			
		}//tc
	}//main	
	
	static void perm(int depth) {
		//기저파트
		if(depth == N+1) {
			int sum = 0;
			for(int i = 1; i < N+2; i++) {
				sum += Math.abs(dist[order[i]][0] - dist[order[i-1]][0]) + Math.abs(dist[order[i]][1] - dist[order[i-1]][1]);
			}
			min = min > sum ? sum : min;
		}
		//재귀파트
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				order[depth] = i;
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
}//Solution
