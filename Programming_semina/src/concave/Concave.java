package concave;

public class Concave {
	static int cnt=0, row=1, col=1;
	static int ur=1, dr=1;  // ������ ��, ������ �Ʒ� �밢��
	
	// �ٵ��� -> 1: ���� ��, 2: �� ��
	static int input[][] = {      
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,2,0,0,2,2,2,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	
	public static void main(String[] args) {
		// 5���� ���� �������� ����, ����, �밢������ ���� ��� �¸� (6���� �̱� ���� �ƴϴ�)
		
		for (int i=0;i<19;i++) {
			for (int j=0;j<19;j++) {
				if (input[i][j] == 1) {	// ���� ��
					search(i, j, 1);
				}
				else if(input[i][j] == 2) {
					search(i, j, 2);
				}
			}
		}
	}

	// �� �ִ��� Ȯ��
	public static boolean check(int x, int y, int num) {
		if (isVaild(x, y)) {	
			if (input[x][y] != num) {	// �ش� ������ ���� �ƴϸ� false ��ȯ
				return false;
			}
		} 
		else {
			return false;
		}
		
		return true;
	}
	// ���� �� ���ο� �ִ��� �˻�
	public static boolean isVaild(int x, int y) {
		if (x < 0 || x > 19 || y < 0 || y > 19)
			return false;
		return true;
	}
	
	// ���
	public static void output(int i, int j, int num) {
		System.out.println(num);
		System.out.println((i+1) + " " + (j+1));
	}
	
	// num ������ �� Ž�� 
	// ������ ����(��), ����(��), ������ �Ʒ� �밢��(��), ������ �� �밢��(��)
	public static void search(int i, int j, int num) {
		// ���� �˻�
		for (int k=1;k<5;k++) {
			if (!check(i,j+k,num))	// �˻� ��� ������
				break;
			else
				row++;
		}
		
		// ���� �˻�
		for (int k=1;k<5;k++) {
			if (!check(i+k,j,num))
				break;
			else
				col++;
		}
		
		// �Ʒ� ���������� �밢�� �˻�
		for (int k=1;k<5;k++) {
			if (!check(i+k, j+k, num))
				break;
			else 
				dr++;
		}
		
		// ���� ������ �밢�� �˻�
		for (int k=1;k<5;k++) {
			if (!check(i-k, j+k, num))
				break;
			else 
				ur++;
		}
		
		// �� �� ������ �� ����� ���� �ִ��� Ȯ��(���ӵ� ���� 6���� ��� Ȯ��)
		if (row == 5) {
			if (isVaild(i, j-1)) { // ���� ���� ���� ���� �� ���ο� �ִ��� Ȯ��
				if (input[i][j-1] != num) {  // ���� ���� �� ���� ���� ������ Ȯ��
					if (isVaild(i, j+5)) { // ���� ������ �ڿ� �� Ȯ��
						if (input[i][j+5] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i, j+5)) {
					if (input[i][j+5] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		if (col == 5) {
			if (isVaild(i-1, j)) {
				if (input[i-1][j] != num) {
					if (isVaild(i+5, j)) {
						if (input[i+5][j] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i+5, j)) {
					if (input[i+5][j] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		if (dr == 5) {
			if (isVaild(i-1, j-1)) {
				if (input[i-1][j-1] != num) {
					if (isVaild(i+5, j+5)) {
						if (input[i+5][j+5] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i+5, j+5)) {
					if (input[i+5][j+5] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		if (ur == 5) {
			if (isVaild(i+1, j-1)) {
				if (input[i+1][j-1] != num) {
					if (isVaild(i-5, j+5)) {
						if (input[i-5][j+5] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i-5, j+5)) {
					if (input[i-5][j+5] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		
		// �ٽ� �ʱ�ȭ
		row = 1;
		col = 1;
		ur = 1;
		dr = 1;
	}
}
