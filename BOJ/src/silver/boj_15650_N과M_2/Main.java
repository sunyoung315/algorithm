package silver.boj_15650_N과M_2;

import java.util.Scanner;

public class Main {
	public static int[] arr, out;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i-1] =i;
		}
		
		out = new int[M];
		visited = new boolean[N];
		
		permutation(0, M);
		
	}//main

	private static void permutation(int depth, int M) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < out.length; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		}
		//재귀파트
		for(int i = 0; i < arr.length; i++) {
			if(depth == 0 || out[depth-1] < arr[i]) {
				out[depth] = arr[i];
				permutation(depth+1, M);
			}
		}
		
	}//permutation
}//class
