package 모의SW.swea_4014_활주로_건설;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_4014_활주로_건설/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스의 개수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//지도의 한 변의 크기
			int N = sc.nextInt();
			
			//경사로의 길이
			int X = sc.nextInt();
			
			//N*N 크기의 지도
			map = new int[N][N];
			//지형의 높이 입력
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}//입력 끝
			
			//설치 가능한 활주로의 개수를 카운팅하기 위한 변수
			int cnt = 0;
			
			//1. 가로 활주로 탐색
			out: for(int r = 0; r < N; r++) {
				//높이가 동일한 연속된 지형의 개수
				int sameHeight = 0;
				for(int c = 1; c < N;) {
					//1-1. 이전 지형의 높이와 2 이상 차이가 나면 경사로 설치 불가능
					//(-> 경사로의 높이가 1로 고정되어 있음)
					if(Math.abs(map[r][c] - map[r][c-1]) >= 2) {
						continue out;
					}
					//1-2. 이전 지형과 높이가 동일한 경우, 경사로 길이만큼 해당하는지 확인하기 위해 동일 높이 지형 개수 카운트
					else if(map[r][c] - map[r][c-1] == 0) {
						sameHeight++;
						c++;
					}
					//1-3. 높이가 1만큼 높아지는데 앞에 경사로를 설치할 길이가 모자라는 경우 경사로 설치 불가능
					else if(map[r][c] - map[r][c-1] == 1 && sameHeight < X-1) {
						continue out;
					}
					//1-4. 높이가 1만큼 높아지는데 앞에 경사로를 설치할 길이가 충분하므로 계속 탐색
					else if(map[r][c] - map[r][c-1] == 1 && sameHeight >= X-1) {
						sameHeight = 0;
						c++;
					}
					//1-5. 높이가 1만큼 낮아지는 경우,뒤에 같은 높이의 지형이 있지 않으면 경사로 설치 불가능
					else if(map[r][c] - map[r][c-1] == -1) {
						sameHeight = 0;
						for(int k = 0; k < X; k++) {
							if(c+k >= N)
								continue out;
							else if(map[r][c] != map[r][c+k])
								continue out;
						}
						c += X;
					}
				}//c
				//위의 반복문의 조건을 모두 통과하고 나오면 활주로 설치 가능
				cnt++;
			}//r
		
			//2. 세로 활주로 탐색
			out: for(int c = 0; c < N; c++) {
				//높이가 동일한 연속된 지형의 개수
				int sameHeight = 0;
				for(int r = 1; r < N;) {
					//1-1. 이전 지형의 높이와 2 이상 차이가 나면 경사로 설치 불가능
					//(-> 경사로의 높이가 1로 고정되어 있음)
					if(Math.abs(map[r][c] - map[r-1][c]) >= 2) {
						continue out;
					}
					//1-2. 이전 지형과 높이가 동일한 경우, 경사로 길이만큼 해당하는지 확인하기 위해 동일 높이 지형 개수 카운트
					else if(map[r][c] - map[r-1][c] == 0) {
						sameHeight++;
						r++;
					}
					//1-3. 높이가 1만큼 높아지는데 앞에 경사로를 설치할 길이가 모자라는 경우 경사로 설치 불가능
					else if(map[r][c] - map[r-1][c] == 1 && sameHeight < X-1) {
						continue out;
					}
					//1-4. 높이가 1만큼 높아지는데 앞에 경사로를 설치할 길이가 충분하므로 계속 탐색
					else if(map[r][c] - map[r-1][c] == 1 && sameHeight >= X-1) {
						sameHeight = 0;
						r++;
					}
					//1-5. 높이가 1만큼 낮아지는 경우,뒤에 같은 높이의 지형이 있지 않으면 경사로 설치 불가능
					else if(map[r][c] - map[r-1][c] == -1) {
						sameHeight = 0;
						for(int k = 0; k < X; k++) {
							if(r+k >= N)
								continue out;
							else if(map[r][c] != map[r+k][c])
								continue out;
						}
						r += X;
					}
				}//c
				//위의 반복문의 조건을 모두 통과하고 나오면 활주로 설치 가능
				cnt++;
			}//r
			
			System.out.println("#" + tc + " " + cnt);
			
		}//tc
	}//main
}//Solution
