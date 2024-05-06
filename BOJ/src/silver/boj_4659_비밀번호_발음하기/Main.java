package silver.boj_4659_비밀번호_발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = "";
        StringBuilder sb = new StringBuilder();
        while(!password.equals("end")) {
            password = br.readLine();
            if (password.equals("end")) break;

            char[] passArr = password.toCharArray();
            int totalmCnt = 0;
            int sameCnt = 0;
            // 자음이면 true, 모음이면 false
            boolean flag = false;
            boolean quality = true;
            for(int i = 0; i < passArr.length; i++) {
                if(passArr[i] == 'a' || passArr[i] == 'e' || passArr[i] == 'i' || passArr[i] == 'o' || passArr[i] == 'u') {
                    totalmCnt++;
                    if(flag == true) {
                        flag = false;
                        sameCnt = 0;
                    }
                    ++sameCnt;
                    if(sameCnt == 3) {
                        quality = false;
                        break;
                    }
                    if(i > 0 && passArr[i] != 'e' && passArr[i] != 'o' && passArr[i] == passArr[i-1] ) {
                        quality = false;
                    }
                } else {
                    if(flag == false) {
                        flag = true;
                        sameCnt = 0;
                    }
                    ++sameCnt;
                    if(sameCnt == 3) {
                        quality = false;
                        break;
                    }
                    if(i > 0 && passArr[i] == passArr[i-1]) {
                        quality = false;
                    }
                }
            }

            if(totalmCnt == 0) quality = false;

            sb.append("<").append(password).append("> is ");
            if(quality) {
                sb.append("acceptable.\n");
            } else {
                sb.append("not acceptable.\n");
            }
        }//while

        System.out.println(sb);
    }//main
}//Main
