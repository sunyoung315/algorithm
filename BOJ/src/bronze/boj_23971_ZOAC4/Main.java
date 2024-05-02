package bronze.boj_23971_ZOAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테이블 행 수
        int H = Integer.parseInt(st.nextToken());
        // 테이블 열 수
        int W = Integer.parseInt(st.nextToken());
        // 비워야 하는 세로 칸 수
        int N = Integer.parseInt(st.nextToken());
        // 비워야 하는 가로 칸 수
        int M = Integer.parseInt(st.nextToken());

        // (비워야 하는 칸 수(N,M) + 참가자가 앉는 칸 수(1))에 1명이 앉을 수 있음
        // 이 값으로 나눈 나머지가 있을 경우에도 1명이 더 앉을 수 있음(+1)
        int rowNum = H % (N + 1) > 0 ? (H / (N + 1)) + 1 : H / (N + 1);
        int colNum = W % (M + 1) > 0 ? (W / (M + 1)) + 1 : W / (M + 1);

        int totalNum = rowNum * colNum;

        System.out.println(totalNum);
    }
}
