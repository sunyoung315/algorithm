package Fail.swea_2105_디저트_카페;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[][] dessert;
	//상우, 하우, 하좌, 상좌 방향 이동 
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {-1, 1, 1, -1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/Fail/swea_2105_디저트_카페/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//지역의 한 변의 길이
			int N = sc.nextInt();
			dessert = new int[N][N];
			
			//해당 디저트 카페에서 팔고 있는 디저트의 종류
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dessert[i][j] = sc.nextInt();
				}
			}//입력 끝
			
//			for(int r = 0; r < N; r++) {
//				for(int c = 0; c < N; c++) {
//					System.out.print(dessert[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			List<Integer> eat = new ArrayList<>();
			//최대 디저트 개수
			int max = 0;
			for(int r = 0; r < N-2; r++) {
				out: for(int c = 1; c < N-1; c++) {
					System.out.println("r: " + r + " c: " + c);
					eat.add(dessert[r][c]);
					
					int nr = r;
					int nc = c;
					for(int dir = 0; dir < 4; dir++) {
						while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							nr += dr[dir];
							nc += dc[dir];
							if(nr >= 0 && nr < N && nc >= 0 && nc < N && !eat.contains(dessert[nr][nc])) {
								eat.add(dessert[nr][nc]);
							}
						}
					}
					System.out.println(eat);
					
					max = max > eat.size() ? eat.size() : max;
					eat.clear();
					
				}
			}
			
			System.out.println(max);
			
		}//tc
		
	}//main
}//Solution
