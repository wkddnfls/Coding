package parcel;

import java.util.Arrays;
import java.util.Comparator;

public class Parcel {
//	static int N = 4;	// ���� ��
//	static int C = 40;	// Ʈ���� �뷮
//	static int M = 6;	// ������ �ڽ� ������ ����
//	static int M_arr[][] = {
//			{3, 4, 20},
//			{1, 2, 10},
//			{1, 3, 20},
//			{1, 4, 30},
//			{2, 3, 10},
//			{2, 4, 20}
//	};
	
	static int N = 6;	// ���� ��
	static int C = 60;	// Ʈ���� �뷮
	static int M = 5;	// ������ �ڽ� ������ ����
//	static int M_arr[][] = {
//			{1, 2, 30},
//			{2, 5, 70},
//			{5, 6, 60},
//			{3, 4, 40},
//			{1, 6, 40}
//	};
	static int M_arr[][] = {
			{1, 6, 60},
			{1, 2, 10},
			{2, 3, 10},
			{3, 4, 10},
			{4, 5, 10}
	};
	
	
	public static void main(String[] args) {
		
		// �޴� ���� �������� ���� (��������)
		Arrays.sort(M_arr, new Comparator<int[]>() {
	         public int compare(int[] o1, int[] o2) {
	            if (o1[1] == o2[1])
	               return o1[0] - o2[0];
	            else
	               return o1[1] - o2[1];
	         }
         });
		
		for (int i=0;i<M;i++) {
			for (int j=0;j<M_arr[0].length;j++) {
				System.out.print(M_arr[i][j] + " ");
			}
			System.out.println();
		}
		
		int box[] = new int[N+1];
		int max, possible, total = 0;
		for (int i = 0; i < M; i++) {
			int from = M_arr[i][0];	// ������ ��
			int to = M_arr[i][1];	// �޴� ��
			int cnt = M_arr[i][2];	// �ù� ��
			max = 0;
			
			// �̹� �Ǹ� �ڽ��� �ִ�
			for (int j = from; j < to; j++) {
				max = Math.max(max, box[j]);
//				System.out.println("box : " + box[j]);
			}
//			System.out.println("===");
			
			// ���� �� �ִ� �ڽ� ��
			possible = Math.min(C-max, cnt);
			total += possible;
			
			for (int j = from; j < to; j++) {
				box[j] += possible;
			}
		}
		// ����� �� �ִ� �ִ� �ڽ� ��
		System.out.println(total+box[N]);
		
	}

}
