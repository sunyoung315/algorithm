package silver.boj_2839_설탕_배달;

import java.util.Arrays;
import java.util.Scanner;

public class Main_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//배달해야 할 설탕의 무게
		int N = sc.nextInt();
		
		//임의의 배달할 설탕 무게로 가능한 최소 봉투수를 담기 위한 dp배열 생성
		int[] dp = new int[N+1];
		//임의의 최대값으로 설정
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i <= N; i++) {
			//임의의 배달할 설탕 무게가 0일 때가 0으로 초기화
			dp[0] = 0;
			//dp[i-3]의 값이 5000이면 3kg과  소분이 불가능한 상태
			//작은 부분 문제를 3kg만 고려할 경우 3의 배수인 경우에만 소분 가능
			if(i >= 3 && dp[i-3] != Integer.MAX_VALUE) {
				dp[i] = dp[i-3] + 1;
			}
			//작은 부분 문제에 5kg까지 고려할 경우
			//dp[i-5]가 5000이면 5kg을 사용할 수 없음 -> 소분 불가능
			//dp[i](3kg만 고려했을 경우)와 dp[i-5]+1 (3kg과 5kg을 모두 고려했을 경우) 중 작은 값을 저장
			if(i >= 5 && dp[i-5] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i-5] + 1);
			}
		}
		
		if(dp[N] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
		
	}//main
}//class
