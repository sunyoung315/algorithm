package silver.boj_15655_N과M_6;

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
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		arr = new int[N];
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		out = new int[M];
		visited = new boolean[N];
		
		Arrays.sort(arr);
		combination(0, 0, M);
		
		System.out.println(sb);
		
	}//main
	
	private static void combination(int start, int depth, int M) {
		if(depth == M) {
			for(int i = 0; i < out.length; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
			
		for(int i = start; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				combination(i+1, depth+1, M);
				visited[i] = false;
			}
		}
	}//combination
}//class
