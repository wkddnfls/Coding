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
		
		System.out.print("두 수를 입력하시오 >>");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		System.out.print("1.덧셈, 2.뺄셈, 3.곱셈, 4.나눗셈 >>");
		int num = sc.nextInt();
		
		if (num < 1 || num > 4) {
			System.out.println("잘못된 입력입니다. 다시 입력하세요!");
		}else {
			System.out.println("연산 결과 : " + calculator(num, a, b));
		}
	}
}
