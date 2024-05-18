import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지우고 남은 수 한 줄로 이어 붙인 수
        char[] num = sc.next().toCharArray();
        // num을 하나씩 확인하기 위한 index
        int numIdx = 0;

        // 마지막 N을 구하기 위해서 1부터 차례로 확인할 변수
        int N = 1;

        // num을 마지막까지 확인할 때까지 반복
        while(numIdx < num.length) {
            // N을 문자열로 변환
            String ans = Integer.toString(N);

            // N의 각 자리수가 num에 남아있는지 확인
            for(int i = 0; i < ans.length(); i++) {
                if(ans.charAt(i) == num[numIdx]) {
                    numIdx++;
                }
                // num의 끝까지 확인됐으면 종료
                if(numIdx >= num.length) break;
            }

            // N을 다 확인했으면 1 증가시키기
            N++;
        }

        // 최소 N 출력
        System.out.println(N - 1);

    }//main
}//Main
