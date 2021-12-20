package budget;

public class Budget {
	public static void main(String[] args) {
		int N = 4;
		int[] arr = {120, 110, 140, 150};
		int M = 485;
		
//		int N = 5;
//		int[] arr = {70, 80, 30, 40, 100};
//		int M = 450;
		
		int sum = 0;
		int max = 0;
		
		for (int i=0;i<N;i++) {
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		
		if (sum <= M) {	// 총 합이 예산보다 적을 경우
			System.out.println(max);
		} else {	
			int result = 0;
			int min = 0;
			int mid = 0;
			
			while (true) {
				//System.out.println("----------");
				mid = (max + min)/2;
				//System.out.println("mid : " + mid);
				sum = 0;
				if (mid == min) {	
					break;
				}
				
				for (int i=0;i<N;i++) {
					// mid 보다 작으면 예산 모두 배분, 아니면 mid값 배분
					sum += (mid < arr[i]) ? mid : arr[i];
				}
				//System.out.println("sum : " + sum);
				if (sum <= M) {
					result = Math.max(mid, result);
					min = mid;
					//System.out.println("min : " + min);
				} else {
					max = mid;
					//System.out.println("max : " + max);
				}
			}
			System.out.println(result);
		}
		
	}
}
