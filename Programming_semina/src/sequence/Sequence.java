package sequence;

import java.util.ArrayList;

public class Sequence {
	static int N = 10;  // 온도를 측정한 전체 날짜의 수
	static int K = 2;   // 합을 구하기 위한 연속적인 날짜의 수
//	static int N = 10;
//	static int K = 5;

	static int temp[] = {3, -2, -4, -9, 0, 3, 7, 13, 8, -3}; // 온도 배열
	
	public static void main(String[] args) {
		ArrayList<Integer> sum_arr = new ArrayList<Integer>();
		
		for (int i=0;i<N-K+1;i++) {
			int sum = 0;
			for (int j=i;j<i+K;j++) {
				sum += temp[j];
			}
			sum_arr.add(sum);
			
		}
		
		// 최댓값 골라내기
		int max = 0;
		for (int i=0;i<sum_arr.size();i++) {
			if (max < sum_arr.get(i)) {
				max = sum_arr.get(i);
			}
		}
		
		for (int i=0;i<sum_arr.size();i++) {
			System.out.print(sum_arr.get(i) + " ");
		}
		System.out.println();
		System.out.println("최댓값 : " + max);
	}
}
