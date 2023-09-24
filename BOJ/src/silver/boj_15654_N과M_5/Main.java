package silver.boj_15654_N과M_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, out;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		out = new int[M];
		visited = new boolean[N];
		
		Arrays.sort(arr);
		
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
			if(!visited[i]) {
				out[depth] = arr[i];
				visited[i] = true;
				permutation(depth+1, M);
				visited[i] = false;
			}
		}
	}//permutation
}//class
