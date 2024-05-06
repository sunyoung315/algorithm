package silver.boj_25757_임스와_함께하는_미니게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 임스와 같이 플레이하기를 신청한 횟수
        int N = Integer.parseInt(st.nextToken());
        // 플레이할 게임의 종류(윷놀이Y, 같은 그림 찾기F, 원카드O)
        String game = st.nextToken();
        int playerCnt;
        if(game.equals("Y")) playerCnt = 1;
        else if(game.equals("F")) playerCnt = 2;
        else playerCnt = 3;

        HashSet<String> people = new HashSet<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            people.add(name);
        }//for N

        System.out.println(people.size() / playerCnt);
    }//main
}//Main
