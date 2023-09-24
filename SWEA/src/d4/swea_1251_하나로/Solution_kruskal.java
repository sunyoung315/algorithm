package d4.swea_1251_하나로;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_kruskal {
	static int[] x, y, p;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d4/swea_1251_하나로/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//섬의 개수
			int N = sc.nextInt();
			
			//섬들의 x좌표
			x = new int[N];
			for(int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			
			//섬들의 y좌표
			y = new int[N];
			for(int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}
			
			//환경부담세율
			double E = sc.nextDouble();
			
			//간선의 개수
			int e = N * (N - 1) / 2;
			
			//간선배열
			double[][] edges = new double[e][3];
			
			int idx = 0;
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					double d =  Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);
					//a섬
					edges[idx][0] = i;
					//b섬
					edges[idx][1] = j;
					//두 섬 사이 거리의 제곱
					edges[idx][2] = d;
					idx++;
				}
			}
			
			//거리 제곱 값을 기준으로 오름차순 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2] - o2[2]);
				}
			});
			
			//makeset(유일한 멤버 i를 가지는 집합 생성)
			p = new int[N];
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			//최소 거리를 저장할 변수
			double ans = 0;
			//뽑은 간선의 수를 저장할 변수
			int pick = 0;
			
			for(int i = 0; i < e; i++) {
				int a = (int) edges[i][0];
				int b = (int) edges[i][1];
				//a와 b가 사이클을 이루는지 확인(둘의 대표가 같으면 사이클 형성)
				if(findset(a) != findset(b)) {
					union(a, b);
					ans += edges[i][2];
					pick++;
				}
				if(pick == N-1) break;
			}
			
			System.out.println("#" + tc + " " + Math.round(ans * E));
			
		}//tc
	}//main
	
	static void union(int a, int b) {
		p[findset(a)] = findset(b);
	}

	static int findset(int a) {
		if(p[a] != a) {
			p[a] = findset(p[a]);
		}
		return p[a];
	}
	
}//Solution
