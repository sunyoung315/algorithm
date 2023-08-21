package BOJ_10814_나이순_정렬;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[][] member = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				member[i][j] = sc.next();
			}
		}
		sc.close();
	    
		String[][] result = new String[N][2];
		
		int[] count = new int[201];
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(member[i][0])]++;
		}
		
		for(int i = 1; i < 201; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = N-1; i >= 0; i--) {
			int idx = Integer.parseInt(member[i][0]);
			count[idx]--;
			result[count[idx]][0] = member[i][0];
			result[count[idx]][1] = member[i][1];
		}
		
		for(int i = 0; i < N; i++) {
			System.out.printf("%s %s\n", result[i][0], result[i][1]);
		}
	}
}
