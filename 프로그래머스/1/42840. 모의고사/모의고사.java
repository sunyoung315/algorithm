import java.util.*; 

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if((i % 5 == 0 && answers[i] == 1) || (i % 5 == 1 && answers[i] == 2)
              || (i % 5 == 2 && answers[i] == 3) || (i % 5 == 3 && answers[i] == 4)
              || (i % 5 == 4 && answers[i] == 5)) 
                score[0]++;
            if((i % 8 == 0 && answers[i] == 2) || (i % 8 == 1 && answers[i] == 1)
                   || (i % 8 == 2 && answers[i] == 2) || (i % 8 == 3 && answers[i] == 3)
                   || (i % 8 == 4 && answers[i] == 2) || (i % 8 == 5 && answers[i] == 4)
                   || (i % 8 == 6 && answers[i] == 2) || (i % 8 == 7 && answers[i] == 5))
                score[1]++;
            if((i % 10 == 0 && answers[i] == 3) || (i % 10 == 1 && answers[i] == 3)
                   || (i % 10 == 2 && answers[i] == 1) || (i % 10 == 3 && answers[i] == 1)
                   || (i % 10 == 4 && answers[i] == 2) || (i % 10 == 5 && answers[i] == 2)
                   || (i % 10 == 6 && answers[i] == 4) || (i % 10 == 7 && answers[i] == 4)
                   || (i % 10 == 8 && answers[i] == 5) || (i % 10 == 9 && answers[i] == 5))
                score[2]++;
        }
        
        int max = 0;
        int sameScore = 0;
        
        for(int i = 0; i < 3; i++) {
            if(score[i] > max) {
                max = score[i];
                sameScore = 1;
            } else if(score[i] == max) {
                sameScore++;
            }
        }
        
        int idx = 0;
        answer = new int[sameScore];
        for(int i = 0; i < 3; i++) {
            if(score[i] == max)
                answer[idx++] = i + 1;                
        }
        
        return answer;
    }
}