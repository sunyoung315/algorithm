package silver.boj_1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//RGB거리에 있는 집의 수
		int N = Integer.parseInt(br.readLine());
		//각각의 집을 빨강(0), 초록(1), 파랑(2)으로 칠하는 비용
		int[][] cost = new int[N+1][3];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		//마지막 집이 고르는 색깔의 최소 비용 저장하기 위한 배열
		int[][] house = new int[N+1][3];

		//첫번째 집은 그대로 각 색깔마다의 비용 저장
		for(int i = 0; i < 3; i++) {
			house[1][i] = cost[1][i];
		}
		
		//2번째 집부터 시작
		for(int i = 2; i <= N; i++) {
			//i번째의 색깔
			for(int k = 0; k < 3; k++) {
				int min = Integer.MAX_VALUE;
				//i-1번재의 색깔
				for(int j = 0; j < 3; j++) {
					//이웃한 집의 색은 동일하지 않을 경우,
					if(j != k) {
						//house[i-1][j]: i-1번째 집이 j색깔일 때의 최소 비용
						//cost[i][k] : i번째 집이 k색깔일 때의 비용
						//두 값을 더해서 min값 갱신
						min = min > house[i-1][j] + cost[i][k] ? house[i-1][j] + cost[i][k] : min;
					}
				}
				//house[i][k]: i번째 집에 k컬러를 칠하기 위한 최소값 저장
				house[i][k] = min;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			//i번째 집을 어떤 색으로 칠할 때 최소값이 나오는지 구하기
			min = Math.min(house[N][i], min);
		}
		System.out.println(min);
		
	}//main
}//class
