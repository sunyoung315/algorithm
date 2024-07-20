import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] record) {
        
        // 메시지를 담을 list
        List<String> messages = new ArrayList<>();
        // 유저의 아이디와 닉네임을 저장할 map
        Map<String, String> user = new HashMap<>();
        
        // 들어오거나 닉네임을 변경했을 때 유저 아이디와 닉네임을 user에 저장
        for(int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter") || str[0].equals("Change")) {
                user.put(str[1], str[2]);
            }
        }
        
        // 들어오고 나가쓸 때 user에서 아이디에 맞는 닉네임을 찾아 메시지 저장
        for(int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            
            StringBuilder sb = new StringBuilder();
            if(str[0].equals("Enter")) {
                sb.append(user.get(str[1])).append("님이 들어왔습니다.");
                messages.add(sb.toString());
            } else if(str[0].equals("Leave")) {
                sb.append(user.get(str[1])).append("님이 나갔습니다.");
                messages.add(sb.toString());
            }
        }
            
        return messages.stream().toArray(String[]::new);
        // return messages.toArray(new String[arr.size()]);
    }
}