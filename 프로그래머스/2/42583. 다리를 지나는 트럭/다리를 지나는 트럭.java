import java.util.*;

class Solution {
    class Truck {
        int w;
        int l;
        
        public Truck(int w, int l) {
            this.w = w;
            this.l = l;
        }
        
        public void move() {
            this.l--;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridge_weight = 0;
        Queue<Truck> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            Truck truck = new Truck(truck_weights[i], bridge_length);

            while(true) {
                if(!bridge.isEmpty()) {
                    for (Truck t : bridge) t.move();

                    if (bridge.peek().l == 0) {
                        Truck out = bridge.poll();
                        bridge_weight -= out.w;
                    }
                }

                if(bridge.size() < bridge_length && bridge_weight + truck.w <= weight) {
                    bridge.offer(truck);
                    bridge_weight += truck.w;
                    time++;

                    break;
                }
                
                time++;
            }
        }

        return time + bridge_length;
    }
}