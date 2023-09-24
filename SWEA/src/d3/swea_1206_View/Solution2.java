package d3.swea_1206_View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1206_View/input.txt");
		Scanner sc = new Scanner(file);
		
		for(int tCase = 1; tCase <= 10; tCase++) {
			// 건물의 개수 스캔
			int N = sc.nextInt();
			// 빌딩의 높이를 입력받기 위해 건물의 개수만큼 1차원 배열 생성
			int[] buildings = new int[N];
			// 빌딩의 높이 입력
			for(int i = 0; i < N; i++) {
				buildings[i] = sc.nextInt();
			}
			
			int sum = 0;
			int view = 0;
			
			for(int i = 2; i < N-2; i++) {
				// 양 옆 두개의 건물이 현 위치의 건물보다 낮아야 조망권 확보가능
				// 더 낮거나 같은지 확인하기 위해 boolean 설정
				boolean isLower = true;
				
				// 현 위치보다 더 높은 건물이 있으면 false가 되고, 반복문 종료
				for(int k = -2; k <= 2; k++) {
					if(buildings[i+k] > buildings[i]) {
						isLower = false;
						break;
					}
				}
				
				// 주변 건물 중 최고 높이 구하기
				int maxHeight = 0;
				
				// 주변건물이 모두 낮거나 같은 높이일 때
				if(isLower == true) {
					// 주변 건물 중 최고 높이 구하기
					for(int k = -2; k <=2; k++) {
						if(k != 0 && buildings[i+k] > maxHeight) {
							maxHeight = buildings[i+k];
						}
					} // 양 옆을 탐색하기 위한 k for문
					view = buildings[i] - maxHeight;
					sum += view;
				} // isLower 조건문
				
			} // 양 옆 두 건물을 확인해야 하므로 기준점을 2~N-3까지 탐색
			
			System.out.printf("#%d %d\n", tCase, sum);
		
		} // tCase for문
	} // main
}
