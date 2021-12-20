package confetti;

public class Confetti {
	static int N = 8;	// 색종이 한 변의 길이
	static int confetti[][] = {				
			{1, 1, 0, 0, 0, 0, 1, 1},
			{1, 1, 0, 0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0},
			{1, 0, 0, 0, 1, 1, 1, 1},
			{0, 1, 0, 0, 1, 1, 1, 1},
			{0, 0, 1, 1, 1, 1, 1, 1},
			{0, 0, 1, 1, 1, 1, 1, 1}
	};
	
	// 출력 변수
	static int white = 0;	
	static int blue = 0;
	
	// 색상이 같은지 확인
	public static boolean color_scan(int y, int x, int size) {
		int first_color = confetti[y][x];	// 첫 번쨰 원소 색상
		
		for (int i=y; i<y+size; i++) {
			for (int j=x; j<x+size; j++) {
				if (confetti[i][j] != first_color) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// 색종이 4분면으로 분리
	public static void cut_confetti(int y, int x, int size) {
		// 색상이 같으면 리턴
		if (color_scan(y, x, size) == true) {	
			if (confetti[y][x] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int halfsize = size/2;
		
		cut_confetti(y, x, halfsize);	// 제 2사분면
		cut_confetti(y, x+halfsize, halfsize);	// 제 1사분면
		cut_confetti(y+halfsize, x, halfsize);	// 제 3사분면
		cut_confetti(y+halfsize, x+halfsize, halfsize);	// 제 4사분면
	}
	
	public static void print(int[][] confetti_arr) {
		for (int i=0;i<confetti_arr.length;i++) {
			for (int j=0;j<confetti_arr[i].length;j++) {
				System.out.print(confetti_arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		cut_confetti(0, 0, N);
		
		System.out.println("white : " + white + ", blue : " + blue);
	}
}
