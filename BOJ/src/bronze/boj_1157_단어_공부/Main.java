package bronze.boj_1157_단어_공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();

        // 알파벳 개수 26개 만큼 배열 생성
        int[] alphabetArr = new int[26];

        // 해당 알파벳의 대문자의 아스키코드값을 고려해서 몇번째 알파벳인지 계산하여 개수 카운팅
        for(int i = 0; i < arr.length; i++) {
            // 소문자일 경우
            if(arr[i] - 'A' > 25) {
                alphabetArr[arr[i] - 'A' - 32]++;
            // 대문자일 경우
            } else {
                alphabetArr[arr[i] - 'A']++;
            }
        }

        // 동일한 개수를 가진 알파벳이 있는지 확인하기 위한 flag
        boolean isSame = false;
        // 문자열에서 해당 알파벳의 개수를 넣기 위한 변수
        int max = 0;
        // 해당 알파펫이 몇번째 알파벳인지 확인하기 위한 인덱스
        int maxIdx = 0;
        for(int i = 0; i < alphabetArr.length; i++) {
            // 해당 알파벳이 문자열에 존재하지 않으므로 패스
            if(alphabetArr[i] == 0) continue;
            // 해당 알파벳의 개수가 최대 개수보다 클 경우,
            if(max < alphabetArr[i]) {
                // 알파벳 최대 개수 갱신
                max = alphabetArr[i];
                // 몇번째 알파벳인지 저장
                maxIdx = i;
                isSame = false;
            // 최대 개수와 동일한 개수를 가진 알파벳이면 flag를 true로
            } else if(max == alphabetArr[i]) isSame = true;
        }

        // 최대 개수가 동일한 알파펫이 있으면 "?" 출력
        if(isSame) System.out.println("?");
        // 최대 개수인 알파벳이 하나이면, 대문자를 기준으로 알파벳 계산
        else System.out.println((char) ('A' + maxIdx));

    }
}
