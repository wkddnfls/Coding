package common_factor;

public class Common_factor {
	static int GCD = 6;  // greatest common divisor
	static int LCM = 180;// largest common multiple
//	static int GCD = 2;  
//	static int LCM = 86486400;
	
	// �� �ڿ���
	static int num1 = GCD;
	static int num2 = LCM;
	
	public static void main(String[] args) {
		// ���а��� -> �� �ڿ����� �� = �ִ����� x �ּҰ����
		int mat = GCD * LCM;
		
		// num1, num2�� mat�� ������� �ּҰ������ �����
		for (int i=2*GCD; i <= mat; i+=GCD) {
			if (mat % i == 0) {  // mat�� ����̸�
				int tmp = mat / i;
				
				// i, tmp�� ã�����ϴ� �� ��
				if (GCD(i, tmp) == GCD) {  
					if (num1 + num2 > i + tmp) {	// ���� �ͺ��� ������ ����
						num1 = i;
						num2 = tmp;
					}
				}
			}
		}
		
		System.out.println(num1 + " " + num2);
	}
	
	// �ִ����� ���ϱ�
	public static int GCD(int a, int b) {
		if (b == 0) { 
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
}
