package silver.boj_15663_N과M_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, out;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		arr = new int[N];
		out = new int[M];
		visited = new boolean[N];
		
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		
		perm(0);
		
		System.out.println(sb);
		
	}//main

	static void perm(int depth) {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		//재귀파트
		//중복을 걸러내기 위한 변수
		int before = 0;
		for(int i = 0; i < N; i++) {
			//이미 사용한 값이거나, 직전 값과 새로운 값이 동일하면 배제
			if(!visited[i] && before != arr[i]) {
				out[depth] = arr[i];
				visited[i] = true;
				before = arr[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
}//class
