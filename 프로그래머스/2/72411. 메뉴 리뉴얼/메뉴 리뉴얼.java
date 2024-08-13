import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;

class Solution {
    // 메뉴 조합의 주문 횟수를 담기 위한 Map
    static Map<String, Integer> menus;
    
    // 가장 많이 함께 주문된 횟수를 저장하기 위한 변수
    static int maxOrder;
    
    public String[] solution(String[] orders, int[] course) {
        // 메뉴 구성 후보를 담을 list
        List<String> menuList = new ArrayList<>();
        
        for(int i = 0; i < course.length; i++) {
            // map 생성
            menus = new HashMap<>();
            // 가장 많이 함께 주문된 횟수 초기화
            maxOrder = 0;
            
            // 코스메뉴의 개수
            int c = course[i];
            for(int j = 0; j < orders.length; j++) {
                // i번째 손님이 주문한 단품메뉴 조합 (메뉴 오름차순 정렬)
                String o = sortOrder(orders[j]);
            
                // 손님의 단품메뉴 조합 개수가 코스메뉴 개수보다 크거나 같으면 조합 확인
                if(o.length() >= c) {
                    StringBuilder sb = new StringBuilder();
                    // 코스메뉴 조합
                    combi(o, sb, 0, 0, c);
                }
            }
            
            // 가장 조합이 많이 된 메뉴 찾기
            for(Entry<String, Integer> menu : menus.entrySet()) {
                if(menu.getValue() >= 2 && menu.getValue() == maxOrder) {
                    menuList.add(menu.getKey());
                }
            }
        }
        
        return menuList.stream().sorted().toArray(String[]::new);
    }
    
    // 주문한 단품메뉴 조합 오름차순 정렬 문자열로 변환
    static String sortOrder(String o) {
        char[] oArr = o.toCharArray();
        Arrays.sort(oArr);
        return String.valueOf(oArr);
    }
    
    // o: 주문한 단품메뉴 조합, idx: 인덱스, cnt: 지금까지 sb로 조합된 개수, n: 구성할 코스메뉴의 개수
    static void combi(String o, StringBuilder sb, int idx, int cnt, int c) {
        // 조합이 완성되면 종료
        if(cnt == c) {
            String menu = sb.toString();
            menus.put(menu, menus.getOrDefault(menu, 0) + 1);
            // 가장 많이 함께 주문된 횟수 갱신
            maxOrder = Math.max(maxOrder, menus.get(menu));
            return;
        }
        
        for(int i = idx; i < o.length(); i++) {
            sb.append(o.charAt(i));
            // 재귀호출
            combi(o, sb, i + 1, cnt + 1, c);
            // 가장 뒤에 추가된 메뉴 삭제
            sb.delete(cnt, cnt + 1);
        }
    }
}