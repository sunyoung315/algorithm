package silver.boj_15652_N과M_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, out;
	static StringBuilder sb = new StringBuilder();
	
	//중복순열 + 오름차순
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		
		out = new int[M];
		
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
			if(depth == 0 || arr[i] >= out[depth-1]) {
				out[depth] = arr[i];
				permutation(depth+1, M);
			}
		}
	}//permutation
}//class
