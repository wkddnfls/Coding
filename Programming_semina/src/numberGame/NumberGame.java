package numberGame;

public class NumberGame {
	static int N = 3;
	static int[][] kard = {
			{7, 5, 5, 4, 9},
			{1, 1, 1, 1, 1},
			{2, 3, 3, 2, 10}
	};
	static int max = 0;	// N명 중 일의 자리 수가 가장 큰 값 저장
	
	public static void main(String[] args) {
		int result[] = new int[N];	// 일의 자리 수가 최대인 값 저장
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<5;j++) {	
				
				// 5장 중 3개의 카드를 골라 result 값 구하기
				for (int a=j+1;a<5;a++) {
					for (int b=a+1;b<5;b++) {
						int tmp = (kard[i][j] + kard[i][a] + kard[i][b]) % 10;	// 일의 자리 수 구하기
						
						result[i] = Math.max(result[i], tmp);	// max : 둘 중 큰 숫자 구함
					}
				}
			}
			
			max = Math.max(max, result[i]);
		}
		
		int number = 0;
		for (int i=0;i<N;i++) {
			if (result[i] == max) {
				number = i+1;
			}
		}
		
		System.out.println(number);
	}

}
