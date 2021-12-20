package maze_1;

import java.util.*;

class BFS {
	
	public int size = 6; 
	public int end_y = size, end_x = size; // �������� y,x ��ǥ
	public int[][] len = new int[size+2][size+2];  // ����� ����
	public boolean visit[][] = new boolean[size+2][size+2];  // �湮ǥ�� �迭
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
	
	
	public void findMaze(int y, int x) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(x); qy.add(y);
		len[1][1] = 1;
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			x = qx.poll();   y = qy.poll();
			visit[y][x] = true;
			
			// ��
			if (y > 1 && visit[y - 1][x] != true && maze[y - 1][x] != 1) {
				qx.add(x);  qy.add(y-1);
				visit[y-1][x] = true;  
				len[y-1][x] = len[y][x]+1;
			}
			// ������
			if (x < size && visit[y][x+1] != true && maze[y][x+1] != 1) {
				qx.add(x+1);  qy.add(y);
				visit[y][x+1] = true; 
				len[y][x+1] = len[y][x]+1;
			}
			// �Ʒ�
			if (y < size && visit[y+1][x] != true && maze[y+1][x] != 1) {
				qx.add(x);  qy.add(y+1);
				visit[y+1][x] = true;
				len[y+1][x] = len[y][x]+1;
			}
			// ����
			if (x > 1 && visit[y][x-1] != true && maze[y][x-1] != 1) {
				qx.add(x-1);  qy.add(y);
				visit[y][x-1] = true; 
				len[y][x-1] = len[y][x]+1;
			}
		}
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
	
	public void bfs_print(int y, int x) {
		
		// �Ա��� �ǵ��ƿ� ���
		if (y == 1 && x == 1) {
			maze[size][size] = 3;
			print();
			return;
		}
		
		// ��
		if (len[y][x] == len[y-1][x]+1) {
			maze[y-1][x] = 3;
			bfs_print(y-1, x);
		}
		// ������
		if (len[y][x] == len[y][x+1]+1) {
			maze[y][x+1] = 3;
			bfs_print(y, x+1);
		}
		// �Ʒ�
		if (len[y][x] == len[y+1][x]+1) {
			maze[y+1][x] = 3;
			bfs_print(y+1, x);
		}
		// ����
		if (len[y][x] == len[y][x-1]+1) {
			maze[y][x-1] = 3;
			bfs_print(y, x-1);
		}
		return;
	}
	
}

public class Maze_bfs {
	public static void main(String[] args) {
		BFS bfs = new BFS();
		System.out.println("[ �ʱ� �̷� ] ");
		bfs.print();
		bfs.findMaze(1, 1);
		System.out.println("[ ���� �̷� ] ");
		bfs.bfs_print(bfs.size, bfs.size);

		// �ִ� ��ΰ� ���
		System.out.println("����� ���� :  " + bfs.len[bfs.size][bfs.size]);
	}
}
