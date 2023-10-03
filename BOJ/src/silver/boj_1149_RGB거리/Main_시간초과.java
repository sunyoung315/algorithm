package silver.boj_1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_시간초과 {
	static int N, sum, min;
	static int[] color;
	static int[][] cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		//집의 수
		N = Integer.parseInt(str);
		
		//[집번호][0:빨강, 1:초록, 2:파랑]
		cost = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 완료
		

		//집에 칠하는 색을 저장하기 위한 배열 생성
		color = new int[N+1];
		//최소비용을 저장하기 위한 변수(Integer.MAX_VALUE로 초기화)
		min = Integer.MAX_VALUE;
		//(0:빨강, 1:초록, 2:파랑)로 만들 수 있는 순열
		perm(1);
		
		System.out.println(min);
		
	}//main
	
	static void perm(int depth) {
		//기저파트
		if(depth == N+1) {
			//해당 RGB거리를 칠하는데 필요한 총 비용을 저장하기 위한 변수
			sum = 0;
			for(int i = 1; i < N+1; i++) {
				//i번째 집의 색깔(color[i])에 해당하는 비용를 총 비용에 더해주기
				sum += cost[i][color[i]];
			}
			//최소값 갱신
			min = min > sum ? sum : min;
			return;
		}
		//재귀파트
		//3가지 색깔로 순열 생성(0:빨강, 1:초록, 2:파랑) 
		for(int i = 0; i < 3; i++) {
			//첫번째 집은 아무 색이나 칠할 수 있음
			if(depth  == 1) {
				color[depth] = i;
				perm(depth + 1);
			//두번째 집부터는 앞 집과는 색이 달라야 한다는 조건 추가
			}else {
				if(color[depth-1] != i) {
					color[depth] = i;
					perm(depth + 1);
				}
			}
		}
	}
	
}//class
