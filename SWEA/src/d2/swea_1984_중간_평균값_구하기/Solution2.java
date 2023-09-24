package d2.swea_1984_중간_평균값_구하기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1984_중간_평균값_구하기/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int[] nums = new int[10];
			
			for(int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
			}

			int max = -1;
			int min = 10001;
			double sum = 0;
			
			for(int i = 0; i < 10; i++) {
				if(nums[i] > max) {
					max = nums[i];
				}
				if(nums[i] < min) {
					min = nums[i];
				}
				sum += nums[i];
			}
			
			double avg = (sum - max - min) / 8;
			
			System.out.printf("#%d %d\n",testCase ,Math.round(avg));
			
			
		}
		
	}
}
