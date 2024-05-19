import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 팀의 개수
            int n = Integer.parseInt(st.nextToken());
            // 문제의 개수
            int k = Integer.parseInt(st.nextToken());
            // 팀의 ID
            int t = Integer.parseInt(st.nextToken());
            // 로그 엔트리의 개수
            int m = Integer.parseInt(st.nextToken());

            // 팀별 제출 횟수 저장할 map
            Map<Integer, Integer> submitCnt = new HashMap<>();
            // 팀별 마지막 제출한 순서 번호 저장할 map
            Map<Integer, Integer> submitTime = new HashMap<>();
            // 각 팀의 문제별 점수를 저장할 3차원 배열
            int[][] scoreList = new int[n+1][k+1];
            // 로그 엔트리 개수만큼 반복
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                // 더 큰 점수가 나오면 갱신
                if(scoreList[teamId][problemNum] < score) {
                    scoreList[teamId][problemNum] = score;
                }

                // 제출 횟수 증가
                if(submitCnt.containsKey(teamId)) submitCnt.put(teamId, submitCnt.get(teamId) + 1);
                else submitCnt.put(teamId, 1);

                // 마지막 제출 번호 저장
                submitTime.put(teamId, i);
            }//for m

            // 각 팀별 총 점수를 저장할 배열
            int[] arr = new int[n+1];
            // 각 팀별 점수 합 계산
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < k+1; j++) {
                    arr[i] += scoreList[i][j];
                }
            }

            // 내 팀의 총 스코어
            int myTeamScore = arr[t];
            // 내 팀보다 앞의 등수인 팀의 수
            int cnt = 0;
            
            for(int i = 1; i < n+1; i++) {
                // 내 팀의 점수는 스킵
                if(i != t) {
                    // 내 팀의 점수보다 높으면 카운트
                    if(arr[i] > myTeamScore) cnt++;
                    // 동점이지만
                    else if(arr[i] == myTeamScore) {
                        // 제출횟수가 적으면 카운트
                        if(submitCnt.get(i) < submitCnt.get(t)) cnt++;
                        // 제출횟수도 동일하면
                        else if(submitCnt.get(i).equals(submitCnt.get(t))) {
                            // 마지막 제출이 내 팀보다 빠르면 카운트
                            if(submitTime.get(i) < submitTime.get(t))  {
                                cnt++;
                            }
                        }
                    }
                }
            }

            System.out.println(cnt+1);

        }//for tc
    }//main
}//Main
