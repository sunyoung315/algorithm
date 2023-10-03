package silver.boj_1463_1로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int[] dp = new int[X+1];
		
		//1은 연산 0번 -> 원래 0으로 초기화 되어있으므로 생략
		
		for(int i = 2; i <= X; i++) {
			//최소 연산횟수를 구하기 위해 min을 Integer 최댓값으로 초기화
			int min = Integer.MAX_VALUE;
			
			//1번 연산
			
			//3으로 나누어 떨어지면, 
			//이전에 나누기 3한 연산횟수(dp[i/3])에 2번 연산횟수를 1 증가시킨 값을 min과 비교
			if(i % 3 == 0) {
				min = Math.min(min, dp[i/3] + 1);
			//3으로 나누었을 때 나머지가 1이면, 
			//i에서 1을 뺀 값의 연산횟수(dp[i/3])에서 3번(빼기) 연산횟수 1 증가시킨 값을 min과 비교
			}else if(i % 3 == 1) {
				min = Math.min(min, dp[i-1] + 1);
			//3으로 나누었을 때 나머지가 2이면, 
			//i에서 2을 뺀 값의 연산횟수(dp[i/3])에서 빼기(3번) 연산횟수 2 증가시킨 값을 min과 비교
			}else if(i % 3 == 2) {
				min = Math.min(min, dp[i-2] + 2);
			}
			
			//2번 연산
			
			//2으로 나누어 떨어지면, 
			//이전에 나누기 2한 연산횟수(dp[i/2])에 2번 연산횟수를 1 증가시킨 값을 min과 비교
			if(i % 2 == 0) {
				min = Math.min(min, dp[i/2] + 1);
			//2으로 나누었을 때 나머지가 1이면, 
			//i에서 1을 뺀 값의 연산횟수(dp[i/2])에서 빼기(3번) 연산횟수 1 증가시킨 값을 min과 비교
			}else if(i % 2 == 1) { 
				min = Math.min(min, dp[i-1] + 1);
			}
			//
			dp[i] = min;
		}
		
		System.out.println(dp[X]);
		
	}//main
}//class
