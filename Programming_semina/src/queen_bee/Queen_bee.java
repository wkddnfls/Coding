package queen_bee;

public class Queen_bee {
	static int M = 4;  // ����ĭ ũ��
	static int N = 2;  // ��¥ ��
	static int[][] map = new int[M][M];
	static int[][] num_arr = {
			{2, 3, 2},
			{0, 6, 1}
	};
//	static int[][] num_arr = {
//			{1, 1, 1},
//			{0, 3, 0},
//			{0, 0, 3}
//	};
	static int[][] num_arr2 = new int[N][(M*2)-1];  // �ֹ����� ������ Ŀ���� ���� ����
	
	public static void bee_map() {	
		int[][] pre_map = new int[M][M];  // ���ϱ� �� �� ����
		int[][] next_map = new int[M][M]; // ���� �� �� ����
		
		for (int i=0;i<M;i++) {
			for (int j=0;j<M;j++) {
				pre_map[i][j] = map[i][j];
				next_map[i][j] = map[i][j];
			}
		}
		
		for (int i=0;i<N;i++) {
			int index = 0;
			int num = 0;
			
			// ���� ���� ��, �� �� ������ ����
			for (int j=0;j<num_arr[i].length;j++) {
				if (num_arr[i][j] != 0) {
					for (int k=0;k<num_arr[i][j];k++) {
						num_arr2[i][index++] = num;
					}
				}
				num++;
			}

			// ���� ���� ��, �� �� ����
			index = 0;
			for (int j=M-1;j>=0;j--) {
				next_map[j][0] += num_arr2[i][index++];
			}
			for (int j=1;j<M;j++) {
				next_map[0][j] += num_arr2[i][index++];
			}
			
			map = plus_bee(pre_map, next_map);  // (1,1)���� �ֹ��� ����
			
//			System.out.println("[ " + (i+1) + "��° ��" + "  ]");
//			print();
		}
		
	}
	
	public static int[][] plus_bee(int pre_map[][], int next_map[][]) {
		for (int i=1;i<M;i++) {
			for (int j=1;j<M;j++) {
				int L = next_map[i][j-1] - pre_map[i][j-1];  // ����
				int D = next_map[i-1][j-1] - pre_map[i-1][j-1];  // ���� ��
				int U = next_map[i-1][j] - pre_map[i-1][j];  // ��
				
				// �� ���� ���� �� ���� ū ������ ����
				int value = (L > D)? L : D;
				int max = (U > value)? U : value;
				
				next_map[i][j] = pre_map[i][j] + max;
			}
		}
		return next_map;
	}
	
	public static void print() {
		for (int i=0;i<M;i++) {
			for (int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// ó�� �ʱ�ȭ
		for (int i=0;i<M;i++) {
			for (int j=0;j<M;j++) {
				map[i][j] = 1;
			}
		}
		System.out.println("[ ó�� ��  ]");
		print();
		
		bee_map();
		
		System.out.println("[ ���  ]");
		print();
	}
}
