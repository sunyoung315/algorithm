package gold.boj_30855_Φ2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Micro {
        int pos;
        int size;

        public Micro(int pos, int size) {
            this.pos = pos;
            this.size = size;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 미생물의 수
        int N = sc.nextInt();

        List<Micro> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr.add(new Micro(i, sc.nextInt()));
        }

        while(arr.size() > 1) {
            for(int j = 0; j < arr.size(); j++) {
               if(j-1 >= 0 && arr.get(j).size >= arr.get(j-1).size) {
                   int newSize = arr.get(j).size + arr.get(j-1).size;
                   arr.set(j, new Micro(arr.get(j).pos, newSize));
                   arr.remove(j-1);
               }
               if(j+1 < arr.size() && arr.get(j).size >= arr.get(j+1).size) {
                   int newSize = arr.get(j).size + arr.get(j+1).size;
                   arr.set(j, new Micro(arr.get(j).pos, newSize));
                   arr.remove(j+1);
               }
            }
        }

        System.out.println(arr.get(0).size);
        System.out.println(arr.get(0).pos + 1);
    }
}
