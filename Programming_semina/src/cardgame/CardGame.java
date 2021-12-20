package cardgame;

import java.util.ArrayList;

public class CardGame {
	static int[] a_arr = {4, 5, 6, 7, 0, 1, 2, 3, 9, 8};
	static int[] b_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	
//	static int[] a_arr = {9, 1, 7, 2, 6, 3, 0, 4, 8, 5};
//	static int[] b_arr = {6, 3, 9, 2, 1, 0, 7, 4, 8, 5};
	
//	static int[] a_arr = {7, 1, 6, 2, 3, 0, 5, 9, 4, 8};
//	static int[] b_arr = {7, 1, 6, 2, 3, 0, 5, 9, 4, 8};
	
	static int a_score = 0;
	static int b_score = 0;
	static ArrayList<String> result = new ArrayList<String>();
	
	static String win = "";
	
	public static void main(String[] args) {
		for (int i=0;i<a_arr.length;i++) {
			// a가 이겼을 경우
			if (a_arr[i] > b_arr[i]) {
				a_score += 3;
				result.add("A");
			}
			// b가 이겼을 경우
			if (a_arr[i] < b_arr[i]) {
				b_score += 3;
				result.add("B");
			}
			// 비겼을 경우
			if (a_arr[i] == b_arr[i]) {
				a_score += 1;  b_score += 1;
				result.add("D");
			}
		}
		
		for (String i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 승자 확인
		System.out.println("A 점수 : " + a_score + ", B 점수 : " + b_score);
		if (a_score > b_score) {
			win = "A";
		}
		if (a_score < b_score) {
			win = "B";
		}
		if (a_score == b_score) {
			for (int i=result.size()-1; i>0; i--) {
				if (result.get(i) != "D") {
					win = result.get(i);
				} else {
					win = "D";
				}
			}
		}
		
		System.out.println("[result : " + win + "]");
	}
}
