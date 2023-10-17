package gold.boj_12100_2048_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static int N, max, cnt;
	//Up, Down, Left, Right
	static int[] p = {1, 2, 3, 4}; 
	static int[] out;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		StringTokenizer st;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}//입력끝
		
		out = new int[5];
		max = 0;
		cnt = 0;
		perm(0);
		System.out.println(cnt);
		System.out.println(max);


		
	}//main
	
	static void perm(int depth) {
		//기저파트
		if(depth == 5) {
			for(int k = 0; k < 5; k++) {
				if(out[k] == 1) MoveUp();
				else if(out[k] == 2) MoveDown();
				else if(out[k] == 3) MoveLeft();
				else MoveRight();
//				if(out[k] == 1) {
//					if(MoveUp()) {
//						for(int i = 0; i < N; i++) {
//							for(int j = 0; j < N; j++) {
//								max = board[i][j] > max ? board[i][j] : max;
//							}
//						}
//					}
//				}
//				else if(out[k] == 2) {
//					if(MoveDown()) {
//						for(int i = 0; i < N; i++) {
//							for(int j = 0; j < N; j++) {
//								max = board[i][j] > max ? board[i][j] : max;
//							}
//						}
//					}
//				}
//				else if(out[k] == 3) {
//					if(MoveLeft()) {
//						for(int i = 0; i < N; i++) {
//							for(int j = 0; j < N; j++) {
//								max = board[i][j] > max ? board[i][j] : max;
//							}
//						}
//					}
//				}
//				else {
//					if(MoveRight()) {
//						for(int i = 0; i < N; i++) {
//							for(int j = 0; j < N; j++) {
//								max = board[i][j] > max ? board[i][j] : max;
//							}
//						}
//					}
//				}
			}
			cnt++;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					max = board[i][j] > max ? board[i][j] : max;
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		//재귀파트
		for(int dir = 0; dir < 4; dir++) {
			out[depth] = p[dir];
			perm(depth + 1);
		}
	}

	static boolean MoveLeft() {
		boolean flag = false;
		for(int r = 0; r < N; r++) {
			out : for(int c = 0; c < N-1; c++) {
				for(int k = c+1; k < N; k++) {
					if(board[r][k] != 0 && board[r][c] == board[r][k]) {
						board[r][c] = board[r][k] * 2;
						board[r][k] = 0;
						c++;
						flag = true;
						if(c >= N) break out;
					}else if(board[r][c] == 0 && board[r][k] != 0) {
						board[r][c] = board[r][k];
						board[r][k] = 0;
					}else if(board[r][k] != 0 && board[r][c] != board[r][k]) {
						continue out;
					}
				}//k	
			}//c
		}//r
		return flag;
	}//MoveLeft
	
	static boolean MoveRight() {
		boolean flag = false;
		for(int r = 0; r < N; r++) {
			out : for(int c = N-1; c >= 0; c--) {
				for(int k = c-1; k >= 0; k--) {
					if(board[r][k] != 0 && board[r][c] == board[r][k]) {
						board[r][c] = board[r][k] * 2;
						board[r][k] = 0;
						c--;
						flag = true;
					}else if(board[r][c] == 0 && board[r][k] != 0) {
						board[r][c] = board[r][k];
						board[r][k] = 0;
					}else if(board[r][k] != 0 && board[r][c] != board[r][k]) {
						continue out;
					}
				}//k	
			}//c
		}//r
		return flag;
	}//MoveRight
	
	static boolean MoveUp() {
		boolean flag = false;
		for(int c = 0; c < N; c++) {
			out : for(int r = 0; r < N-1; r++) {
				for(int k = r+1; k < N; k++) {
//					System.out.println("r=" + r + " k=" + k);
					if(board[k][c] != 0 && board[r][c] == board[k][c]) {
						board[r][c] = board[k][c] * 2;
						board[k][c] = 0;
						flag = true;
						r++;
						if(r >= N) break out;
					}else if(board[r][c] == 0 && board[k][c] != 0) {
						board[r][c] = board[k][c];
						board[k][c] = 0;
					}else if(board[k][c] != 0 && board[r][c] != board[k][c]) {
						continue out;
					}
				}//k	
			}//c
		}//r
		return flag;
	}//MoveUp
	
	static boolean MoveDown() {
		boolean flag = false;
		for(int c = 0; c < N; c++) {
			out : for(int r = N-1; r >= 0; r--) {
				for(int k = r-1; k >= 0; k--) {
					if(board[k][c] != 0 && board[r][c] == board[k][c]) {
						board[r][c] = board[k][c] * 2;
						board[k][c] = 0;
						r--;
						flag = true;
					}else if(board[r][c] == 0 && board[k][c] != 0) {
						board[r][c] = board[k][c];
						board[k][c] = 0;
					}else if(board[k][c] != 0 && board[r][c] != board[k][c]) {
						continue out;
					}
				}//k	
			}//c
		}//r
		return flag;
	}//MoveDown
	
}//class
