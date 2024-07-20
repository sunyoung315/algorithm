import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르와 총 재생된 횟수를 저장하기 위한 map
        Map<String, int[]> songs = new HashMap<>();
        // 장르와 재생 횟수가 높은 2개의 노래 index를 저장하기 위한 map
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            // map에 해당 장르가 있는지 확인
            if(!songs.containsKey(genres[i])) {
                // 재생횟수 저장
                rank.put(genres[i], plays[i]);
                
                // 처음 저장하는 장르이므로 1번째 노래로 저장
                int[] info = {i, -1};
                songs.put(genres[i], info);                
            } 
            // map에 장르가 있는 경우
            else {
                // 재생횟수 계산 저장
                rank.put(genres[i], rank.get(genres[i]) + plays[i]);
                
                int[] info = songs.get(genres[i]);

                // 1번째 2번째로 재생횟수가 많은지 확인해서 저장
                if(plays[i] > plays[info[0]]) {
                    info[1] = info[0];
                    info[0] = i;
                } else if(info[1] == -1 || plays[i] > plays[info[1]]) {
                    info[1] = i;
                }
                
                songs.put(genres[i], info);
            }
        }
        
        int idx = 0;
        // 정답을 저장할 list
        List<Integer> list = new ArrayList<>();
        
        // map에 있는 모든 키를 확인할 때까지 반복
        while(songs.size() > 0) {
            // map에서 총 재생횟수가 가장 높은 키 찾기
            String maxKey = rank.keySet().stream()
                .max(Comparator.comparing(rank::get))
                .orElse(null);
            
            // 1번째, 2번재 곡 있는지 확인해서 정답 배열에 넣기
            int[] info = songs.get(maxKey);
            if(info[0] > -1)
                list.add(info[0]);
            if(info[1] > -1)
                list.add(info[1]);
            
            // 해당 키는 map에서 제거
            songs.remove(maxKey);
            rank.remove(maxKey);
        }        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}