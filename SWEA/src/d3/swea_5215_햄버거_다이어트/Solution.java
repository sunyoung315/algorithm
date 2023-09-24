package d3.swea_5215_햄버거_다이어트;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, L, max;
	static int[][] ing;
	static boolean[] sel;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d3/swea_5215_햄버거_다이어트/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 수
		int TC = sc.nextInt();
		for(int tc = 1; tc <= TC; tc++) {
			//재료의 수
			N = sc.nextInt();
			//제한 칼로리
			L = sc.nextInt();
			
			ing = new int[N][2];
			for(int i = 0; i < N; i++) {
				//해당 재료의 맛에 대한 점수
				ing[i][0] = sc.nextInt();
				//해당 재료의 칼로리
				ing[i][1] = sc.nextInt();
			}
			
			sel = new boolean[N];
			
			max = 0;
			powerset(0);
			System.out.printf("#%d %d\n", tc, max);
			
		}//tc
	}//main
	static void powerset(int depth) {
		//기저파트
		if(depth == N) {
			int totalScore = 0;
			int totalKcal = 0;
			for(int i = 0; i < N; i++) {
				if(sel[i]) {
					totalScore += ing[i][0];
					totalKcal += ing[i][1];
				}
				if(totalKcal > L) return;
			}
			max = max < totalScore ? totalScore : max;
			return;
		}
		//재귀파트
		sel[depth] = false;
		powerset(depth + 1);
		sel[depth] = true;
		powerset(depth + 1);
	}
}//Solution
