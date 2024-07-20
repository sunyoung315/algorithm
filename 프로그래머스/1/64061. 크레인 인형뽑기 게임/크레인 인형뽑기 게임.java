import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 집은 인형을 남을 바구니
        Stack<Integer> basket = new Stack<>();
        
        // moves 움직인 배열
        out: for(int i = 0; i < moves.length; i++) {
            // board의 행의 위치
            int idx = moves[i] - 1;
            // board의 열의 위치 중 인형이 있는 위치 찾기
            for(int j = 0; j < board.length; j++) {
                // 0이 아니면 집을 수 있는 인형이 있음
                if(board[j][idx] != 0) {
                    // 바구니의 맨 위에 동일한 인형이 있으면 터트려 사라짐
                    if(!basket.isEmpty() && basket.peek() == board[j][idx]) {
                        basket.pop();
                        // 한번에 사라지는 인형은 2개
                        answer += 2;
                        // 꺼낸 인형은 board에서 삭제
                        board[j][idx] = 0;
                        continue out;
                    }
                    // 동일한 인형이 아니면 바구니에 넣고 board에서 삭제
                    else {
                        basket.push(board[j][idx]);
                        board[j][idx] = 0;
                        continue out;
                    }
                }
            }
        }
        
        return answer;
    }
}