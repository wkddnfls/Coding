package maze_2;

import java.util.*;


public class Mouse {
	public int x;
	public int y;
	
	public int[][] maze;
	
//	public Stack<Integer> stack_x = new Stack<>();
//	public Stack<Integer> stack_y = new Stack<>();
	public Stack<Integer> stack = new Stack<>();
	
	public Mouse() {
		this(new int[5][5],1,1);
	}
	
	public Mouse(int[][] map, int x, int y) {
		this.x = x;
		this.y = y;
		this.maze = map;
	}
	
	public boolean isUpAvailable() {
		if (y-1 >= 0 && maze[y-1][x] == 0)
			return true;
		return false;
	}

	public boolean isDownAvailable() {
		if (y+1 < maze.length && maze[y+1][x] == 0)
			return true;
		return false;
	}

	public boolean isLeftAvailable() {
		if (x-1 >= 0 && maze[y][x-1] == 0)
			return true;
		return false;
	}

	public boolean isRightAvailable() {
		if (x+1 < maze[y].length && maze[y][x+1] == 0)
			return true;
		return false;
	}
	
	public Mouse findNext() {
		if (isUpAvailable()) {
			maze[y][x] = 3;
			stack.push(maze[y][x]);
			y--;
			return this;
		}

		if (isRightAvailable()) {
			maze[y][x] = 3;
			stack.push(maze[y][x]);
			x++;
			return this;
		}
		
		
		if (isDownAvailable()) {
			maze[y][x] = 3;
			stack.push(maze[y][x]);
			y++;
			return this;
		}


		if (isLeftAvailable()) {
			maze[y][x] = 3;
			stack.push(maze[y][x]);
			x--;
			return this;
		}
		
		/* 지나오는 경로 */
		else if(maze[y-1][x] == 3) {
			maze[y][x] = 2;
			x = stack.peek().MAX_VALUE;
			y = stack.peek().byteValue();
			stack.pop();
		}
		else if(maze[y+1][x] == 3) {
			maze[y][x] = 2;
			x = stack.peek().MAX_VALUE;
			y = stack.peek().byteValue();
			stack.pop();
		}
		else if(maze[y][x-1] == 3) {
			maze[y][x] = 2;
			x = stack.peek().MAX_VALUE;
			y = stack.peek().byteValue();
			stack.pop();
		}
		else if(maze[y][x+1] == 3) {
			maze[y][x] = 2;
			x = stack.peek().MAX_VALUE;
			y = stack.peek().byteValue();
			stack.pop();
		}
		return this;
	}
}
