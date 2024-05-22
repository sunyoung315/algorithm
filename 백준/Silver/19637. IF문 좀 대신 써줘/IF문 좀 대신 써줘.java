import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 칭호의 개수
        int N = Integer.parseInt(st.nextToken());
        // 캐릭터들의 개수
        int M = Integer.parseInt(st.nextToken());

        // 전투력 상한값과 칭호의 이름을 저장할 map
        Map<Integer, String> grades = new HashMap<>();
        // 전투력 상한값을 오름차순으로 정렬하기 위한 list
        List<Integer> arr = new ArrayList<>();
        // 동일한 상한값이 나오면, 첫번째 나온 값으로 저장
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            if(!grades.containsKey(power)) {
                grades.put(power, name);
                arr.add(power);
            }
        }

        // 상한값을 오름차순으로 정렬
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        // M개의 캐릭터의 전투력 입력
        for(int i = 0; i < M; i++) {
            int p = Integer.parseInt(br.readLine());
            // 이분탐색으로 해당 캐릭터의 칭호 찾기
            int left = 0;
            int right = arr.size() - 1;
            
            // 이분탐색
            // left와 right가 교차되면 반복문 종료
            while(left <= right) {
                // 중간 지점 
                int mid = (left + right) / 2;
                // 중간 지점의 값보다 전투력이 더 크면, 
                // 중간 지점 이후의 범위에 있으므로 left를 mid 다음 인덱스로 지정
                if(arr.get(mid) < p)
                    left = mid + 1;
                // 중간 지점의 값보다 전투력이 더 작으면
                // 중간 지점 이전의 범위에 있으므로 right를 mid 이전 인덱스로 지정
                else
                    right = mid - 1;
            }

            sb.append(grades.get(arr.get(left))).append("\n");
        }

        System.out.println(sb);

    }//main
}//Main
