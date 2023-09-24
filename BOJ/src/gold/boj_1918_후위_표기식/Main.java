package gold.boj_1918_후위_표기식;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Stack<Character> operator = new Stack<>();
	public static Map<Character, Integer> priority = new HashMap<>();
	static {
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inFix = sc.next();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < inFix.length(); i++) {
			if(inFix.charAt(i) != '*' && inFix.charAt(i) != '/'
					&& inFix.charAt(i) != '+' && inFix.charAt(i) != '-'
					&& inFix.charAt(i) != '(' && inFix.charAt(i) != ')') {
				sb.append(inFix.charAt(i));
			}else if(inFix.charAt(i) == '(') {
				operator.push(inFix.charAt(i));
			}else if(inFix.charAt(i) == ')') {
				while(operator.peek() != '(') {
					sb.append(operator.pop());
				}
				operator.pop();
				
			}else if(!(operator.isEmpty()) && priority.get(inFix.charAt(i)) > priority.get(operator.peek())) {
				operator.push(inFix.charAt(i));
				
			}else {
				while(!(operator.isEmpty()) && priority.get(inFix.charAt(i)) <= priority.get(operator.peek())) {
					sb.append(operator.pop());
				}
				operator.push(inFix.charAt(i));	
			
			}//if operator 
		}//i
		
		while(!operator.isEmpty()) {
			sb.append(operator.pop());
		}
		
		System.out.println(sb);
		
	}//main
}//class
