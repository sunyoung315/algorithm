import java.io.*;
import java.util.*;

public class Main {
    static class Player {
        int level;
        String id;

        public Player(int level, String id) {
            this.level = level;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "level=" + level +
                    ", id='" + id + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 플레이어의 수
        int p = Integer.parseInt(st.nextToken());
        // 방의 정원
        int m = Integer.parseInt(st.nextToken());
        // 생성될 방의 개수
        int roomCnt = p % m == 0 ? p / m : (p / m) + 1;

        // key: 방 번호, value: 방에 들어간 플레이어
        Map<Integer, List<Player>> room = new HashMap<>();
        for(int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            // 현재 플레이어의 레벨
            int level = Integer.parseInt(st.nextToken());
            // 현재 플레이어의 닉네임
            String id = st.nextToken();

            // 방의 최대 개수 300
            for(int j = 0; j < 300; j++) {
                // 1. 아직 생성되지 않은 방이면, 최소 최대값을 현재 level로 갱신
                if(!room.containsKey(j)) {
                    room.put(j, new ArrayList<>());
                    room.get(j).add(new Player(level, id));
                    break;
                }
                // 2. 이미 생성된 방이면
                else {
                    // 1) 이미 정원이 다 찬 방이면 다음 방으로
                    if(room.get(j).size() == m)
                        continue;
                    // 2) 생성된 방이지만, 아직 정원이 다 차지 않은 방이면,
                    else {
                        List<Player> nowRoom = room.get(j);
                        // ① 처음 입장한 플레이어의 레벨기준으로 -10 ~ +10 을 넘으면 다음 방으로
                        if((level < (nowRoom.get(0).level - 10) || level > (nowRoom.get(0).level + 10)))
                            continue;
                        // ② 범위 안에 들어오면 방에 들어가기
                        else {
                            nowRoom.add(new Player(level, id));
                            break;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < room.size(); i++) {
            List<Player> nowRoom = room.get(i);
            // * 방에 있는 플레이어의 정보는 닉네임 순으로 앞서는 플레이어부터 출력
            Collections.sort(nowRoom, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.id.compareTo(o2.id);
                }
            });

            // 현재 방이 정원이 다 찼는지 확인
            if(nowRoom.size() == m)
                bw.write("Started!\n");
            else
                bw.write("Waiting!\n");

            for(int j = 0; j < nowRoom.size(); j++) {
                bw.write(String.valueOf(nowRoom.get(j).level) + " " + nowRoom.get(j).id + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
