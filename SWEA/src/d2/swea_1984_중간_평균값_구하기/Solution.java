package d2.swea_1984_중간_평균값_구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_1984_중간_평균값_구하기/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int test_case;
		for(test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			for(int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			
			// 제약사항에 나온 범위로 max와 min 초기화
			int max = 0;
			int min = 1001;
			for(int j = 0; j < 10; j++) {
				if(arr[j] > max) {
					max = arr[j];
				} else if(arr[j] < min) {
					min = arr[j];
				}
 			}
			
			// 배열의 모든 요소를 더해서 합을 구함
			// 소수점 첫째자리에서 반올림 해야 하므로 sum의 변수 타입을 double로!!
			double sum = 0;
			for(int j = 0; j < 10; j++) {
				sum += arr[j];
			}
			
			// 최대 수와 최소 수를 제외한 나머지의 평균 값을 구하기 위해
			// sum에서 위에서 구한 max와 min을 빼주고 10-2(8)로 나누기
			double avg = (sum - max - min) / 8; 
			
			
			// Math.round(); -> 소수 첫째자리에서 반올림
			System.out.printf("#%d %d\n", test_case, Math.round(avg));		
			
		}
		
	}
}
