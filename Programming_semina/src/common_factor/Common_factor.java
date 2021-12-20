package common_factor;

public class Common_factor {
	static int GCD = 6;  // greatest common divisor
	static int LCM = 180;// largest common multiple
//	static int GCD = 2;  
//	static int LCM = 86486400;
	
	// 두 자연수
	static int num1 = GCD;
	static int num2 = LCM;
	
	public static void main(String[] args) {
		// 수학공식 -> 두 자연수의 곱 = 최대공약수 x 최소공배수
		int mat = GCD * LCM;
		
		// num1, num2는 mat의 약수이자 최소공배수의 배수임
		for (int i=2*GCD; i <= mat; i+=GCD) {
			if (mat % i == 0) {  // mat의 약수이면
				int tmp = mat / i;
				
				// i, tmp가 찾고자하는 두 수
				if (GCD(i, tmp) == GCD) {  
					if (num1 + num2 > i + tmp) {	// 이전 것보다 작으면 저장
						num1 = i;
						num2 = tmp;
					}
				}
			}
		}
		
		System.out.println(num1 + " " + num2);
	}
	
	// 최대공약수 구하기
	public static int GCD(int a, int b) {
		if (b == 0) { 
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
}
