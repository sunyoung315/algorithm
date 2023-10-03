package silver.boj_14916_거스름돈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//거스름돈 액수
		int change = sc.nextInt();
		
		//idx : 임시 거스름돈 액수, cnt[idx] : 최소 동전 개수
		int[] cnt = new int[change + 1];
		
		//거스름돈이 해당 동전의 금액보다 크면 해당 동전의 금액에는 1로 초기화
		if(change >= 2) cnt[2] = 1;
		if(change >= 5) cnt[5] = 1;
		
		for(int i = 1; i <= change; i++) {
			//2원짜리 동전만 고려했을 경우
			//임시 거스름돈 액수(i)가 2보다 커야 2원짜리 동전 사용 가능
			//cnt[i-2]가 0인 경우 2원짜리 사용이 불가능한 경우
			if(i >= 2 && cnt[i-2] != 0)
				cnt[i] = cnt[i-2] + 1;
			//2원짜리 + 5원짜리를 고려했을 경우
			//현재 임시 거스름돈에서 5를 뺐을 때 0이 아니어야 5원짜리 사용 가능
			if(i >= 5 && cnt[i-5] != 0) {
				//cnt[i]가 0이 아니면 현재금액에서 5만큼 뺐을 때의 개수에서 1 증가한 개수와 현재 개수를 비교하여 최소값 갱신
				if(cnt[i] != 0)
					cnt[i] = Math.min(cnt[i], cnt[i-5] + 1);
				//cnt[i]가 0이면 현재금액에서 5만큼 뺐을 때의 개수에서 1 증가한 개수로 저장
				else
					cnt[i] = cnt[i-5] + 1;
			}
		}
		
		System.out.println(cnt[change]);
		
	}//main
}//class
