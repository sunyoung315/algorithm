import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        String star = "*";
        
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < b; r++) {
            sb.append(star.repeat(a)).append("\n");
        }

        System.out.println(sb);
    }
}