package silver.boj_15654_N과M_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static int N, M;
	static int[] arr, out;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		
		out = new int[M];
		visited = new boolean[N];
		
		permutation(0);
		System.out.println(sb);
		
	}//main 

	static void permutation(int depth) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
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
