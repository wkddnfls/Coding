package school_bus;

import java.util.Arrays;
import java.util.Comparator;

public class SchoolBus {
	static int N = 3;	// ����Ʈ ������ ��
	static int K = 4; 	// ���й����� ����
	static int S = 4; 	// �б��� ��ġ
	static int[][] student = {	// (����Ʈ ���� ��ġ, ��� �л� ��)
			{0, 1},
			{2, 2},
			{5, 1}
	};
	static int min = 0;	// ��°� (�ּ� �̵� �Ÿ�)
	
	public static void main(String[] args) {
		
		// �б��� ���� �Ÿ��� �� ����Ʈ������ ����
		Arrays.sort(student, new Comparator<int[]>() {
			public int compare(int[] t1, int[] t2) {
				return Math.abs(t2[0]-S) - Math.abs(t1[0]-S);
			}
		});
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<2;j++) {
				System.out.print(student[i][j] + " ");
			}
			System.out.println();
		}
		
		int left = K;	// ������ ���� �ڸ�
		int num = 0;	// ������ ����Ʈ ��
		while (num < student.length) {
			if (left > student[num][1]) {
				left -= student[num][1];
				student[num][1] = 0;
				num++;
			} else if (left < student[num][1]) {
				student[num][1] -= left;
				left = 0;
			} else {
				student[num][1] = 0;
				left = 0;
				num++;
			}
			
		}
		
		for (int i=0;i<N;i++) {
//			if (student[i][0] < S) {	// �б� ����
//				min += S - student[i][0];
//				left -= student[i][1];
//			} else {
//				min += student[i][0] - S;
//				left -= student[i][1];
//			}
		}
		
		System.out.println("�ּ� �̵� �Ÿ� : " + min);
	}
}
