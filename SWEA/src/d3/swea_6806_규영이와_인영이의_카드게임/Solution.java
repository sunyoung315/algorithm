package d3.swea_6806_규영이와_인영이의_카드게임;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] cardIY, cardKY, outIY;
	static boolean[] isKY, visited;
	static int win, lose;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d3/swea_6806_규영이와_인영이의_카드게임/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			cardKY = new int[9];
			isKY = new boolean[19];
			for(int i = 0; i < 9; i++) {
				cardKY[i] = sc.nextInt();
				for(int j = 1; j <= 18; j++) {
					if(cardKY[i] == j)
						isKY[j] = true;
				}
			}
			
			cardIY = new int[9];
			int idx = 0;
			for(int i = 1; i <= 18; i++) {
				if(!isKY[i])
					cardIY[idx++] = i;
			}
			outIY = new int[9];
			visited = new boolean[9];
			
			win = 0;
			lose = 0;
			perm(0);
			System.out.printf("#%d %d %d\n", tc, win, lose);
			
		}//tc
	}//main
	
	static void perm(int depth) {
		//기저파트
		if(depth == 9) {
			int scoreKY = 0;
			int scoreIY = 0;
			for(int i = 0; i < 9; i++) {
				if(cardKY[i] > outIY[i]) 
					scoreKY += cardKY[i] + outIY[i];
				else
					scoreIY += cardKY[i] + outIY[i];
			}
			if(scoreKY > scoreIY) win++;
			else lose++;
			return;
		}
		//재귀파트
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				outIY[depth] = cardIY[i];
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
	
}//Solution