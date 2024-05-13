package silver.boj_9017_크로스_컨트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            // 참가한 선수의 수
            int N = Integer.parseInt(br.readLine());
            // 팀 번호 입력
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 팀 번호 입력받을 리스트
            int[] race = new int[N];
            // 팀 번호와 팀원 수를 입력받을 맵
            Map<Integer, Integer> teams = new HashMap<>();
            for(int i = 0; i < N; i++) {
                int nowTeam = Integer.parseInt(st.nextToken());
                race[i] = nowTeam;
                if(!teams.containsKey(nowTeam)) teams.put(nowTeam, 1);
                else {
                    int num = teams.get(nowTeam);
                    teams.put(nowTeam, num + 1);
                }
            }
//            System.out.println(teams);

            int rank = 1;
            // 등수 계산 배열
            int[] rankList = new int[N];
            // teamInfo에 들어갈 행 번호
            int rowNum = 0;
            // [팀번호, 누적점수 최종 등수, 총점, 5번째 선수 점수]를 갖는 2차원 배열
            int[][] teamInfo = new int[teams.size()][4];

            for(int i = 0; i < N; i++) {
                // 현재 팀 번호
                int teamNum = race[i];
                // 6명이 안되는 팀은 점수 없음
                if(teams.get(teamNum) != 6) rankList[i] = 0;
                // 6명 이상이면 점수 부여
                else {
                    rankList[i] = rank++;
//                    System.out.println("now rank: " + rankList[i]);
                    for(int j = 0; j < teams.size(); j++){
                        // teamInfo에 팀 정보가 있으면,
                        if(teamInfo[j][0] == teamNum) {
//                            System.out.println("O teamNum: " + teamNum);
                            // 현재 팀원의 등수
                            teamInfo[j][1] += 1;
                            // 4등 이내이면 총점에 누적
                            if(teamInfo[j][1] <= 4) {
                                teamInfo[j][2] += rankList[i];
                            }
                            // 5등이면 5번째 점수 저장
                            else if(teamInfo[j][1] == 5) teamInfo[j][3] = rankList[i];
                            break;
                        } else if(teamInfo[j][0] == 0) {
                        // teamInfo에 팀 정보가 없으면
//                            System.out.println("X teamNum: " + teamNum);
                            teamInfo[rowNum][0] = teamNum;
                            teamInfo[rowNum][1] = 1;
                            teamInfo[rowNum][2] = rankList[i];
//                            System.out.println(Arrays.toString(teamInfo[rowNum]));
                            rowNum++;
                            break;
                        }
                    }
                }
            }

//            for(int i = 0; i < teamInfo.length; i++) {
//                System.out.println(Arrays.toString(teamInfo[i]));
//            }

            int minScore = Integer.MAX_VALUE;
            int minTeam = 0;
            int fifthScore = N;

            for(int i = 0; i < teamInfo.length; i++) {
                if(teamInfo[i][0] == 0) break;

                if(teamInfo[i][2] < minScore) {
                    minTeam = teamInfo[i][0];
                    minScore = teamInfo[i][2];
                    fifthScore = teamInfo[i][3];
                } else if (teamInfo[i][2] == minScore) {
                    if(fifthScore > teamInfo[i][3]) {
                        minTeam = teamInfo[i][0];
                        fifthScore = teamInfo[i][3];
                    }
                }
            }

            System.out.println(minTeam);;
        }
    }
}
