package silver.boj_2839_설탕_배달;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//스캐너를 닫자..
		sc.close();
		
		//1. 5의 배수일 경우 5kg짜리로 모두 가져가기
		if(N % 5 == 0) {
			System.out.println(N / 5);
		//2. 5로 나누었을 때 나머지가 3이면 몫만큼 5kg짜리를 가져가고 3kg짜리 1개
		}else if(N % 5 == 3) {
			System.out.println((N / 5) + 1);
		//3. 5로 나누었을 때 나머지가 1이면 몫-1만큼 5kg짜리를 가져가면 3kg짜리 2개
		}else if(N % 5 == 1 && N / 5 >= 1) {
			System.out.println(((N / 5) - 1) + 2);
		//4. 5로 나누었을 때 나머지가 4이면 몫-1만큼 5kg짜리를 가져가면 3kg짜리 3개
		}else if(N % 5 == 4 && N / 5 >= 1) {
			System.out.println(((N / 5) - 1) + 3);
		//5. 5로 나누었을 때 나머지가 2이면 몫-2만큼 5kg짜리를 가져가면 3kg짜리 4개
		}else if(N % 5 == 2 && N / 5 >= 2){
			System.out.println(((N / 5) - 2) + 4);
		//6. 이 외에는 5kg, 3kg짜리로 들고가기 불가능
		}else {
			System.out.println("-1");
		}
		
	}//main
}
