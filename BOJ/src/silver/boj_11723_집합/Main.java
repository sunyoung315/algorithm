package silver.boj_11723_집합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            if(operator.equals("all"))
                answer = (1 << 21) - 1;
            else if(operator.equals("empty"))
                answer = 0;
            else {
                int num = Integer.parseInt(st.nextToken());
                if(operator.equals("add"))
                    answer |= (1 << num);
                else if(operator.equals("remove"))
                    answer &= ~(1 << num);
                else if(operator.equals("check"))
//                    sb.append((answer & (1 << num)) == 0 ? "0\n" : "1\n");
                    bw.write((answer & (1 << num)) == 0 ? "0\n" : "1\n");
                else if(operator.equals("toggle")) {
                    answer ^= (1 << num);
                }
            }
        }
        bw.close();
    }
}
