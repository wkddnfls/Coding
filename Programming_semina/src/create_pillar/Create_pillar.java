package create_pillar;

public class Create_pillar {
	static String[][] input = {
			{"Y", "B", "R", "B", "R", "G"},
			{"G", "Y", "B", "G", "B", "Y"},
			{"R", "G", "B", "Y", "Y", "R"},
			{"Y", "B", "G", "B", "Y", "Y"}};

	// 주사위가 놓이는 경우의 수 : 바닥면을 각 6개의 면으로 고정한다고 했을 때, 오른쪽으로 돌리는 경우(4)
	// 6 x 4 = 24
	
	public static boolean check(String[] arr) {	// 각 옆면에 R,G,B,Y가 포함되어 있어야 함.
		return false;
	}
	
	
	public void right() {
		
	}
	
	public static void main(String[] args) {
		String[] arr = new String[4];	// 옆면 저장
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<input[i].length;j++) {
				arr[i] = input[i][j];
			}
			
			check(arr);
		}
	}
}
