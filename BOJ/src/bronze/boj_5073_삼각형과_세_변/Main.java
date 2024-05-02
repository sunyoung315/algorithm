package bronze.boj_5073_삼각형과_세_변;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 0, 0, 0일 경우 계산하지 않고 반복문 종료
            if(a == 0 && b == 0 && c == 0) break;

            // 삼각형의 조건을 만족하지 못 하는 경우를 가장 먼저 판별해야 함!!
            if((a + b) <= c || (b + c) <= a || (c + a) <= b) System.out.println("Invalid");
            // 세 변의 길이가 같은 경우
            else if(a == b && b == c) System.out.println("Equilateral");
            // 두 변의 길이가 같은 경우
            else if(a == b || b == c || c == a) System.out.println("Isosceles");
            // 세 변의 길이가 모두 다른 경우
            else System.out.println("Scalene");
        }
    }
}
