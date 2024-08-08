import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public class Row {
        // 위 행
        Row prev;
        // 아래 행
        Row next;
        // 삭제 여부
        boolean deleted;
        
        public Row () {}
        
        // 위로 x칸 이동
        public Row moveUp(int x) {
            Row r = this;
            
            for(int i = 0; i < x; i++) {
                r = r.prev;
            }
            
            return r;
        }
        
        // 아래로 x칸 이동
        public Row moveDown(int x) {
            Row r = this;
            
            for(int i = 0; i < x; i++) {
                r = r.next;
            }
            
            return r;
        }
        
        // 해당 행 삭제
        public Row delete() {
            // 해당 행 삭제
            this.deleted = true;
            
            Row prevRow = this.prev;
            Row nextRow = this.next;
            
            // 삭제한 행의 위에 행이 있으면 연결
            if(prevRow != null)
                prevRow.next = nextRow;
            
            // 1. 삭제한 행의 아래에 행이 있으면 연결
            if(nextRow != null) {
                nextRow.prev = prevRow;
                // 삭제되면 다음행을 가리키므로 다음 행 반환
                return nextRow;
            }
            // 2. 마지막 행을 삭제한 경우
            else {
                // 바로 위의 행을 가리키므로 윗 행 반환
                return prevRow;
            }            
        }
        
        // 되돌리기
        public void reset() {
            // 삭제 취소
            this.deleted = false;
            
            Row prevRow = this.prev;
            Row nextRow = this.next;
            
            // 현재 행의 앞, 뒤의 행이 다시 현재 행을 가리키도록
            if(prevRow != null)
                prevRow.next = this;
            
            if(nextRow != null)
                nextRow.prev = this;
        }
        
    }
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        // 표
        Row[] table = new Row[n];
        
        // 삭제한 행을 저장할 stack
        Stack<Row> trash = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            table[i] = new Row();
            
            if(i == 0) continue;
            
            table[i - 1].next = table[i];
            table[i].prev = table[i - 1];
        }
        
        // 현재 행
        Row curr = table[k];
        
        for(int i = 0; i < cmd.length; i++) {
            // 명령어
            String[] command = cmd[i].split(" ");
            // 1. 명령어가 U이면
            if(command[0].equals("U")) {
                // 움직힐 행 수
                int x = Integer.parseInt(command[1]);
                curr = curr.moveUp(x);
            }
            // 2. 명령어가 D이면,
            else if(command[0].equals("D")) {
                // 움직힐 행 수
                int x = Integer.parseInt(command[1]);
                curr = curr.moveDown(x);                
            }
            // 3. 명령어가 C이면,
            else if(command[0].equals("C")) {    
                trash.push(curr);
                curr = curr.delete();            
            }
            // 4. 명령어가 Z이면,
            else if(command[0].equals("Z")) {    
                Row r = trash.pop();
                r.reset();     
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(table[i].deleted ? "X" : "O");
        }

        return sb.toString();
    }
}