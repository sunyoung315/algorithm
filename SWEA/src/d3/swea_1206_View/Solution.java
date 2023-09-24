package d3.swea_1206_View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Solution {
	public static void main(String[] args) {

		try {
			System.setIn(new FileInputStream("src/SWEA_1206_View/input.txt"));
			
			Scanner sc = new Scanner(System.in);
			int T = 10;
			
			int test_case = 0;
			for(test_case = 1; test_case <= T; test_case++) {
				int N = sc.nextInt();
				
				int[] b = new int[N];
				for(int i = 0; i < N; i++) {
					b[i] = sc.nextInt();
				}
				
				
				int sum = 0;
				// 양쪽의 0을 제외하고 반복문 순회
				for(int i = 2; i < N-2; i++) {
					// i-2부터 i+2번째 건물 중 i번째보다는 낮고 나머지 중 가장 높은 건물의 높이를 할당하기 위해 변수 선언
					int height = 0;
					// i번째 건물의 높이가 i-2, i-1, i+1, i+2번째 건물의 높이보다 높을 때만 height 할당
					if(b[i]-b[i-2] > 0 && b[i]-b[i-1] > 0 && b[i]-b[i+1] > 0 && b[i]-b[i+2] > 0) {
						for(int j = i-2; j <= i+2; j++) {
							// i번째 건물보다는 낮지만 나머지 중 가장 높은 건물의 높이를 구함
							if(b[j] > height && b[j] < b[i]) {
								height = b[j];
							}
						}
						// i번째 건물의 높이에서 주변 건물 중 가장 높은 건물의 높이를 빼서 조망권이 확보된 층 구하기
						// 0으로 초기화한 sum에 더해서 모든 건물의 조망권이 확보된 층들의 합을 구함
						sum += b[i]-height;
					}
				}
				System.out.printf("#%d %d\n", test_case, sum);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

			

		
	}
}
