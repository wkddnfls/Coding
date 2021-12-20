package graph_paper;

import java.util.ArrayList;

public class Graph_paper {
	static int x = 10;  // �������� ���α���
	static int y = 12;  // �������� ���α���
	static int v = 14;  // ���������� �ϴ� �ٰ����� ������ ����
	
	static int[][] vertex = { 
			{9, 6},
			{5, 6}, 
			{5, 8},
			{10, 8},
			{10, 10},
			{1, 10}, 
			{1, 4},
			{0, 4},
			{0, 2},
			{5, 2},
			{5, 0},
			{7, 0},
			{7, 3},
			{9, 3}
	};
//	static int[][] vertex = {  
//			{1, 3},
//			{1, 2}, 
//			{5, 2},
//			{5, 5},
//			{3, 5},
//			{3, 3}
//	};
	
	// ���� ���� ���� ���� �Լ�
	public static int count() {
		int count = 0; 
		int num = 0; 
		
		for (int i=0;i<v;i++) {		
			if (vertex[i][0] == 0 || vertex[i][1] == 0 || vertex[i][0] == x || vertex[i][1] == y) {
				count++;
				if (count == 2) {  
					num++;
					count=0;
				}
			}
		}
		return num;
	}
	
	// �ٰ��� �ѷ����� ���� �Լ�
	public static int graph(int x1, int y1, int x2, int y2) {
		int len = 0;
		if (x1 == x2) {
			len = (y1 > y2) ? y1-y2 : y2-y1;
		}
		else if (y1 == y2) {
			len = (x1 > x2) ? x1-x2 : x2-x1;
		}
		return len;
	}
	
	// ������ ������ ��
	public static int findGraph(int num) {
		ArrayList<Integer> ax = new ArrayList<Integer>();
		ArrayList<Integer> ay = new ArrayList<Integer>();
		int start = 0;  
		int end = 0;    
		int len_arr[] = new int[num]; // �������� �ѷ����� ����
		int max_length = 0;
		int index = 0;
		
		for (int i=0;i<v;i++) {		
			if (vertex[i][0] == 0 || vertex[i][1] == 0 || vertex[i][0] == x || vertex[i][1] == y) {
				ax.add(vertex[i][0]); ay.add(vertex[i][1]);
			}
		}
		
//		for(int i=0;i<ax.size();i++) {
//			System.out.println(ax.get(i) + ", " + ay.get(i));
//		}
		
		for (int i=1;i<v;i++) {
			for (int j=1;j<ax.size();j++) {
				if ((vertex[i-1][0] == ax.get(j-1)) && (vertex[i-1][1] == ay.get(j-1))) {
					start = i-1;
					for (int k=1;k<v;k++) {
						if ((vertex[k-1][0] == ax.get(j)) && (vertex[k-1][1] == ay.get(j)))
							end = k-1;
					}
					if (end-start-1 > 0) {
						len_arr[index] = find_len(start, end);
						index++;
					}
				}
			}
		}
		
		// �� ������ ���� start, ù ��° ���� end�� ��� 
		if (len_arr[num-1] == 0) {  
			for (int i=0;i<v;i++) {
				if (vertex[i][0] == ax.get(ax.size()-1) && vertex[i][1] == ay.get(ay.size()-1))
					start = i;
				if (vertex[i][0] == ax.get(0) && vertex[i][1] == ay.get(0))
					end = i;
			}
			len_arr[num-1] = find_len(start, end);
		}
		
		// len_arr�ȿ��� �ִ���� ��
		for (int i=0;i<len_arr.length;i++) {
			System.out.println("���� " + (i+1) + "�� �ѷ� ���� : " + len_arr[i]);
			if (max_length < len_arr[i])
				max_length = len_arr[i];
		}
		return max_length;
	}
	
