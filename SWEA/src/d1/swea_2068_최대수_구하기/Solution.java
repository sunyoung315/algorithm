package d1.swea_2068_최대수_구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_2068_최대수_구하기/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int test_case;
		for(test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 정수의 최소값으로 max 초기화
			int max = Integer.MIN_VALUE;
			
			// for-each구문으로 2개의 요소씩 max값을 비교하여 최대값 구하기
			for(int i: arr) {
				max = Math.max(max, i);
			}
			
			System.out.printf("#%d %d\n",test_case, max);
		}
	
	}
}
