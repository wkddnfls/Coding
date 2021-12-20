package bulb;

import java.util.*;

public class Bulb {
	static int N = 10; // 전구의 수
	static int K = 3; // 전구가 표현할 수 있는 색의 수
	static int color[] = {1, 1, 2, 3, 3, 3, 2, 2, 1, 1};
	static int count = 0;
	
	public static ArrayList<Integer> numarray(ArrayList<Integer> arr) {
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		arr2.add(arr.get(0));
		for (int i=1;i<arr.size();i++) {
			if (arr.get(i-1) == arr.get(i)) {
				continue;
			}
			else {
				arr2.add(arr.get(i));
			}
		}
		System.out.println(arr2);
		return arr2;
	}
	
	public static int function(int index, ArrayList<Integer> arr) {
		int left = index-1;
		int right = index+1;
		
		if (arr.size() == 1) {
			return count;
		}
		
		if (index == 0) {	// 첫 번째 수
			arr.set(index, arr.get(right));
			arr = numarray(arr);
			count++;
			function(index, arr);
		} 
		else if (index>0 && index < arr.size()-1) {
			if (arr.get(left)==arr.get(right)) {	// 양쪽 값이 같으면 그 수로 변경
				arr.set(index, arr.get(right));
				arr = numarray(arr);
				count++;
				function(index, arr);
			}
			else { 
				arr.set(index, arr.get(left));
				arr = numarray(arr);
				count++;
				System.out.println(index);
				function(index, arr);
			}
		}
		else {
			arr.set(index, arr.get(left));
			arr = numarray(arr);
			count++;
			function(arr.size()-1, arr);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i=0;i<color.length;i++) {
			arr.add(color[i]);
		}
		arr = numarray(arr);
		
		for (int i=0;i<arr.size();i++) {
			System.out.println("cnt : " + function(i, arr));
			count = 0;
			System.out.println("arr1" + arr);
		}
	}
}
