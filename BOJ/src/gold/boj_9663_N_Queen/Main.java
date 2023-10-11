package gold.boj_9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	//체스판의 크기
	static int N;
	//서로 공격할 수 없게 놓는 경우의 수
	static int cnt;
	//현재 Queen을 기준 위로 왼쪽, 위쪽 오른쪽 대각선에 Queen이 있는지 확인할 것
	static int[] dc = {-1, 0, 1};
	//체스판 2차원 배열
	static int[][] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//체스판 크기 입력
		N = Integer.parseInt(br.readLine());
		///N*N 크기의 체스판 생성
		board = new int[N][N];
		
		//경우의 수 0으로 초기화
		cnt = 0;
		
		//0번째 행(r)부터 dfs 진행
		dfs(0);
		
		//정답 출력
		System.out.println(cnt);
		
	}//main
	
	static void dfs(int depth) {
		//기저파트
		if(depth == N) {
			//depth가 N까지 도달하면 서로 공격할 수 없게 놓아졌으므로 cnt 증가
			cnt++;
			return;
		}
		//재귀파트
		out: for(int c = 0; c < N; c++) {
			//depth가 0(첫번째 행에 체스를 두는 경우)일 때는 
			//위의 행에 고려할 것이 없으므로 체스를 두고 시작
			if(depth == 0) {
				board[depth][c] = 1;
			}
			else {
				//현재 위치 r보다 몇번째 위의 행에 있는지 확인할 변수
				int d = 0;
				//현재 위치에서 위로 Queen이 공격할 수 있는 위치에 Queen이 있는지 확인
				for(int r = depth-1; r >= 0; r--) {
					d++;
					//위로 왼쪽 대각선, 위쪽 직선, 오른쪽 대각선에 Queen이 발견되면 현재 위치 불가능
					//out 반복문을 continue하여 다음 열에 Queen을 둘 수 있는지 탐색
					for(int dir = 0; dir < 3; dir++) {
						if((c + dc[dir] * d) >= 0 && (c + dc[dir] * d) < N 
								&& board[r][c + dc[dir] * d] == 1) {
							continue out;
						}
					}
				}
				//for문을 끝내고 나오면 현재 위치에 Queen을 둘 수 있으므로 1로 저장
				board[depth][c] = 1;
			}
			dfs(depth + 1);
			board[depth][c] = 0;
		}
	}//dfs
	
}//class
