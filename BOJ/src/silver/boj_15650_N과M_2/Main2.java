package silver.boj_15650_N과M_2;

import java.util.Scanner;

public class Main2 {
	static int[] arr, out;
	static boolean[] visited;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.close();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		out = new int[M];
		visited = new boolean[N];
		
		combination(0, 0);
		
	}//main
	
	static void combination(int start, int depth) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//재귀파트
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				out[depth] = arr[i];
				visited[i] = true;
				combination(i + 1, depth + 1);
				visited[i] = false;
			}
		}
		
	}
}//class
