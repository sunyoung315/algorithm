package silver.boj_9095_1_2_3_더하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dp = new int[11];
		int[] plus = {1, 2, 3};
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 0; j < 3; j++) {
				if(i > plus[j]) {
					dp[i] += dp[i-plus[j]];
				}else if(i == plus[j])
					dp[i]++;
			}
		}
		
		//테스트케이스의 개수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			
			//정수 n
			int n = sc.nextInt();
			
			System.out.println(dp[n]);
			
		}//tc
		
		sc.close();
		
	}//main
}//class
