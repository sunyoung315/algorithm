package boj_17413_단어_뒤집기_2;

import java.util.Scanner;
import java.util.Stack;

public class Main_stack {
	public static Stack<String> stack = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//주어진 문자열 스캔
		String str = sc.nextLine();
		sc.close();
		String[] sentence = str.split("");
		
		String[] answer = new String[str.length()];
		
		int i = 0, idx = 0;
		//주어진 문자열 끝까지 갈 때까지 반복 while
		while(i < sentence.length) {
			//1. 괄호O
			//열린 괄호'<'가 나오면
			if(sentence[i].equals("<")) {
				//닫힌 괄호 '>'가 나올 때까지 sb에 추가
				do { 
					answer[idx++] = sentence[i++];
				}
				while(!sentence[i].equals(">"));
				//'>'까지 추가
				answer[idx++] = sentence[i++];
			
			//2. 괄호X
			}else {
				while(i < sentence.length && !sentence[i].equals(" ") && !sentence[i].equals("<")) {
					stack.push(sentence[i++]);					
				}
				
				while(!stack.isEmpty()) {
					answer[idx++] = stack.pop();
				}
				
				if(idx < answer.length && i < sentence.length && !sentence[i].equals("<")) {
					answer[idx++] = sentence[i++];
				}
			}
		}
		
		for(i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}
		
	}//main
}//class
