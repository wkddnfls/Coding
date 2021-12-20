package concave;

public class Concave {
	static int cnt=0, row=1, col=1;
	static int ur=1, dr=1;  // 오른쪽 위, 오른쪽 아래 대각선
	
	// 바둑판 -> 1: 검은 돌, 2: 흰 돌
	static int input[][] = {      
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,2,0,0,2,2,2,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	
	public static void main(String[] args) {
		// 5개의 알이 연속으로 가로, 세로, 대각선으로 놓인 경우 승리 (6개는 이긴 것이 아니다)
		
		for (int i=0;i<19;i++) {
			for (int j=0;j<19;j++) {
				if (input[i][j] == 1) {	// 검은 돌
					search(i, j, 1);
				}
				else if(input[i][j] == 2) {
					search(i, j, 2);
				}
			}
		}
	}

	// 돌 있는지 확인
	public static boolean check(int x, int y, int num) {
		if (isVaild(x, y)) {	
			if (input[x][y] != num) {	// 해당 색상의 돌이 아니면 false 반환
				return false;
			}
		} 
		else {
			return false;
		}
		
		return true;
	}
	// 돌이 맵 내부에 있는지 검사
	public static boolean isVaild(int x, int y) {
		if (x < 0 || x > 19 || y < 0 || y > 19)
			return false;
		return true;
	}
	
	// 출력
	public static void output(int i, int j, int num) {
		System.out.println(num);
		System.out.println((i+1) + " " + (j+1));
	}
	
	// num 색상의 돌 탐색 
	// 순서는 가로(→), 세로(↓), 오른쪽 아래 대각선(↘), 오른쪽 위 대각선(↗)
	public static void search(int i, int j, int num) {
		// 가로 검사
		for (int k=1;k<5;k++) {
			if (!check(i,j+k,num))	// 검사 결과 없으면
				break;
			else
				row++;
		}
		
		// 세로 검사
		for (int k=1;k<5;k++) {
			if (!check(i+k,j,num))
				break;
			else
				col++;
		}
		
		// 아래 오른쪽으로 대각선 검사
		for (int k=1;k<5;k++) {
			if (!check(i+k, j+k, num))
				break;
			else 
				dr++;
		}
		
		// 위로 오른쪽 대각선 검사
		for (int k=1;k<5;k++) {
			if (!check(i-k, j+k, num))
				break;
			else 
				ur++;
		}
		
		// 양 쪽 끝으로 더 연결된 것이 있는지 확인(연속된 색이 6개인 경우 확인)
		if (row == 5) {
			if (isVaild(i, j-1)) { // 가장 왼쪽 옆에 돌이 맵 내부에 있는지 확인
				if (input[i][j-1] != num) {  // 가장 왼쪽 옆 돌이 같은 색인지 확인
					if (isVaild(i, j+5)) { // 가장 오른쪽 뒤에 돌 확인
						if (input[i][j+5] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i, j+5)) {
					if (input[i][j+5] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		if (col == 5) {
			if (isVaild(i-1, j)) {
				if (input[i-1][j] != num) {
					if (isVaild(i+5, j)) {
						if (input[i+5][j] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i+5, j)) {
					if (input[i+5][j] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		if (dr == 5) {
			if (isVaild(i-1, j-1)) {
				if (input[i-1][j-1] != num) {
					if (isVaild(i+5, j+5)) {
						if (input[i+5][j+5] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i+5, j+5)) {
					if (input[i+5][j+5] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		if (ur == 5) {
			if (isVaild(i+1, j-1)) {
				if (input[i+1][j-1] != num) {
					if (isVaild(i-5, j+5)) {
						if (input[i-5][j+5] != num) 
							output(i, j, num);
					}
					else {
						output(i, j, num);
					}
				}
			}
			else {
				if (isVaild(i-5, j+5)) {
					if (input[i-5][j+5] != num)
						output(i, j, num);
				}
				else {
					output(i, j, num);
				}
			}
		}
		
		// 다시 초기화
		row = 1;
		col = 1;
		ur = 1;
		dr = 1;
	}
}
