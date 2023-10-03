package silver.boj_1260_DFS와_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_adjArr {
	static int N, M, V;
	static int[][] adjArr;
	static boolean[] visited;
	static Queue<Integer> q;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정점의 개수
		N = sc.nextInt();
		//간선의 개수
		M = sc.nextInt();
		//탐색을 시작할 정점의 번호
		V = sc.nextInt();
		
		//인접행렬
		adjArr = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			adjArr[st][ed] = 1;
			adjArr[ed][st] = 1;
		}
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);
		
		q = new LinkedList<>();
		visited = new boolean[N+1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb);
		
	}//main

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		for(int i = 0; i < N+1; i++) {
			if(!visited[i] && adjArr[v][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

	static void bfs(int v) {
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr + " ");
			for(int i = 0; i < N+1; i++) {
				if(!visited[i] && adjArr[curr][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}//class
