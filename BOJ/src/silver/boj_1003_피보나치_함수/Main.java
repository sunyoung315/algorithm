package silver.boj_1003_피보나치_함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스의 개수
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			//N번째 피보나치 수
			int N = Integer.parseInt(br.readLine());
			
			//[i번째 피보나치수][fibo(0), fibo(1) 호출 횟수]
			int[][] fibo = new int[N+1][2];
			//fibo(0)은 fibo(0)만 1번 호출
			fibo[0][0] = 1;
			//fibo(1)은 fibo(1)만 1번 호출
			if(N > 0)
			fibo[1][1] = 1;
			
			for(int i = 2; i <= N; i++) {
				fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
				fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];				
			}
			
			System.out.println(fibo[N][0] + " " + fibo[N][1]);
			
		}//tc
		
	}//main
}//class
