import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        // 0의 개수
        int zeroCnt = 0;
        // 1의 개수
        int oneCnt = 0;

        // 0, 1의 개수 카운팅
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '0') zeroCnt++;
            else oneCnt++;
        }

        StringBuilder sb = new StringBuilder();

        // 0과 1 개수의 절반을 제거
        int zero = zeroCnt / 2;
        int one = oneCnt / 2;

        // 서브테스크 2에 '추가적인 제약 조건이 없다'는 말은 1이 홀수 번째, 0이 짝수 번째 문자가 아니라는 것
        // 사전 순으로 단순히 가장 빠른 것이 아니라
        // S'로 가능한 문자열 중 '사전순'으로 가장 앞에 있고, '가장 빠른 문자열'인 것
        // 이게 무슨 말일까? 
        // 재배열 하지 않고 해당 문자열 그대로에서 0과 1을 제거했을 때 나올 수 있는 것 중 가장 사전순으로 빠른 것!!
        for(int i = 0; i < S.length(); i++) {
            // 사전순으로 가장 빠르려면 앞에 최대한 0이 와야함
            // 0은 앞에서부터 카운팅 하면서 zero의 개수만큼 순서대로 출력
            if(S.charAt(i) == '0' && zero > 0) {
                sb.append('0');
                zero--;
            }

            // 1은 최대한 나중에 나와야 좋으므로
            // 제거할 1의 개수만큼 출력하지 않고, one이 0이 되는 순간부터 출력
            if(S.charAt(i) == '1' && one > 0) {
                one--;
            } else if(S.charAt(i) == '1' && one == 0) {
                sb.append('1');
            }
        }

        System.out.println(sb);
    }
}