package numberGame;

public class NumberGame {
	static int N = 3;
	static int[][] kard = {
			{7, 5, 5, 4, 9},
			{1, 1, 1, 1, 1},
			{2, 3, 3, 2, 10}
	};
	static int max = 0;	// N�� �� ���� �ڸ� ���� ���� ū �� ����
	
	public static void main(String[] args) {
		int result[] = new int[N];	// ���� �ڸ� ���� �ִ��� �� ����
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<5;j++) {	
				
				// 5�� �� 3���� ī�带 ��� result �� ���ϱ�
				for (int a=j+1;a<5;a++) {
					for (int b=a+1;b<5;b++) {
						int tmp = (kard[i][j] + kard[i][a] + kard[i][b]) % 10;	// ���� �ڸ� �� ���ϱ�
						
						result[i] = Math.max(result[i], tmp);	// max : �� �� ū ���� ����
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
