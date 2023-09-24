package silver.boj_15655_N과M_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static int N, M;
	static int[] arr, out;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		arr = new int[N];
		out = new int[M];

		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		
		combination(0, 0);
		System.out.println(sb);
		
	}//main

	static void combination(int start, int depth) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		//재귀파트
		for(int i = start; i < N; i++) {
			out[depth] = arr[i];
			combination(i+1, depth+1);
		}
	}
}//class
