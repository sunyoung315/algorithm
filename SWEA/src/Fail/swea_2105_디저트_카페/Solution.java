package Fail.swea_2105_디저트_카페;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[][] cafe;
	//상우, 하우, 하좌, 상좌 방향 이동 
	static int[] dr = {-1, 1, 1, -1};
	static int[] dc = {1, 1, -1, -1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_2105_디저트_카페/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//지역의 한 변의 길이
			int N = sc.nextInt();
			cafe = new int[N][N];
			
			//해당 디저트 카페에서 팔고 있는 디저트의 종류
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cafe[i][j] = sc.nextInt();
				}
			}//입력 끝

			
			
		}//tc
		
	}//main
}//Solution
