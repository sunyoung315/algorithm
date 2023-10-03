package bronze.boj_5585_거스름돈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//타로가 지불할 돈
		int pay = sc.nextInt();;
		
		int change = 1000 - pay;
		
		int[] money = {500, 100, 50, 10, 5, 1};
		int[] dp = new int[change + 1];

		
		for(int c = 1; c <= change; c++) {
			int min = Integer.MAX_VALUE;
			
			if(c >= 1)
				min = Math.min(min, dp[c-1] + 1);
			if(c >= 5)
				min = Math.min(min, dp[c-5] + 1);
			if(c >= 10)
				min = Math.min(min, dp[c-10] + 1);
			if(c >= 50)
				min = Math.min(min, dp[c-50] + 1);
			if(c >= 100)
				min = Math.min(min, dp[c-100] + 1);
			if(c >= 500)
				min = Math.min(min, dp[c-500] + 1);
			
			dp[c] = min;
		}
		
		System.out.println(dp[change]);
		
	}//main
}//class
