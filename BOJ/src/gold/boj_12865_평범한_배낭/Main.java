package gold.boj_12865_평범한_배낭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//물품의 수
		int N = sc.nextInt();
		//준서가 버틸 수 있는 무게
		int K = sc.nextInt();
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		for(int i = 1; i <= N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			//w: 임시 배낭의 무게
			for(int w = 0; w <= K; w++) {
				//담으려는 물품의 무게가 임시 배낭의 무게보다 크면 담을 수 없음
				if(W[i] > w) {
					dp[i][w] = dp[i-1][w];
				}
				//담으려는 물품의 무게가 임시 배낭의 무게보다 작거나 같을 경우,
				else {
					//dp[i-1][w] : i번째 물건을 고려하기 전, w만큼 담기 위한 최적해
					//dp[i-1][w-W[i]] + V[i] : i번째 물건을 담는 것을 고려한 w만큼 담기 위한 최적해
					//	            -> i번째 물건을 담기 전 임시배낭의 가치에서 i번째 물건의 가치를 더함
					//이 중에서 최대값이 최적해가 된다.
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-W[i]] + V[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}//main
}//class
