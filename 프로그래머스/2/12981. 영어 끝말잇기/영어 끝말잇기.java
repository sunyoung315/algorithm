import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        // 끝말잇기에 등장한 단어를 모으기 위한 Set
        Set<String> wordSet = new HashSet<>();
        
        // 첫번째 단어는 바로 Set에 넣기
        wordSet.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            // 이전 단어
            String prevWord = words[i - 1];
            
            // 현재 단어
            String nowWord = words[i];
            
            // 이미 나온 단어이면 게임 종료
            if(wordSet.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } 
            // 이전 단어의 마지막 글자와 현재 단어의 첫번째 글자가 동일하지 않으면 게임 종료
            else if (i > 0 && prevWord.charAt(prevWord.length() - 1) != nowWord.charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } 
            // 이 외의 경우에는 게임 계속 진행
            else {
                wordSet.add(words[i]);
            }
        }

        return answer;
    }
}