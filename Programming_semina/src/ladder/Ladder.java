package ladder;

public class Ladder {
	static int k = 10;
	static int n = 5;
	static int index = 2;
	static String start[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	static String end[] = {"A", "C", "G", "B", "E", "D", "J", "F", "I", "H"};
	static String result[] = new String[k];  // ����
	static String[][] ladder = {
			{"*", "-", "*", "*", "*", "-", "*", "*", "*" }, 
			{"-", "*", "-", "*", "*", "*", "*", "*", "*" },
			{"?", "?", "?", "?", "?", "?", "?", "?", "?" },
			{"-", "*", "*", "-", "*", "*", "*", "-", "*" },
			{"*", "*", "-", "*", "-", "*", "-", "*", "-" }
	};
	
//	static int k = 11;
//	static int n = 5;
//	static int index = 2;
//	static String start[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
//	static String end[] = {"C", "G", "B", "E", "D", "J", "F", "K", "I", "H", "A"};
//	static String result[] = new String[k];  // ����
//	static String[][] ladder = {
//			{"*", "-", "*", "*", "*", "-", "*", "*", "*", "*" }, 
//			{"-", "*", "-", "*", "*", "*", "*", "*", "*", "-" },
//			{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?" },
//			{"-", "*", "*", "-", "*", "*", "*", "-", "*", "-" },
//			{"*", "*", "-", "*", "-", "*", "-", "*", "-", "*" }
//	};
	
	public static void main(String[] args) {
		
		// ���� ���ĺ����� '?' ������ ��ٸ�Ÿ��
		for (int i=0;i<index;i++) {
			for (int j=0;j<ladder[i].length;j++) {
				if (ladder[i][j] == "-") {
					swap(start, j, j+1);
				}
			}
		}
		
		// ��� ���ĺ����� '?' ������ ��ٸ�Ÿ��
		for (int i=n-1;i>index;i--) {
			for (int j=0;j<ladder[i].length;j++) {
				if (ladder[i][j] == "-") {
					swap(end, j, j+1);
				}
			}
		}
		
//		System.out.print("[start] : ");
//		for (int i=0;i<start.length;i++) {
//			System.out.print(start[i] + " ");
//		}
//		System.out.println();
//		System.out.print("[end] : ");
//		for (int i=0;i<end.length;i++) {
//			System.out.print(end[i] + " ");
//		}
		
		// '?'�� ��, �Ʒ� ���ĺ� ��
		boolean a = true;
		for (int i=0;i<k-1;i++) {
			if (start[i] == end[i]) {
				result[i] = "*";
			} else if ((start[i] == end[i+1]) && (start[i+1] == end[i])) {
				result[i] = "-";
				swap(start, i, i+1);
			} else {
				a = false;
				break;
			}
		}
		
		if (a == false) {
			for (int i=0;i<k-1;i++) {
				System.out.print("x");
			}
		} else {
			for (int i=0;i<k-1;i++) {
				System.out.print(result[i]);
			}
		}
		
	}

	private static void swap(String[] arr, int index1, int index2) {
		String temp;
		
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
