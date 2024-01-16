package silver.boj_2667_단지번호붙이기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지도의 크기
        int N = sc.nextInt();

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] strs = sc.next().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }

//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }



    } //main
}// Mian
