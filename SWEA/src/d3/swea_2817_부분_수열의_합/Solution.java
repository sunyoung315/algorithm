package d3.swea_2817_부분_수열의_합;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	static boolean[] sel;
	static int N, K, cnt;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d3/swea_2817_부분_수열의_합/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//N개의 자연수
			N = sc.nextInt();
			//수열의 합
			K = sc.nextInt();
			
			arr = new int[N];
			sel = new boolean[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			cnt = 0;
			powerset(0);
			System.out.println("#" + tc + " " + cnt);
			
		}//tc
	}//main
	private static void powerset(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(sel[i])
					sum += arr[i];
			}
			if(sum == K) {
				cnt++;
			}
			return;
		}
		sel[depth] = false;
		powerset(depth + 1);
		sel[depth] = true;
		powerset(depth + 1);
	}
	
}//Solution