	// ���� �ѷ� ���
	public static int find_len(int start, int end) {
		int len = 0;
		if (start < end) {
			for (int i=start;i<end;i++) {
				len += graph(vertex[i][0], vertex[i][1], vertex[i+1][0], vertex[i+1][1]);  // �ٰ����� ��ġ�� ����
			}
		}
		else if (start > end) {
			for (int i=start;i<v-1;i++) {
				len += graph(vertex[i][0], vertex[i][1], vertex[i+1][0], vertex[i+1][1]);  // �ٰ����� ��ġ�� ����
			}
			
			len += graph(vertex[v-1][0], vertex[v-1][1], vertex[0][0], vertex[0][1]);  // �� ������ ���� ù��° �� ����
			
			for (int i=0;i<end;i++) {
				len += graph(vertex[i][0], vertex[i][1], vertex[i+1][0], vertex[i+1][1]);  // �ٰ����� ��ġ�� ����
			}
		}
		
		// start���� ������ ������ ��� (��� ���� �ݽð����)
		if (vertex[start][0] == x) {
			
			if (vertex[end][0] == x)  // end���� ������ ������ ���
				len += vertex[end][1] - vertex[start][1];
			else if (vertex[end][1] == y)  // end���� ���� ������ ���
				len += (y-vertex[start][1]) + (x-vertex[end][0]);
			else if (vertex[end][0] == 0)  // end���� ���� ������ ���
				len += (y-vertex[start][1]) + x + (y-vertex[end][1]);
			else if (vertex[end][1] == 0)  // end���� �Ʒ� ������ ���
				len += (y-vertex[start][1]) + x + y + vertex[end][0];
		}
		// start���� ���� ������ ���
		else if (vertex[start][1] == y) {  // end�� ��, ����, �Ʒ�, ������ ��
			if (vertex[end][1] == y)
				len += vertex[start][0] - vertex[end][0];
			else if (vertex[end][0] == 0)
				len += vertex[start][0] + (y - vertex[end][1]);
			else if (vertex[end][1] == 0)
				len += vertex[start][0] + y + vertex[end][0];
			else if (vertex[end][0] == x)
				len += vertex[start][0] + y + x + vertex[end][1];
		}
		// start���� ���� ������ ���
		else if (vertex[start][0] == 0) {  // end�� ��, �Ʒ�, ������, �� ��
			if (vertex[end][0] == 0)
				len += vertex[start][1] - vertex[end][1];
			else if (vertex[end][1] == 0)
				len += vertex[start][1] + vertex[end][0];
			else if (vertex[end][0] == x)
				len += vertex[start][1] + x + vertex[end][1];
			else if (vertex[end][1] == y)
				len += vertex[start][1] + x + y + (y - vertex[end][1]);
		}
		// start���� �Ʒ��� ������ ���
		else if (vertex[start][1] == 0) {  // end�� �Ʒ�, ������, ��, ���� ��
			if (vertex[end][1] == 0)
				len += vertex[end][0] - vertex[start][0];
			else if (vertex[end][0] == x)
				len += (x - vertex[start][0]) + vertex[end][1];
			else if (vertex[end][1] == y)
				len += (x - vertex[start][0]) + y + (x - vertex[end][0]);
			else if (vertex[end][0] == 0)
				len += (x - vertex[start][0]) + y + x + (y - vertex[end][0]);
		}
		return len;
	}
	
	public static void main(String[] args) {
		int len = 0;
		int num = count();
		
		if (num == 0) {  // �����̿� ������ �ո����
			System.out.println("���� ������ ���� : " + (num +1));
			
			for (int i=1;i<v;i++) {
				len += graph(vertex[i-1][0], vertex[i-1][1], vertex[i][0], vertex[i][1]);
			}
			len += graph(vertex[v-1][0], vertex[v-1][1], vertex[0][0], vertex[0][1]); 
			len += (x+y)*2;
			System.out.println("�ѷ��� ���� : " + len);
		}
		else {  
			System.out.println("���� ������ ���� : " + num);
			System.out.println("���� �� �ѷ��� ���� : " + findGraph(num));
		}
	}
}