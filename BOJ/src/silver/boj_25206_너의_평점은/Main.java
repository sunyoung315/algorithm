package silver.boj_25206_너의_평점은;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static Map<String, Double> grade = new HashMap<>();
	static {
		grade.put("A+", 4.5);
		grade.put("A0", 4.0);
		grade.put("B+", 3.5);
		grade.put("B0", 3.0);
		grade.put("C+", 2.5);
		grade.put("C0", 2.0);
		grade.put("D+", 1.5);
		grade.put("D0", 1.0);
		grade.put("F", 0.0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double totalScore = 0;
		
		int test = 20;
		int totalCredit = 0;
		for(int i = 1; i <= 20; i++) {

			String subject = sc.next();
			
			double credit = sc.nextDouble();
			
			String g = sc.next();
			double score = 0;;
			if(g.equals("P")) {
				test--;
			}else {
				score = grade.get(g);				
				totalCredit += credit;
			}
			
			
			totalScore += credit * score;
		}
		
		double avg = totalScore / totalCredit;
		System.out.printf("%6f", avg);
		
	}//main
}//class
