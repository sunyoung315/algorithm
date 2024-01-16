package gold.boj_11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + ", w=" + w + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//도시의 개수
		int N = Integer.parseInt(st.nextToken());
		//버스 노선의 개수
		int M = Integer.parseInt(st.nextToken());
		
		//간선배열
		List<Edge> edges = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(start, end, weight)); 
		}//입력 끝
		
		long[] dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		for(int i = 1; i <= N; i++) {
			for(Edge e: edges) {
				if(dist[e.st]== Long.MAX_VALUE) continue;
				
				if(dist[e.st] + e.w < dist[e.ed]) {
					dist[e.ed] = dist[e.st] + e.w;
					
					if(i == N) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			if(dist[i] != Long.MAX_VALUE) {
				System.out.println(dist[i]);
			} else {
				System.out.println(-1);
			}
		}
		
	}//main
}//class
