package gold.boj_9084_동전;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스의 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 동전의 가지 수
			int N = sc.nextInt();
			// 동전의 각 금액을 입력받기 위한 배열 coin
			int[] coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = sc.nextInt();
			}
			
			//동전으로 만들어야 할 금액
			int money = sc.nextInt();


			//동전들을 이용하여 만들 수 있는 경우의 수를 담기 위한 배열 생성
			int[] dp = new int[money + 1];

			//동전의 종류 선택(경우의 수 누적)
			for (int i = 0; i < N; i++) {
				//p: 동전으로 만들어지는 임시 금액
				for (int p = 1; p <= money; p++) {
					//만들 임시 금액 p가 선택한 동전의 금액보다 클 경우, p 금액을 만들 때 선택한 동전을 사용하면,
					//coin[i]를 고려하기 전 p에서 동전 금액을 뺀 금액에서 만든 경우의 수만큼 더 만들 수 있음
					if (p  > coin[i])
						dp[p] += dp[p - coin[i]];
					//p 금액과 선택한 동전의 금액이 같으면, 해당 동전을 이용하는 경우의 수 1 만큼이 증가
					else if (p - coin[i] == 0)
						dp[p]++;
				}
			}
			
			System.out.println(dp[money]);
			
		} // tc
		sc.close();

	}// main
}
