import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어의 개수
        int N = Integer.parseInt(br.readLine());
        // 비교할 첫번째 단어
        char[] word1 = br.readLine().toCharArray();

        // 유사한 단어의 개수
        int similar = 0;

        for(int i = 1; i <= N-1; i++) {
            // word1과 비교할 단어
            char[] word2 = br.readLine().toCharArray();

            // 1. word1과 길이가 동일한 경우
            if(word1.length == word2.length) {
                // 동일 문자 개수 확인
                int same = check(word1, word2);
                
                // 동일 문자 개수가 word1의 문자 개수와 동일하거나 1개 적을 때 유사한 문자 
                if(same == word1.length || same == word1.length - 1) similar++;
            }
            // 2. word1보다 길이가 1 적은 경우
            if(word1.length - 1 == word2.length) {
                // 동일 문자 개수 확인
                int same = check(word1, word2);

                // 동일 문자 개수가 word1의 문자 개수보다 1개 적을 때 유사한 문자 
                if(same == word1.length - 1) similar++;
            }
            // 3. word1보다 길이가 1 큰 경우
            if(word1.length + 1 == word2.length) {
                // 동일 문자 개수 확인
                int same = check(word1, word2);

                // 동일 문자 개수가 word1의 문자 개수와 동일할 때 유사한 문자 
                if(same == word1.length) similar++;
            }
        }

        // 유사한 문자 개수 출력
        System.out.println(similar);
    }//main
    
    static int check(char[] word1, char[] word2) {
        // 동일한 문자 개수
        int same = 0; 
        out: for(int j = 0; j < word1.length; j++) {
            for(int k = 0; k < word2.length; k++) {
                // word1과 word2의 문자가 동일하면 카운트
                if(word1[j] == word2[k]) {
                    same++;
                    // 중복 카운트를 방지하기 위해 확인된 문자는 소문자로 변경
                    word2[k] += 32;
                    continue out;
                }
            }
        }
        return same;
    }
}//Main
