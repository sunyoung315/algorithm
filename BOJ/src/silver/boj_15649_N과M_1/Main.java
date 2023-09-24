package silver.boj_15649_N과M_1;

import java.util.Scanner;

public class Main {
	public static int[] arr, out;
	public static boolean[] visited;

	//순열 -> 서로 다른  N개에서 M개를 뽑아서 정렬하는 경우의 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//N개의 원소가 들어있는 배열
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		
		//M개를 뽑아서 담을 배열
		out = new int[M];
		//해당 원소의 사용 유무를 나타내는 배열
		visited = new boolean[N];
		
		permutation(0, M);
		
	}//main
	
	public static void permutation(int depth, int M) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//재귀파트
		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(depth+1, M);
				visited[i] = false;
			}
		}
	}//permutation
}//class
