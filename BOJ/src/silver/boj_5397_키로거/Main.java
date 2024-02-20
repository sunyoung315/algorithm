package silver.boj_5397_키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());

        // 정답
        StringBuilder answer = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            // 비밀번호 변수
            Stack<String> password = new Stack<>();
            // 임시 변수
            Stack<String> temp = new Stack<>();

            String[] str = br.readLine().split("");

            for(int i = 0; i < str.length; i++) {
                if(password.isEmpty()) {
                    if (str[i].equals("<") || str[i].equals(">") || str[i].equals("-")) {
                        if(temp.isEmpty()) {
                            continue;
                        } else {
                            if(str[i].equals(">")) {
                                password.add(temp.pop());
                            }
                        }
                    } else {
                        password.add(str[i]);
                    }
                } else {
                    if (str[i].equals("<")) {
                        temp.add(password.pop());
                    } else if(str[i].equals(">") && !temp.isEmpty()) {
                        password.add(temp.pop());
                    } else if(str[i].equals(">") && temp.isEmpty()) {
                        continue;
                    } else if(str[i].equals("-")) {
                        password.pop();
                    } else {
                        password.add(str[i]);
                    }
                }
            } // i

            while(!temp.isEmpty()) {
                password.add(temp.pop());
            }

            for(int i = 0; i < password.size(); i++) {
                answer.append(password.get(i));
            }
            answer.append("\n");

        } //tc
        System.out.println(answer);
    }
}
