package d4.swea_1226_미로1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] maze;
	static boolean[][] visited;
	//상, 하, 좌, 우 뱡향전환
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d4/swea_1226_미로1/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc = 0;
		while(tc < 10) {
			//테스트케이스 번호
			tc = sc.nextInt();
			
			//16*16 크기의 미로 배열 생성
			maze = new int[16][16];
			
			//방문체크용 배열
			visited = new boolean[16][16];
			
			Queue<Pos> q = new LinkedList<>();

			for(int i = 0; i < 16; i++) {
				String str = sc.next();
				for(int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j) - '0';
					if(maze[i][j] == 2) {
						q.add(new Pos(i, j));
						
					}
				}
			}//미로 입력 끝
			
			int answer = 0;
			out: while(!q.isEmpty()) {
				Pos curr = q.poll();
				for(int dir = 0; dir < 4; dir++) {
					int nr = curr.r + dr[dir];
					int nc = curr.c + dc[dir];
					if(nr < 0 || nr >= 16 || nc < 0 || nc >= 16
							|| visited[nr][nc] || maze[nr][nc] == 1) {
						continue;
					}
					if(maze[nr][nc] == 3) {
						answer = 1;
						break out;
					}
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
			
		}
		
	}//main

}//Solution
