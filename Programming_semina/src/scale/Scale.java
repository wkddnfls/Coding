package scale;

import java.util.Arrays;

public class Scale {
	static int N = 7;
	static int[] weight = {3, 1, 6, 2, 7, 30, 1};
	
	public static void main(String[] args) {
		Arrays.sort(weight);	// 내림차순 정렬
		
		for (int i : weight) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int sum = 0;
		for (int i=0;i<N;i++) {
			if (sum+1 < weight[i]) {	// 다음 원소 값이 누적합+1 보다 크면 누적합+1은 만들지 못하는 무게 
				break;
			}
			
			sum += weight[i];
		}
		
		System.out.println(sum + 1);
	}
}
