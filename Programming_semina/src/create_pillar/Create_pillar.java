package create_pillar;

public class Create_pillar {
	static String[][] input = {
			{"Y", "B", "R", "B", "R", "G"},
			{"G", "Y", "B", "G", "B", "Y"},
			{"R", "G", "B", "Y", "Y", "R"},
			{"Y", "B", "G", "B", "Y", "Y"}};

	// �ֻ����� ���̴� ����� �� : �ٴڸ��� �� 6���� ������ �����Ѵٰ� ���� ��, ���������� ������ ���(4)
	// 6 x 4 = 24
	
	public static boolean check(String[] arr) {	// �� ���鿡 R,G,B,Y�� ���ԵǾ� �־�� ��.
		return false;
	}
	
	
	public void right() {
		
	}
	
	public static void main(String[] args) {
		String[] arr = new String[4];	// ���� ����
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<input[i].length;j++) {
				arr[i] = input[i][j];
			}
			
			check(arr);
		}
	}
}
