package tile;

import java.util.ArrayList;

public class Tile {
	static int N = 11;
	static int input[] = {1, 2, 6, 7, 11, 12, 13, 15, 17, 20, 23};
	static int out = 0;
	static int plus = 1;	// 증가하는 값
	static int sum = 0;	// 합
	static int max = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void print() {
		for (Integer i : list) {
			System.out.print(i + ", ");
		}
	}
	
	public static void main(String[] args) {
		int a; 
		int b;
		
		for (int i=0;i<N;i++) {
			for (int j=i+1;j<N;j++) {
				a = input[j-1]; b = input[j]; // 비교할 숫자 저장
			
				if (b - a == plus) {
					if (list.contains(b+plus) == true) {
						list.add(a);
						list.add(b);
						list.add(b+plus);
					}
					
				}
				print();
				System.out.println();
			}
			list.clear();
//			if (list.size() >= 3) {
//				for (Integer value : list) {
//					sum += value;
//					System.out.println(sum);
//				}
//			} else {
//				list.clear();
//			}
			
			// 최댓값 구하기
//			max = max(sum);
//			sum = 0;
		}
//		print();
//		System.out.println();
//		System.out.println(max);
	}
	
	public static int max(int sum) {
		int max = 0;
		if (max < sum) {
			max = sum;
		}
		return max;
	}
	
}
