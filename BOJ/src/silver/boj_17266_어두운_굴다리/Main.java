package silver.boj_17266_어두운_굴다리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 굴다리의 길이 N
        int N = Integer.parseInt(br.readLine());
        // 가로등의 개수 M
        int M = Integer.parseInt(br.readLine());

        // 가로등 위치를 입력받을 배열
        int[] road = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로등 위치 입력
        for(int i = 0; i < M; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 가로등과 시작위치, 마지막 가로등과 끝위치 차이 만큼은 1개의 가로등으로 비춰야하므로 최소 이 길이 이상이어야 함
        int height = road[0];
        if(height < N - road[M-1]) height = N - road[M-1];

        // 가로등 사이의 거리가 현재 설정해놓은 가로등 높이 2개의 가로등이 최대로 비출수 있는 면적보다 크면
        // 그 면적(gap-2*height)를 2로 나눠서 각 가로등의 높이를 높이고 홀수이면 1을 더 더해서 가로등 최소 높이 구하기
        for(int i = 1; i < M; i++) {
            int gap = road[i] - road[i-1];
            if(gap > 2 * height) height += (gap - 2 * height) / 2 + (gap - 2 * height) % 2;
        }

        System.out.println(height);

    }
}
