package silver.boj_20125_쿠키의_신체_측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정사각형 판의 한 변의 길이
        int N = Integer.parseInt(br.readLine());
        // N*N의 보드판
        // String보다 char가 메모리적으로나 시간으로나 훨씬 좋다!!!
        char[][] board = new char[N+1][N+1];

        StringBuilder sb = new StringBuilder();

        // 심장의 좌표 x, y
        int heartX = 0;
        int heartY = 0;
        // 입력
        for(int i = 1; i <= N; i++) {
            char[] str = br.readLine().toCharArray();
            for(int j = 1; j <= N; j++) {
                // 심장 찾기 -> 머리 위치가 (x,y)라면 (x,y+1)이 된다.
                // 위에서부터 오른쪽으로 차례로 순회했을 때 처음 나오는 "*"이 머리의 위치
                if(str[j-1] == '*' && heartX == 0 && heartY == 0 ) {
                    heartX = i + 1;
                    heartY = j;
                    sb.append(heartX).append(" ").append(heartY).append("\n");
                }
                board[i][j] = str[j-1];
            }//for j
        }//for i

        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == heartX) {
                    // 1. 왼쪽 팔의 길이
                    if(board[i][j] == '*' && j < heartY) leftArm++;
                    // 2. 오른쪽 팔의 길이
                    else if(board[i][j] == '*' && j > heartY) rightArm++;
                } else if (j == heartY) {
                    // 3. 허리의 길이
                    if(board[i][j] == '*' && i > heartX) waist++;
                } else if(j == heartY-1) {
                    // 4. 왼쪽 다리의 길이
                    if(board[i][j] == '*' && i > heartX) leftLeg++;
                } else if(j == heartY+1) {
                    // 5. 오른쪽 다리의 길이
                    if(board[i][j] == '*' && i > heartX) rightLeg++;
                }
            }
        }
        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);

        System.out.println(sb);

    }//main
}//Main
