package silver.boj_1935_후위_표기식2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Stack<Double> operand = new Stack<>();
	public static Map<String, Integer> priority = new HashMap<>();
	static {
		priority.put("*", 2);
		priority.put("/", 2);
		priority.put("+", 1);
		priority.put("-", 1);
		priority.put("(", 0);
	}
	public static Map<String, Double> number = new HashMap<>();
	public static double num1, num2, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String[] postFix = str.split("");
		
		for(int i = 0; i < postFix.length; i++) {
			if(!(postFix[i].equals("*")) && !(postFix[i].equals("/"))
					&& !(postFix[i].equals("+")) && !(postFix[i].equals("-")) && !number.containsKey(postFix[i])) {
				number.put(postFix[i], sc.nextDouble());
			}
		}
		sc.close();
		
		for(int i = 0; i < postFix.length; i++) {
			if(!(postFix[i].equals("*")) && !(postFix[i].equals("/"))
					&& !(postFix[i].equals("+")) && !(postFix[i].equals("-"))) {
				operand.push(number.get(postFix[i]));
			}else {
				num2 = operand.pop();
				num1 = operand.pop();
				if(postFix[i].equals("*")) {
					answer = num1 * num2;
				}else if(postFix[i].equals("/")) {
					answer = num1 / num2;
				}else if(postFix[i].equals("+")) {
					answer = num1 + num2;
				}else if(postFix[i].equals("-")) {
					answer = num1 - num2;
				}
				operand.push(answer);
			}
		}
		
		System.out.printf("%.2f", answer);
		
	}//main
	
}//class
