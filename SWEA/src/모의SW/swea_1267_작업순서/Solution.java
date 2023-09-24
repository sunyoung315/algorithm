package 모의SW.swea_1267_작업순서;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] adjArr;
	static int[] indegree;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_1267_작업순서/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			//정점의 개수
			int V = sc.nextInt();
			//간선의 개수
			int E = sc.nextInt();
			
			//인접행렬
			adjArr = new int[V+1][V+1];
			//진입차수
			indegree = new int[V+1];
			
			for(int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjArr[a][b] = 1;
				indegree[b]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			//초기 진입차수가 0인 것은 모두 q에 넣기(선행작업x)
			for(int i = 1; i < V+1; i++) {
				if(indegree[i] == 0)
					q.add(i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			while(!q.isEmpty()) {
				//현재 작업 빼서 출력(작업완료)
				int work = q.poll();
				sb.append(work + " ");
				//현재작업에 연결되어 있는 간선 제거 & 진입차수 감소
				for(int i = 1; i < V+1; i++) {
					if(adjArr[work][i] == 1) {
						adjArr[work][i] = 0;
						indegree[i]--;
						//진입차수가 0ㅇ이면, 선행작업완료 -> q에 삽입
						if(indegree[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			
			System.out.println(sb);
			
		}//tc
	}//main
}//Solution
