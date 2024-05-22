import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 메모장에 적은 키워드 개수
        int N = Integer.parseInt(st.nextToken());
        // 블로그에 쓴 글의 개수
        int M = Integer.parseInt(st.nextToken());

        // 키워드를 저장할 set
        Set<String> keywords = new HashSet<>();
        for(int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            // 블로그에 쓴 글과 관련된 키워드 ","를 기준으로 쪼개기
            String[] memo = br.readLine().split(",");
            // 확인하기 위해 memo에 적은 set 복사
            Set<String> check = keywords;

            // 블로그에 있으면 memo 에서 삭제
            for(int j = 0; j < memo.length; j++) {
                check.remove(memo[j]);
            }
            sb.append(check.size()).append("\n");
        }

        System.out.println(sb);
    }
}
