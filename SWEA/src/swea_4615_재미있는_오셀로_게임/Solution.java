package swea_4615_재미있는_오셀로_게임;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	//동, 남동, 남, 남서, 서, 북서, 북, 북동
	public static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	public static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea_4615_재미있는_오셀로_게임/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ;tc++) {
			//오셀로 판의 크기 N
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			//초기 돌 셋팅
			board[N/2-1][N/2-1] = 2;
			board[N/2][N/2] = 2;
			board[N/2][N/2-1] = 1;
			board[N/2-1][N/2] = 1;
			
			//출력 
			System.out.println("초기 오셀로");
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println();
			//출력
			
			//돌을 놓는 횟수 M
			int M = sc.nextInt();
			
			for(int i = 1; i <= M; i++) {
				//돌을 놓을 위치 C, R
				int C = sc.nextInt()-1;
				int R = sc.nextInt()-1;
				
				int stone = sc.nextInt();
				board[R][C] = stone;
				
				//출력
				System.out.println("오셀로 놓기");
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						System.out.print(board[r][c] + " ");
					}
					System.out.println();
				}
				System.out.println();
				//출력
				
				System.out.println("M="+M+" C="+C+" R="+R+"--------");
				for(int dir = 0; dir < 8; dir++) {
					int nr = 0, nc = 0;
					for(int k = 2; k <= N; k++) {
						nr = R + dr[dir] * k;
						nc = C + dc[dir] * k;
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && board[R + dr[dir] * (k-1)][C + dc[dir] * (k-1)] != stone && board[nr][nc] == stone) {
							System.out.println("k="+k+" dir="+dir);
							for(int l = k; l >= 0; l--) {
								board[R + dr[dir] * l][C + dc[dir] * l] = stone;
							}
							break;
						}
					}
				}
				
				//출력
				System.out.println("오셀로 바꾸기");
				for(int l = 0; l < N; l++) {
					for(int j = 0; j < N; j++) {
						System.out.print(board[l][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				//출력
			}
			
			int black = 0;
			int white = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == 1) {
						black++;
					}else if(board[i][j] == 2) {
						white++;
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, black, white);
			
		}//tc
	}//main
}//class
