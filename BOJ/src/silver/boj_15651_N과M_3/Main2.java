package silver.boj_15651_N과M_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	static int[] arr, out;
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		out = new int[M];
		
		permutation(0);
		bw.flush();
		bw.close();
		
	}

	static void permutation(int depth) throws IOException {
		//기저파트
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				bw.write(out[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		//재귀파트
		for(int i = 0; i < N; i++) {
			out[depth] = arr[i];
			permutation(depth + 1);
		}
		
	}//main
}//class
