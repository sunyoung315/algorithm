import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기에 편집기에 입력되어 있는 문자열(str의 길이: N)
        String str = br.readLine();
        Stack<String> string = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            string.push(String.valueOf(str.charAt(i)));
        }

        // 입력할 명령어의 개수
        int M = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 명령어 입력
            String method = st.nextToken();
            // 명령어가 L이면, 커서를 왼쪽으로 한 칸 옮김
            if(method.equals("L") && !string.isEmpty())
                stack.push(string.pop());
            // 명령어가 D이면, 커서를 오른쪽으로 한 칸 옯김
            else if(method.equals("D") && !stack.isEmpty())
                string.push(stack.pop());
            // 명령어가 B이면 왼쪽 문자 삭제
            else if(method.equals("B") && !string.isEmpty()) {
                string.pop();
            }
            // 명령어가 P이면 왼쪽에 문자열 삽입
            else if(method.equals("P")) {
                // 추가될 문자열
                String alphabet = st.nextToken();
                string.push(alphabet);
            }
        }//for M

        while(!string.isEmpty()) {
            stack.push(string.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
