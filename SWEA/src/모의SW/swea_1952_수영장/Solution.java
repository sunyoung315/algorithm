package 모의SW.swea_1952_수영장;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] cost;
	static int[] plan;
	static int min;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/모의SW/swea_1952_수영장/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			cost = new int[4];
			for(int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			
			plan = new int[12];
			for(int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			
			//1년 이용권 가격을 최소값으로 설정
			min = cost[3];
			int money = 0;
			dfs(0, money);
			System.out.println("#" + tc + " " + min);
			
		}//tc
	}//main
	private static void dfs(int depth, int money) {
		//기저파트
		if(depth >= 12) {
			min = min > money ? money : min;
			return;
		}
		//재귀파트
		dfs(depth + 1, money + plan[depth] * cost[0]);
		dfs(depth + 1, money + cost[1]);
		dfs(depth + 3, money + cost[2]);
	}
}//Solution
