package silver.boj_9655_돌_게임;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int games = (N / 3) + (N % 3);

        if(games % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}
