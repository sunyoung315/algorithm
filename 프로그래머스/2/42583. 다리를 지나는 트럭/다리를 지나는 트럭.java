import java.util.*;
import java.util.stream.Collectors;

class Solution {
//     class Truck {
//         // 다리 위에서 이동한 거리
//         int d;
//         // 트럭의 무게
//         int w;
        
//         public Truck(int d, int w) {
//             this.d = d;
//             this.w = w;
//         }
        
//         public String toString() {
//             return "d=" + d + " w=" + w;
//         }
//     }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 대기중인 트럭들의 무게를 담을 Queue
        Queue<Integer> trucks = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }
        
        // 다리에 현재 올라가있는 트럭들의 총 무게
        int totalWeights = 0;
        // 총 소요시간
        int totalTime = 0;
        // 다리에 올라가있는 트럭을 담을 Queue
        Queue<Integer> bridge = new LinkedList<>();
        
        // 첫번째 트럭 다리 위로 이동
        int firstTruck = trucks.poll();
        bridge.add(firstTruck);
        totalTime++;
        totalWeights += firstTruck;
        
        
        int curr = 0;
        while(!trucks.isEmpty() || (trucks.isEmpty() && curr != 0)) {
            // 다음으로 다리에 올라갈 트럭
            curr = curr == 0 ? trucks.poll() : curr;
            
            // 다리를 모두 지난 트럭 빼기
            if(bridge.size() == bridge_length) {
                int t = bridge.poll();
                totalWeights -= t;
            }
            
            // 다리에 트럭이 올라갈 수 있는지 확인
            if(totalWeights + curr <= weight) {
                bridge.offer(curr);
                totalWeights += curr;
                curr = 0;
            } else {
                bridge.offer(0);
            }
            
            totalTime++;
        }
        
        return totalTime + bridge_length;
    }
}