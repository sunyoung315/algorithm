package silver.boj_9017_크로스_컨트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_failed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스 개수
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            // 참가한 선수들의 총 인원
            int N = Integer.parseInt(br.readLine());
            // 팀과 점수를 입력할 2차원 배열
            int[][] rank = new int[N][2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // key: 팀 번호, value: 팀원 수
            HashMap<Integer, Integer> teamCnt = new HashMap<>();
            for(int i = 0; i < N; i++) {
                rank[i][0] = Integer.parseInt(st.nextToken());
                if(teamCnt.containsKey(rank[i][0])) {
                    int cnt = teamCnt.get(rank[i][0]);
                    teamCnt.put(rank[i][0], cnt+1);
                } else {
                    teamCnt.put(rank[i][0], 1);
                }
            }

            int score = 1;
            // 점수 계산 (6명인 팀만 점수를 부여받음)
            for(int i = 0; i < N; i++) {
                if(teamCnt.get(rank[i][0]) == 6) {
                    rank[i][1] = score++;
                }
            }

            HashMap<Integer, Integer> totalScore = new HashMap<>();
            // 팀 번호, 몇번째 선수까지 누적합을 구했는지
            HashMap<Integer, Integer> totalCnt = new HashMap<>();
            // 5번째 선수가 가장 먼저 나온 팀
            List<Integer>fifthScore = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                if(rank[i][1] != 0) {
                    if(totalScore.containsKey(rank[i][0]) && totalCnt.get(rank[i][0]) < 4) {
                        int total = totalScore.get(rank[i][0]) + rank[i][1];
                        totalScore.put(rank[i][0], total);
                        totalCnt.put(rank[i][0], totalCnt.get(rank[i][0]) + 1);
                    } else if(!totalScore.containsKey(rank[i][0])) {
                        totalScore.put(rank[i][0], rank[i][1]);
                        totalCnt.put(rank[i][0], 1);
                    } else if(totalScore.containsKey(rank[i][0]) && totalCnt.get(rank[i][0]) == 4) {
                        fifthScore.add(rank[i][0]);
                        totalCnt.put(rank[i][0], totalCnt.get(rank[i][0]) + 1);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            int minTeam = 0;
            List<Integer> sameTeam = new ArrayList<>();
            for(int key: totalScore.keySet()) {
                if(totalScore.get(key) < min) {
                    min = totalScore.get(key);
                    minTeam = key;
                    sameTeam.clear();
                }
                if(totalScore.get(key) == min) {
                    sameTeam.add(key);
                }
            }
            System.out.println(sameTeam);

            if(sameTeam.size() > 1) {
                out: for(int j = 0; j < fifthScore.size(); j++) {
                    for(int i = 0; i < sameTeam.size(); i++) {
                        if(fifthScore.get(j) == sameTeam.get(i)) {
                            System.out.println(fifthScore.get(j));
                            break out;
                        }
                    }
                }
            } else {
                System.out.println(minTeam);
            }
        }//tc
    }//main
}//Main
