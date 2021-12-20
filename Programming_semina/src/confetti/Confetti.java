package confetti;

public class Confetti {
	static int N = 8;	// ������ �� ���� ����
	static int confetti[][] = {				
			{1, 1, 0, 0, 0, 0, 1, 1},
			{1, 1, 0, 0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0},
			{1, 0, 0, 0, 1, 1, 1, 1},
			{0, 1, 0, 0, 1, 1, 1, 1},
			{0, 0, 1, 1, 1, 1, 1, 1},
			{0, 0, 1, 1, 1, 1, 1, 1}
	};
	
	// ��� ����
	static int white = 0;	
	static int blue = 0;
	
	// ������ ������ Ȯ��
	public static boolean color_scan(int y, int x, int size) {
		int first_color = confetti[y][x];	// ù ���� ���� ����
		
		for (int i=y; i<y+size; i++) {
			for (int j=x; j<x+size; j++) {
				if (confetti[i][j] != first_color) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// ������ 4�и����� �и�
	public static void cut_confetti(int y, int x, int size) {
		// ������ ������ ����
		if (color_scan(y, x, size) == true) {	
			if (confetti[y][x] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int halfsize = size/2;
		
		cut_confetti(y, x, halfsize);	// �� 2��и�
		cut_confetti(y, x+halfsize, halfsize);	// �� 1��и�
		cut_confetti(y+halfsize, x, halfsize);	// �� 3��и�
		cut_confetti(y+halfsize, x+halfsize, halfsize);	// �� 4��и�
	}
	
	public static void print(int[][] confetti_arr) {
		for (int i=0;i<confetti_arr.length;i++) {
			for (int j=0;j<confetti_arr[i].length;j++) {
				System.out.print(confetti_arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		cut_confetti(0, 0, N);
		
		System.out.println("white : " + white + ", blue : " + blue);
	}
}
