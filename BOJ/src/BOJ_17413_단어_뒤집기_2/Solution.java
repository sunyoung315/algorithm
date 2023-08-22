package BOJ_17413_단어_뒤집기_2;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//주어진 문자열 스캔
		String str = sc.nextLine();
		sc.close();
		
		//최종 문자열을 만들기 위한 StringBuilder sb 생성
		StringBuilder sb = new StringBuilder();
		//특정 문자열을 뒤집기 위한 StringBuilder rev 생성
		StringBuilder rev = new StringBuilder();
		
		int i = 0;
		//주어진 문자열 끝까지 갈 때까지 반복 while
		while(i < str.length()) {
			//1. 괄호O
			//열린 괄호'<'가 나오면
			if(str.charAt(i) == '<') {
				//rev가 있으면 sb에 rev를 뒤집어서 추가한 후,
				if(rev != null) {
					sb.append(rev.reverse());
				}
				//닫힌 괄호 '>'가 나올 때까지 sb에 추가
				do { 
					sb.append(str.charAt(i++));
				}
				while(str.charAt(i) != '>');
				//'>'까지 추가
				sb.append(str.charAt(i++));
			
			//2. 괄호X
			}else {
				rev.append(str.charAt(i++));					
			}
		}
		System.out.println(sb);
		
	}//main
}//class
