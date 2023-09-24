package d4.swea_7465_창용_마을_무리의_개수;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] p;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d4/swea_7465_창용_마을_무리의_개수/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스의 수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//창용 마을 사람의 수
			int N = sc.nextInt();
			//M개의 관계
			int M = sc.nextInt();
			
			p = new int[N+1]; 
			//makeset(1~6)
			//유일한 멤버 i를 가지는 새로운 집합 생성
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 1; i <= M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}
			
			//본인이 본인 집합의 대표인 집합의 개수를 세면 무리의 개수를 확인할 수 있음
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(p[i] == i) 
					cnt++;
			}
			
			System.out.println("#" + tc + " " + cnt);
			
		}//tc
	}//main
	
	static void union(int a, int b) {
		p[findset(b)] = findset(a);
	}

	static int findset(int a) {
		if(p[a] != a) {
			p[a] = findset(p[a]);
		}
		return p[a];
	}
	
}//Solution
