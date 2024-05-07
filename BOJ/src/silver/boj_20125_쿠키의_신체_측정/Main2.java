package silver.boj_20125_쿠키의_신체_측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정사각형 판의 한 변의 길이
        int N = Integer.parseInt(br.readLine());
        // N*N의 보드판
        String[][] board = new String[N+1][N+1];

        StringBuilder sb = new StringBuilder();

        // 심장의 좌표 x, y
        int heartX = 0;
        int heartY = 0;
        // 입력
        for(int i = 1; i <= N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 1; j <= N; j++) {
                // 1. 심장 찾기 -> 머리 위치가 (x,y)라면 (x,y+1)이 된다.
                // 위에서부터 오른쪽으로 차례로 순회했을 때 처음 나오는 "*"이 머리의 위치
                if(str[j-1].equals("*") && heartX == 0 && heartY == 0 ) {
                    heartX = i + 1;
                    heartY = j;
                    sb.append(heartX).append(" ").append(heartY).append("\n");
                }
                board[i][j] = str[j-1];
            }//for j
        }//for i

        int length = 0;
        // 2. 왼쪽 팔 길이
        for(int i = heartY-1; i >= 1; i--) {
            if(board[heartX][i].equals("*")) {
                ++length;
                if(i == 1) {
                    sb.append(length).append(" ");
                    length = 0;
                }
            }
            else {
                sb.append(length).append(" ");
                length = 0;
                break;
            }
        }

        // 3. 오른쪽 팔 길이
        for(int i = heartY+1; i <= N; i++) {
            if(board[heartX][i].equals("*")) {
                ++length;
                if(i == N) {
                    sb.append(length).append(" ");
                    length = 0;
                }
            }
            else {
                sb.append(length).append(" ");
                length = 0;
                break;
            }
        }

        // 다리가 시작되는 X 좌표
        int legX = 0;

        // 4. 허리 길이
        for(int i = heartX+1; i <= N; i++) {
            if(board[i][heartY].equals("*")) {
                ++length;
                if(i == N) {
                    sb.append(length).append(" ");
                    length = 0;
                }
            }
            else {
                sb.append(length).append(" ");
                length = 0;
                legX = i;
                break;
            }
        }

        // 5. 왼쪽 다리 길이
        for(int i = legX; i <= N; i++) {
            if(board[i][heartY-1].equals("*")) {
                ++length;
                if(i == N) {
                    sb.append(length).append(" ");
                    length = 0;
                }
            }
            else {
                sb.append(length).append(" ");
                length = 0;
                break;
            }
        }

        // 6. 오른쪽 다리 길이
        for(int i = legX; i <= N; i++) {
            if(board[i][heartY+1].equals("*")) {
                ++length;
                if(i == N) {
                    sb.append(length);
                }
            }
            else {
                sb.append(length);
                break;
            }
        }

        System.out.println(sb);
    }//main
}//Main
