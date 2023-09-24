package silver.boj_15666_N과M_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, out;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		out = new int[M];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
		
		System.out.println(sb);
		
	}//main

	private static void comb(int depth, int start) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		//재귀파트
		int before = 0;
		for(int i = start; i < N; i++) {
			if(before != arr[i]) {
				out[depth] = before = arr[i];
				comb(depth + 1, i);
			}
		}
	}
	
}//class
