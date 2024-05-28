import java.io.*;
import java.util.*;

public class Main {
    static class Column {
        int x;
        int y;

        public Column(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Column{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 기둥의 개수
        int N = Integer.parseInt(br.readLine());

        List<Column> columnsList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 주어지는 기둥의 위치
            Column c = new Column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            columnsList.add(c);
        }

        // x좌표 순으로 오름차순 정렬
        columnsList.sort((a, b) -> a.x - b.x);

        // 높이가 가장 높은 기둥
        Column maxColumn = new Column(0, 0);
        // 가장 높은 기둥의 인덱스 번호
        int maxIdx = 0;
        for(int i = 0; i < N; i++) {
            if(maxColumn.y < columnsList.get(i).y) {
                maxColumn = columnsList.get(i);
                maxIdx = i;
            }
        }

        // 구할 최소면적을 가장 높은 기둥의 넓이로 초기화
        int square = maxColumn.y;
        Stack<Column> stack = new Stack<>();
        // 왼쪽부터 가장 높은 기둥까지의 면적
        Column cMax = columnsList.get(0);
        stack.push(columnsList.get(0));
        for(int i = 1; i < maxIdx; i++) {
            if(columnsList.get(i).y > cMax.y) {
                stack.push(columnsList.get(i));
                cMax = columnsList.get(i);
            }
        }

        cMax = maxColumn;
        while(!stack.isEmpty()) {
            Column cNow = stack.pop();
            square += (cMax.x - cNow.x) * cNow.y;
            cMax = cNow;
        }

        // 오른쪽부터 가장 높은 기둥까지의 면적
        cMax = columnsList.get(N-1);
        stack.push(columnsList.get(N-1));
        for(int i = N-1; i > maxIdx; i--) {
            if(columnsList.get(i).y > cMax.y) {
                stack.push(columnsList.get(i));
                cMax = columnsList.get(i);
            }
        }

        cMax = maxColumn;
        while(!stack.isEmpty()) {
            Column cNow = stack.pop();
            square += (cNow.x - cMax.x) * cNow.y;
            cMax = cNow;
        }

        System.out.println(square);
    }
}