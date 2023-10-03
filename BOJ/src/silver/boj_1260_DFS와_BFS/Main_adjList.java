package silver.boj_1260_DFS와_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_adjList {
	static int N, M, V;
	static List<Integer>[] adjList;
	static StringBuilder sb;
	static boolean[] visited;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정점의 개수
		N = sc.nextInt();
		//간선의 개수
		M = sc.nextInt();
		//탐색을 시작할 정점의 번호
		V = sc.nextInt();
		
		adjList = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			adjList[st].add(ed);
			adjList[ed].add(st);
		}
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		q = new LinkedList<>();
		bfs(V);
		System.out.println(sb);
		
	}//main
	
	static void bfs(int v) {
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr + " ");
			List<Integer> adj = adjList[curr];
			for(int i = 0; i < N+1; i++) {
				if(!visited[i] && adj.contains(i)) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		List<Integer> adj = adjList[v];
		for(int i = 0; i < N+1; i++) {
			if(!visited[i] && adj.contains(i)) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
}//class
