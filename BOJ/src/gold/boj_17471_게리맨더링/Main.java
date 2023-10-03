package gold.boj_17471_게리맨더링;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, min;
	static int[] pop;
	static boolean[] visited;
	static int[][] adjArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//구역의 개수
		N = sc.nextInt();
		
		//인구 수 입력 배열
		pop = new int[N+1];
		for(int i = 1; i <= N; i++) {
			pop[i] = sc.nextInt();
		}
		
		//인접행렬
		adjArr = new int[N+1][N+1];
		
		//인접리스트 입력
		for(int i = 1; i <= N; i++) {
			//해당 구역과 인접한 구역의 수
			int n = sc.nextInt();
			for(int j = 0; j < n; j++) {
				adjArr[i][sc.nextInt()] = 1;
			}
		}
		
		//방문체크를 위한 boolean 배열 생성
		visited = new boolean[N+1];
		//최솟값을 구하기 위한 변수 설정
		min = Integer.MAX_VALUE;
		//부분집합 만들기
		powerset(1);
		//최솟값이 처음 설정한 integer 최대값이 나오면 두 선거구로 나눌 수 없는 경우이므로 -1 출력
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
			
		
	}//main
	
	//부분집합 만들기
	static void powerset(int depth) {
		if(depth == N+1) {
			//true인 요소는 setA에 넣고
			List<Integer> setA = new ArrayList<>();
			//false인 요소는 setB에 넣어 구역A와 구역b로 나누기
			List<Integer> setB = new ArrayList<>();
			//구역A의 인구수
			int popA = 0;
			//구역B의 인구수
			int popB = 0;
			for(int i = 1; i <= N; i++) {
				if(visited[i]) {
					setA.add(i);
					popA += pop[i];
				}else {
					setB.add(i);
					popB += pop[i];
				}
			}
			
			//구역A와 구역B가 모두 연결되어 있으면
			if(isConnected(setA) && isConnected(setB)) {
				// 두 구역의 인구수의 차이를 구하고 최소값 갱신
				int diff = Math.abs(popA - popB);
				min = min > diff ? diff : min ;
				return;
			}
			return;
		}
		
		//부분집합 만들기
		visited[depth] = true;
		powerset(depth + 1);
		visited[depth] = false;
		powerset(depth + 1);
	}

	static boolean isConnected(List<Integer> set) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		//각 선거구는 구역을 적어도 하나는 포함해야 하기 때문에 set의 크기가 0이면 false를 반환하여 거르기
		if(set.size() == 0) return false;
		
		//bfs를 이용하여 연결되어 있는지 확인
		q.add(set.get(0));
		while(!q.isEmpty()) {
			int curr = q.poll();
			visited[curr] = true;
			for(int i = 0; i < set.size(); i++) {
				if(!visited[set.get(i)] && adjArr[curr][set.get(i)] == 1) {
					visited[set.get(i)] = true;
					q.add(set.get(i));
				}
			}
		}
		
		//set에 포함되어 있고, 모두 방문했으면 구역이 모두 연결되어 있으므로 true 반환
		//set에 포함되어 있는데 방문하지 않은 구역이 있으면 연결되어 있지 않으므로 false 반환
		for(int i = 0; i < N+1; i++) {
			if(set.contains(i) && !visited[i]) {
				return false;
			}
		}
		return true;
	}

}//class
