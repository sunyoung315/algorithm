package silver.boj_5014_스타트링크;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//F층의 고층건물
		int F = sc.nextInt();
		
		//건물 층수만큼의 배열 생성
		int[] building = new int[F+1];
		
		//강호의 현재 위치
		int S = sc.nextInt();
		//스타트링크의 위치
		int G = sc.nextInt();
		
		int[] btn = new int[2];
		//위로 가는 버튼
		btn[0] = sc.nextInt();
		//아래로 가는 버튼
		btn[1] = sc.nextInt() * -1;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(S);
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == G) {
				System.out.println(building[G]);
				break;
			}
			
			for(int i = 0; i < 2; i++) {
				int nextF = curr + btn[i];
				if(nextF > 0 && nextF <= F && building[nextF] == 0 && btn[i] != 0) {
					building[nextF] = building[curr] + 1;
					q.add(nextF);
				}
			}
		}

		if(S != G && building[G] == 0)
			System.out.println("use the stairs");
		
	}//main
}//class
