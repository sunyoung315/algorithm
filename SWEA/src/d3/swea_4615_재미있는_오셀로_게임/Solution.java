package d3.swea_4615_재미있는_오셀로_게임;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	//동, 남동, 남, 남서, 서, 북서, 북, 북동
	public static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	public static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src/swea_4615_재미있는_오셀로_게임/sample_input.txt"));
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
			for(int l = 0; l < N; l++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board[l][j] + " ");
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
				
				
				
				System.out.println("M="+M+" C="+C+" R="+R+"--------");
				turn: for(int dir = 0; dir < 8; dir++) {
					int nr = 0, nc = 0;
					nr = R + dr[dir];
					nc = C + dc[dir];
//					System.out.println(nr + " " + nc);
					//8방으로 옆칸을 탐색했을 때, 상대편의 돌일 경우 그 방향 탐색
					if(board[nr][nc] != stone && board[nr][nc] != 0) {
						while(nr < 0 || nr >= N || nc < 0 || nc >= N) {
							int cnt = 0;
							nr += dr[dir];
							nc += dc[dir];
//							System.out.println(nr + " " + nc);
							cnt++;
							if(board[nr][nc] == 0) {
								continue turn;
							}else if(board[nr][nc] == stone) {
								for(i = cnt; i >= 0; i--) {
									nr -= dr[dir];
									nc -= dc[dir];
									System.out.println(nr + " " + nc);
									board[nr][nc] = stone;
									break turn;
								}
							}else {
								continue;
							}
						}
						
					}else
						continue;
					
//					for(int k = 2; k <= N; k++) {
//						nr = R + dr[dir] * k;
//						nc = C + dc[dir] * k;
//						if(nr >= 0 && nr < N && nc >= 0 && nc < N && board[R + dr[dir]][C + dc[dir]] != 0 && board[nr][nc] == stone) {
//							boolean isBlank = false;
//							for(int l = 1; l < k; l++) {
//								if(board[R + dr[dir] * l][C + dc[dir] * l] == 0) {
//									isBlank = true;
//									break;
//								}
//							}
//							if(!isBlank) {
//								for(int l = 1; l < k; l++) {
//									board[R + dr[dir] * l][C + dc[dir] * l] = stone;
//								}
//							}
//							break;
//						}
//					}
				}
				
				//출력
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
