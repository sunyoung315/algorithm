import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐는 힙으로 구현되어 있음
        // Comparator로 우선순위 지정 : 오름차순
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });

        // 우선순위 지정 "람다식"으로 구현
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int operator = Integer.parseInt(br.readLine());

            // 연산자(operator)가 0인데 queue가 비어있으면 0 출력
            if(operator == 0)
                if(!queue.isEmpty())
                    bw.write(queue.poll().toString() + "\n");
                else
                    bw.write("0\n");
            else
                queue.offer(operator);
        }

        bw.flush();
        bw.close();
    }
}
