package d4.swea_3289_서로소_집합;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] p;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d4/swea_3289_서로소_집합/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//집합의 개수
			int n = sc.nextInt();
			
			p = new int[n+1];
			//makeset
			for(int i = 1; i <= n; i++) {
				//유일한 멤버 i를 포함하는 새로운 집합을 생성(1~n)
				p[i] = i;
			}
			
			//연산의 개수
			int m = sc.nextInt();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for(int i = 0; i < m; i++) {
				int order = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				//0: 합집합, 1: 두 원소가 같은 집합에 포함되어 있는지 확인
				if(order == 0) {
					union(a, b);
				}else {
					//대표가 다르면 0
					if(findset(a) != findset(b)) {
						sb.append(0);
					//대표가 같으면 1
					}else {
						sb.append(1);
					}
				}
			}
			
			System.out.println(sb);
			
		}//tc
		
	}//main
	
	//포함하는 집합 찾기
	static int findset(int a) {
		//path compression
		//findset을 하는 과정에서 만나는 모든 노드들이 직접 root를 가리키도록 포인터를 바꿔줌
		if(p[a] != a) {
			p[a] = findset(p[a]);
		}
		return p[a];
	}

	//a와 b를 포함하는 두 집합을 통합
	static void union(int a, int b) {
		//b의 대표자를 a의 대표자로 변경
		p[findset(b)] = findset(a);
	}
	
}//Solution
