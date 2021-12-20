package maze_2;

import java.util.*;

public class MazeMain {
	static int[][] maze = {
			{1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,0,1,0,1,1},
			{1,0,1,0,1,0,1,1},
			{1,0,0,1,1,0,0,1},
			{1,1,0,0,0,1,1,1},
			{1,0,0,1,0,0,0,1},
			{1,1,1,1,1,1,1,1}};
	
	static int size_y = maze.length;
	static int size_x = maze[0].length;

	static int start_x = 1;
	static int start_y = 1;
	static int end_x = size_x-2;
	static int end_y  = size_y-2;
	
	
	public static void Maze() {
	}
	
	/* 길 찾기 */
	public static boolean findMaze(int x, int y) {
		/* 갈 수 있는 길이 아닌 경우! */
		if (maze[y][x] != 0) {
			return false;
		}
		/* 출구의 경우 */
		else if (x == end_x && y == end_y) {
			maze[y][x] = 3; // 3은 출구까지의 경로
			print(x,y);
			return true;
		}
		/* 지나갈 수 있는 경우(0인 경우) */
		else {
			maze[y][x] = 3; // 지나가는 길 3으로 표시
			print(x,y);
			if (findMaze(x, y-1) || findMaze(x+1, y) || findMaze(x, y+1) || findMaze(x-1, y)) {
				// 위 -> 오른쪽 -> 아래 -> 왼쪽 
				return true;
			}
			maze[y][x] = 2; // 4방향이 모두 막혀있으면 2
			return false;
		}
	}

	public static void print(int x, int y) {
		System.out.println();
		System.out.println();
		System.out.println();
		for (int i = 0; i < size_y; i++) {
			for (int j = 0; j < size_x; j++) {
				if (i==y && j==x) {
					System.out.print("* ");
				} else {
					System.out.print(maze[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		Scanner in = new Scanner(System.in); in.nextLine();
	}

	public static void print(Mouse m) {
		System.out.println();
		System.out.println();
		System.out.println();
		for (int i = 0; i < size_y; i++) {
			for (int j = 0; j < size_x; j++) {
				if (i==m.y && j==m.x) {
					System.out.print("* ");
				} else {
					System.out.print(maze[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		Scanner in = new Scanner(System.in); in.nextLine();
	}
	
	public static void main(String[] args) {
		
//		Maze();
//		findMaze(start_x, start_y);
		Mouse m = new Mouse(maze, start_x, start_y);
		Stack<Integer> stack = new Stack<>();
		while (!(m.x == end_x && m.y == end_y)) {
			print(m);
			m.findNext();
		}
	}
}
