package silver.boj_1515_수_이어_쓰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_failed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] number = br.readLine().split("");

        int ans = Integer.parseInt(number[0]);
        for(int i = 1; i < number.length; i++) {
            int num = Integer.parseInt(number[i]);
            System.out.println("num: " + num);
            if(ans % 10 < num) {
                ans = (ans / 10) * 10 + num;
                System.out.println(ans);
            }
            else {
                if (ans / 10 != 0 && ans / 10 == num && ans % 10 < 9) {
                    ans = (ans / 10) * 10 + (ans % 10 + 1);
                    System.out.println(ans);
                } else if ((ans / 10 + 1) == num && ans % 10 == 9) {
                    ans = (ans / 10 + 1) * 10;
                    System.out.println(ans);
                } else {
                    ans = (ans / 10 + 1) * 10 + num;
                    System.out.println(ans);
                }
            }
        }
        System.out.println(ans);

    }
}
