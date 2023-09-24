package 모의SW.swea_4012_요리사;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] ing;
	static int[] foodA, foodB;
	static boolean[] visited;
	static int N, min;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_4012_요리사/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 개수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//식재료의 수
			N = sc.nextInt();
			ing = new int[N][N];
			
			visited = new boolean[N];
			foodA = new int[N/2];
			foodB = new int[N/2];
			//식재료 시너지 입력
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					ing[i][j] = sc.nextInt();
				}
			}//입력 끝
			
			min = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + tc + " " + min);
			
		}//tc
	}//main
	
	static void comb(int depth, int start) {
		//기저파트
		if(depth == N/2) {
			int idx = 0;
			for(int i = 0; i < N; i++) {
				if(!visited[i])
					foodB[idx++] = i;
			}
			
			int sinA = 0;
			int sinB = 0;
			for(int i = 0; i < N/2-1; i++) {
				for(int j = i+1; j < N/2; j++) {
					sinA += ing[foodA[i]][foodA[j]] + ing[foodA[j]][foodA[i]];
					sinB += ing[foodB[i]][foodB[j]] + ing[foodB[j]][foodB[i]];
				}
			}
			min = min > Math.abs(sinA - sinB) ? Math.abs(sinA - sinB) : min;
			return;
		}
		//재귀파트
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				foodA[depth] = i;
				visited[i] = true;
				comb(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	
}//Solution
