package sw_engineering;

import java.util.Scanner;

public class Calculator {
	
	public static double calculator(int num, double a, double b) {
		double result = 0;
		
		if (num == 1) result = a + b;
		else if (num == 2) result = a - b;
		else if (num == 3) result = a * b;
		else if (num == 4) result = a / b;
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� ���� �Է��Ͻÿ� >>");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		System.out.print("1.����, 2.����, 3.����, 4.������ >>");
		int num = sc.nextInt();
		
		if (num < 1 || num > 4) {
			System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���!");
		}else {
			System.out.println("���� ��� : " + calculator(num, a, b));
		}
	}
}
