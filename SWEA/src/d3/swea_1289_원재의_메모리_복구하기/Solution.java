package d3.swea_1289_원재의_메모리_복구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea_1289_원재의_메모리_복구하기/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 입력
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			//주어진 메모리 String입력 -> String[] -> int[] memory1 생성
			String[] str = sc.next().split("");
			int[] memory1 = new int[str.length];
			for(int i = 0; i < memory1.length; i++) {
				memory1[i] = Integer.parseInt(str[i]);
			}
			
			//0으로 초기화된 memory2 int배열 생성
			int[] memory2 = new int[memory1.length];
			//고친 횟수를 세기 위한 cnt변수 생성 및 0으로 초기화
			int cnt = 0;
			
			for(int i = 0; i < memory1.length; i++) {
				//memory1과 memory2의 같은 인덱스의 요소를 비교하여 다르면
				if(memory1[i] != memory2[i]) {
					//i번째부터 끝까지 memory1의 i번째 요소 고치고
					int idx = i;
					while(idx < memory1.length) {
						memory2[idx++] = memory1[i];
					}
					//cnt 증가
					cnt++;
				}
				//memory1과 memory2를 String으로 바꾸어 비교했을 때 같으면 반복문 종료
				if(memory1.toString().equals(memory2.toString())) 
					break;
			}
			
			//테스트케이스와 고친 횟수 출력
			System.out.printf("#%d %d\n", tc, cnt);
			
		}//tc
	}//main
}//class
