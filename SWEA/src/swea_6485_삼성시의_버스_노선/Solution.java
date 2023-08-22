package swea_6485_삼성시의_버스_노선;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea_6485_삼성시의_버스_노선/s_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 T 입력
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//버스 노선의 개수 N 입력
			int N = sc.nextInt();
			int[][] stop = new int[N][2];
			for(int i = 0; i < N; i++) {
				stop[i][0] = sc.nextInt();
				stop[i][1] = sc.nextInt();
			}
			
			int P = sc.nextInt();
			int[][] busStop = new int[P][2];
			for(int i = 0; i < P; i++) {
				busStop[i][0] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = stop[i][0]; j <= stop[i][1]; j++) {
					for(int k = 0; k < P; k++) {
						if(j == busStop[k][0]) {
							busStop[k][1]++;
						}
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < P; i++) {
				System.out.print(busStop[i][1] + " ");
			}
			System.out.println();
			
		}//tc
	}//main
}//class
