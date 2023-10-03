package gold.boj_1647_도시_분할_계획;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static List<Edge>[] adjList;
	static class Edge implements Comparable<Edge> {
		int ed, cost;
		public Edge(int ed, int cost) {
			this.ed = ed;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	static boolean[] visited;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//집의 개수
		N = sc.nextInt();
		//길의 개수
		M = sc.nextInt();
		
		//인접리스트
		adjList = new ArrayList[N+1];
		//리스트 생성
		for(int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//간선 입력(양방향)
		for(int i = 0; i < M; i++) {
			//시작점
			int st = sc.nextInt();
			//도착점
			int ed = sc.nextInt();
			//유지비
			int cost = sc.nextInt();
			//양방향 저장
			adjList[st].add(new Edge(ed, cost));
			adjList[ed].add(new Edge(st, cost));
		}
		
		//방문체크 하기 위한 boolean 배열 생성
		visited = new boolean[N+1];
		//해당 정점과 연결된 간선들을 넣기 위한 우선순위 큐 생성
		pq = new PriorityQueue<>();

		//1번을 넣고 시작
		visited[1] = true;
		pq.addAll(adjList[1]);
		
		prim(1);
	}//main

	static void prim(int start) {
		//뽑은 정점의 수(1을 뽑은 상태로 시작했기 때문에 1로 초기화)
		int pick = 1;
		//최소경로의 유지비 합을 구하기 위한 변수
		int sum = 0;
		//경로들 중 가장 큰 유지비를 구하기 위한 변수
		int max = 0;
		
		//N개의 정점을 모두 뽑을 때까지 반복
		while(pick != N) {
			//우선순위 큐에서 자동 정렬 -> 유지비가 가장 작은 간선 뽑기
			Edge e = pq.poll();
			//간선의 도착점이 방문하지 않은 정점이면
			if(!visited[e.ed]) {
				//간선의 도착점 방문 체크
				visited[e.ed]= true;
				//간선의 도작점(정점)을 뽑았기 때문에 pick 증가 
				pick++;
				//해당 간선의 도착점과 연결된 간선 우선순위 큐에 넣기
				pq.addAll(adjList[e.ed]);
				//해당 간선의 유지비 더하기
				sum += e.cost;
				//최대 유지비 갱신
				max = e.cost > max ? e.cost : max;
			}
		}
		
		//위의 반복문이 종료되면, 최소경로에서 최대 유지비인 경로를 삭제하면 
		//나머지 길의 유지비의 합을 최소로 만들 수 있음
		System.out.println(sum - max);
		
	}
}//class
