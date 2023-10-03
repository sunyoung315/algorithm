package d2.swea_1970_쉬운_거스름돈;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/d2/swea_1970_쉬운_거스름돈/input.txt"));
		Scanner sc = new Scanner(System.in);
		//테스트케이스의 개수
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//손님 에게 거슬러 주어야 할 금액
			int N = sc.nextInt();
			//돈의 종류와 사용 개수를 담을 2차원 배열 생성
			int[][] money = {{50000, 0}, {10000, 0}, {5000, 0}, {1000, 0},
					{500, 0}, {100, 0}, {50, 0}, {10, 0}};
			
			for(int i = 0; i < 8; i++) {
				//거슬러주어야 할 금액에서 큰 금액부터 차례로 나눈 몫을 해당 돈 사용 개수에 저장
				money[i][1] = N / money[i][0];
				//금액에서 지폐로 나눈 나머지가 해당 지폐를 사용하고 남은 금액
				//N을 나머지 금액으로 갱신
				N %= money[i][0];
			}
		
			System.out.println("#" + tc);
			for(int i = 0; i < 8; i++) {
				System.out.print(money[i][1] + " ");
			}
			System.out.println();
			
		}//tc
	}//main
}//class
