package classleader;

import java.util.HashSet;

public class Classleader {
	static int N = 5;
	static int[][] input = {
			{2, 3, 1, 7, 3},
			{4, 1, 9, 6, 8},
			{5, 5, 2, 4, 4},
			{6, 5, 2, 6, 7},
			{8, 4, 2, 2, 2}
	};
	static int max = 0;	
	static int classleader = 0;
	public static void main(String[] args) {
		
		for (int i=0;i<N;i++) {
			HashSet<Integer> set = new HashSet<Integer>();	 // �߰��� �� �ߺ����� �ϳ��� �߰�����
			
			for (int j=0;j<5;j++) {
				for (int k=0;k<N;k++) {
					if (i == k) { 	// �л� ����
						continue;
					}
					if (input[i][j] == input[k][j]) {	// ���� ���� ��
						set.add(k+1);
					}
				}
			}
			//System.out.println(set);
			
			if (max < set.size()) {
				max = set.size();
				classleader = i + 1;
			}
		}
		
		if (classleader == 0) {
			System.out.println("1");	// ���� ���� ��찡 �Ѹ� ������ 1���� ����
		} else{
			System.out.println(classleader);
		}
	}
}
