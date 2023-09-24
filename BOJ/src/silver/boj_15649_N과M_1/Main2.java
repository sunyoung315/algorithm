package silver.boj_15649_N과M_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int N, M;
	static int[] arr, out;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.close();
		
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		
		visited = new boolean[N];
		out = new int[M];
		
		permutation(0);
		
	}//main

	private static void permutation(int depth) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		} 
		
		//재귀파트
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				out[depth] = arr[i];
				visited[i] = true;
				permutation(depth + 1);
				visited[i] = false;
			}
		}
		
	}
}//class
