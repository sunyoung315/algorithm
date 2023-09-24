package silver.boj_15652_N과M_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int[] arr, out;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		out = new int[M];
		
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
			combination(i, depth + 1);
		}
	}
}//class
