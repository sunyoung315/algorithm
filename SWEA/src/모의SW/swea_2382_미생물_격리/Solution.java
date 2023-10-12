package 모의SW.swea_2382_미생물_격리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	//상, 하, 좌, 우
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	static class Micro {
		int r, c, cnt, dir;
		public Micro(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "(" + cnt + "," + dir + ")" ;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_2382_미생물_격리/input.txt"));
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 개수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//구역의 한 변에 있는 셀의 개수
			int N = sc.nextInt();
			//격리 시간
			int M = sc.nextInt();
			//미생물 군집의 개수
			int K = sc.nextInt();
			
			List<Micro>[][] cell = new ArrayList[N][N];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					cell[r][c] = new ArrayList<>();
				}//c
			}//r
			
			Queue<Micro> q = new LinkedList<>();
			for(int k = 1; k <= K; k++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt();
				Micro m = new Micro(r, c, cnt, dir);
				cell[r][c].add(m);
				q.add(m);
			}//미생물 입력 끝
			
			for(int time = 1; time <= M ;time++) {
				
				for(int k = 1; k <= K; k++) {
					Micro curr = q.poll();
					int r = curr.r;
					int c = curr.c;
				
					if(!cell[r][c].isEmpty()) {
						//현재 이동 방향방향
						int currDir = cell[r][c].get(0).dir;
						//현재 미생물 개수
						int currCnt = cell[r][c].get(0).cnt;
						//다음 위치
						int nextR = r + dr[currDir];
						int nextC = c + dc[currDir];
						
						//약품을 칠한 셀로 이동한 경우
						if(nextR == 0 || nextR == N-1 || nextC == 0 || nextC == N-1) {
							
							//약품을 칠한 곳에 도달한 경우 바뀌는 이동 방향
							int nextDir = 0;
							if (currDir % 2 == 1) { // 홀수인 경우 반대 방향으로 변경
								nextDir = currDir + 1;
							} else { // 짝수인 경우 반대 방향으로 변경
								nextDir = currDir - 1;
							}
							
							//약품을 칠한 곳에 도달한 경우 바뀌는 미생물의 수
							int nextCnt = currCnt / 2;
							//미생물의 수가 0이 되지 않는 경우
							if(nextCnt != 0) {
								Micro micro = new Micro(nextR, nextC, nextCnt, nextDir);
								cell[nextR][nextC].add(micro);
								q.add(micro);
								cell[r][c].remove(0);
							//0이 되는 경우
							} else {
								cell[r][c].remove(0);
								K--;
							}
						}
						//그냥 이동하는 경우
						else {
							Micro micro = new Micro(nextR, nextC, currCnt, currDir);
							cell[nextR][nextC].add(micro);
							q.add(micro);
							cell[r][c].remove(0);
						}
					}//isEmpty
					
				}//k
				
				//2개 이상의 군집이 있는 곳 합치기
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						List<Micro> micros = cell[r][c];
						int sumCnt = 0;
						int maxCnt = 0;
						int newDir = 0;
						if(micros.size() >= 2) {
							for(int i = 0; i < micros.size(); i++) {
								sumCnt += micros.get(i).cnt;
								if(micros.get(i).cnt > maxCnt) {
									maxCnt = micros.get(i).cnt;
									newDir = micros.get(i).dir;
								}
							}
							cell[r][c].clear();
							cell[r][c].add(new Micro(r, c, sumCnt, newDir));
						}
					}
				}
				
			}//time
			
			int sum = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!cell[r][c].isEmpty())
						sum += cell[r][c].get(0).cnt;
				}
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}//tc
	}//main
}//Solution
