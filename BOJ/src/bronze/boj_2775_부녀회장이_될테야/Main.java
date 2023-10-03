package bronze.boj_2775_부녀회장이_될테야;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//테스트케이스의 개수
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			//k층
			int k = Integer.parseInt(br.readLine());
			//n호
			int n = Integer.parseInt(br.readLine());
			
			//k층 n호의 집
			int[][] house = new int[k+1][n+1];
			//0층의 i호에는 i명이 산다.
			for(int i = 1; i <= n; i++) {
				house[0][i] = i;
			}
			
			
			for(int i = 1; i <= k; i++) {
				for(int j = 1; j <= n; j++) {
					if(j == 1)
						house[i][j] = house[i-1][j];
					else
						house[i][j] = house[i-1][j] + house[i][j-1];
				}
			}
			
			bw.write(house[k][n] + "\n");
		}//tc
		bw.flush();
		bw.close();
	}//main
}//class
