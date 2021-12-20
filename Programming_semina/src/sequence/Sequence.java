package sequence;

import java.util.ArrayList;

public class Sequence {
	static int N = 10;  // �µ��� ������ ��ü ��¥�� ��
	static int K = 2;   // ���� ���ϱ� ���� �������� ��¥�� ��
//	static int N = 10;
//	static int K = 5;

	static int temp[] = {3, -2, -4, -9, 0, 3, 7, 13, 8, -3}; // �µ� �迭
	
	public static void main(String[] args) {
		ArrayList<Integer> sum_arr = new ArrayList<Integer>();
		
		for (int i=0;i<N-K+1;i++) {
			int sum = 0;
			for (int j=i;j<i+K;j++) {
				sum += temp[j];
			}
			sum_arr.add(sum);
			
		}
		
		// �ִ� ��󳻱�
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
		System.out.println("�ִ� : " + max);
	}
}
