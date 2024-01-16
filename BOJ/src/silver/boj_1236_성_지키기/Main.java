package silver.boj_1236_성_지키기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[][] castle = new String[N][M];
        for(int i = 0; i < N; i++) {
            String[] str = sc.next().split("");
            for(int j = 0; j < M; j++) {
                castle[i][j] = str[j];
            } // for j
        } // for i

        List<Integer> columnGuide = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(castle[i][j].equals("X") && !columnGuide.contains(j)) {
                    columnGuide.add(j);
                }
            } // for j
        } // for i

//        System.out.println(columnGuide);

        List<Integer> rowGuide = new ArrayList<>();
        for(int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {
                if(castle[i][j].equals("X") && !rowGuide.contains(i)) {
                    rowGuide.add(i);
                }
            } // for i
        } // for j

//        System.out.println(rowGuide);

        System.out.println(Math.max((N - rowGuide.size()),(M - columnGuide.size())));
    } // main
} // Main
