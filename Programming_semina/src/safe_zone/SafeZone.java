package safe_zone;


public class SafeZone {
	static int N = 5;
	static int[][] arr = {
			{6, 8, 2, 6, 2},
			{3, 2, 3, 4, 6},
			{6, 7, 3, 3, 2},
			{7, 2, 5, 3, 6},
			{8, 9, 5, 2, 7}
	};
	static int[][] tmp = new int[N][N];
	static boolean[][] visited = new boolean[N][N];
	static int cnt = 0;  // 안전 영역 개수
	static int rain = 0; // 비 높이
	
	public static void main(String[] args) {
		// 최대 지역 높이 구하기
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				if (rain < arr[i][j]) {
					rain = arr[i][j];
				}
			}
		}
		
		//System.out.println(rain);
		
		rain = 4; // 비 높이가 4라고 가정
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				if (arr[i][j] <= rain) {
					tmp[i][j] = 1;
				}
			}
		}
		//print(tmp);
		
		dfs(0, 0);
		
		System.out.println(cnt);
	}
	
	static void print(int[][] arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				// 위
				if (y > 0 && tmp[y-1][x] == 0 && visited[y-1][x] == false) {
					visited[y-1][x] = true;
					dfs(y-1, x);
				}
				// 오른쪽
				if (x < N-1 && tmp[y][x+1] == 0 && visited[y][x+1] == false) {
					visited[y][x+1] = true;
					dfs(y, x+1);
				}
				// 아래
				if (y < N-1 && tmp[y+1][x] == 0 && visited[y+1][x] == false) {
					visited[y+1][x] = true;
					dfs(y+1, x);
				}
				// 왼
				if (x > 0 && tmp[y][x-1] == 0 && visited[y][x-1] == false) {
					visited[y][x-1] = true;
					dfs(y, x-1);
				}
			}	
		}
		cnt++;
	}
}
