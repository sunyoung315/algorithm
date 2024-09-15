import java.util.*;

class Solution {
    // 해당 판매원의 추천인을 담을 Map
    static Map<String, String> ref;
    // 해당 판매원의 이익을 담을 Map
    static Map<String, Integer> profits;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        ref = new HashMap<>();
        profits = new HashMap<>();
            
        for(int i = 0; i < enroll.length; i++) {
            //      판매원의     추천인
            ref.put(enroll[i], referral[i]);
            // 각 판매원의 이익 0으로 세팅
            profits.put(enroll[i], 0);
        }
        
        for(int i = 0; i < seller.length; i++) {
            // 해당 판매원이 판매한 금액
            int profit = amount[i] * 100;
            
            // 이익 배분
            distributeProfit(seller[i], profit);
        }
        
        for(int i = 0; i < enroll.length; i++) {
            // 정답 배열에 입력
            answer[i] = profits.get(enroll[i]);
        }
        
        return answer;
    }
    
    public void distributeProfit(String seller, int profit) {
        
        // 판매원의 이익 90%
        int profitOfSeller = profit - (profit / 10);
        // 추천인의 이익 10%
        int profitOfRefferal = profit / 10;
        
        profits.put(seller, profits.get(seller) + profitOfSeller);
        
        // 상위 추천인이 없거나 center면 재귀 종료
        if(ref.get(seller) == null || ref.get(seller).equals("-")) return;
        
        // 10% 금액이 1원 미만일 경우 이득 분배 X
        if(profitOfRefferal >= 1) {
            // 상위 추천인까지 이익 분배
            distributeProfit(ref.get(seller), profitOfRefferal);
        }
        
    }
}