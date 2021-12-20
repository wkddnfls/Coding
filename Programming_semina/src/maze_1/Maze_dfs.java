package maze_1;


class DFS {

	public int size = 6; 
	public int min_len = size * size; // 최단 경로 길이
	public int end_y = size, end_x = size; // 도착지점 y,x 좌표
	public int count = 0;

	static int[][] maze = {
			{1,1,1,1,1,1,1,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,0,1,1,1,0,1},
			{1,1,0,0,1,0,0,1},
			{1,1,1,0,1,0,1,1},
			{1,1,1,0,0,0,0,1},
			{1,1,1,1,1,1,1,1}
	};
	public void findMaze(int y, int x, int len) {

		// 출구인 경우
		if (y == end_y && x == end_x) {

			count++;
			System.out.println("\n[ " + count + "차 미로 ]\n");

			maze[y][x] = 3;
			print();

			// 최단경로 길이
			if (min_len > len) {
				min_len = len;
			}

			maze[y][x] = 0;
			return;
		}

		maze[y][x] = 3;

		// 위
		if (y > 1 && maze[y - 1][x] != 3 && maze[y - 1][x] != 1) {
			findMaze(y - 1, x, len + 1);
		}
		// 오른쪽으로 이동
		if (x < size && maze[y][x + 1] != 3 && maze[y][x + 1] != 1) {
			findMaze(y, x + 1, len + 1);
		}
		// 아래로 이동
		if (y < size && maze[y + 1][x] != 3 && maze[y + 1][x] != 1) {
			findMaze(y + 1, x, len + 1);
		}
		// 왼쪽으로 이동
		if (x > 1 && maze[y][x - 1] != 3 && maze[y][x - 1] != 1) {
			findMaze(y, x - 1, len + 1);
		}

		maze[y][x] = 0;
		return;
	}

	public void print() {
		for (int i = 0; i < size+2; i++) {
			for (int j = 0; j < size+2; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

public class Maze_dfs {
	public static void main(String[] args) {
		DFS dfs = new DFS();

		System.out.println("[ 초기 미로 ] ");
		dfs.print();
		dfs.findMaze(1, 1, 1);

		// 최단 경로값 출력
		System.out.println("\n\n최단경로의 길이 :  " + dfs.min_len);
		System.out.println("갈 수 있는 경우의 수 :  " + dfs.count);
	}
}