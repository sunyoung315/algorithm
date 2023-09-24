package silver.boj_15651_N과M_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr, out;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = bf.readLine();

		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		
		out = new int[M];
		visited = new boolean[N];
		
		permutation(0, M);
		System.out.println(sb);
		
	}//main

	private static void permutation(int depth, int M) {
		if(depth == M) {
			for(int i = 0; i < out.length; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			out[depth] = arr[i];
			permutation(depth+1, M);
		}
	}//permutation
	
}//class
