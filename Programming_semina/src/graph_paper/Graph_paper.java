package graph_paper;

import java.util.ArrayList;

public class Graph_paper {
	static int x = 10;  // 모눈종이의 가로길이
	static int y = 12;  // 모눈종이의 세로길이
	static int v = 14;  // 오려내고자 하는 다각형의 꼭지점 개수
	
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
	
	// 남은 조각 개수 세는 함수
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
	
	// 다각형 둘레길이 세는 함수
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
	
	// 조각이 생겼을 때
	public static int findGraph(int num) {
		ArrayList<Integer> ax = new ArrayList<Integer>();
		ArrayList<Integer> ay = new ArrayList<Integer>();
		int start = 0;  
		int end = 0;    
		int len_arr[] = new int[num]; // 조각들의 둘레길이 저장
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
		
		// 맨 마지막 점이 start, 첫 번째 점이 end인 경우 
		if (len_arr[num-1] == 0) {  
			for (int i=0;i<v;i++) {
				if (vertex[i][0] == ax.get(ax.size()-1) && vertex[i][1] == ay.get(ay.size()-1))
					start = i;
				if (vertex[i][0] == ax.get(0) && vertex[i][1] == ay.get(0))
					end = i;
			}
			len_arr[num-1] = find_len(start, end);
		}
		
		// len_arr안에서 최대길이 비교
		for (int i=0;i<len_arr.length;i++) {
			System.out.println("조각 " + (i+1) + "의 둘레 길이 : " + len_arr[i]);
			if (max_length < len_arr[i])
				max_length = len_arr[i];
		}
		return max_length;
	}
	
	// 조각 둘레 재기
	public static int find_len(int start, int end) {
		int len = 0;
		if (start < end) {
			for (int i=start;i<end;i++) {
				len += graph(vertex[i][0], vertex[i][1], vertex[i+1][0], vertex[i+1][1]);  // 다각형과 겹치는 길이
			}
		}
		else if (start > end) {
			for (int i=start;i<v-1;i++) {
				len += graph(vertex[i][0], vertex[i][1], vertex[i+1][0], vertex[i+1][1]);  // 다각형과 겹치는 길이
			}
			
			len += graph(vertex[v-1][0], vertex[v-1][1], vertex[0][0], vertex[0][1]);  // 맨 마지막 점과 첫번째 점 길이
			
			for (int i=0;i<end;i++) {
				len += graph(vertex[i][0], vertex[i][1], vertex[i+1][0], vertex[i+1][1]);  // 다각형과 겹치는 길이
			}
		}
		
		// start점이 오른쪽 벽면인 경우 (모든 점은 반시계방향)
		if (vertex[start][0] == x) {
			
			if (vertex[end][0] == x)  // end점이 오른쪽 벽면일 경우
				len += vertex[end][1] - vertex[start][1];
			else if (vertex[end][1] == y)  // end점이 위쪽 벽면인 경우
				len += (y-vertex[start][1]) + (x-vertex[end][0]);
			else if (vertex[end][0] == 0)  // end점이 왼쪽 벽면인 경우
				len += (y-vertex[start][1]) + x + (y-vertex[end][1]);
			else if (vertex[end][1] == 0)  // end점이 아래 벽면인 경우
				len += (y-vertex[start][1]) + x + y + vertex[end][0];
		}
		// start점이 위쪽 벽면인 경우
		else if (vertex[start][1] == y) {  // end점 위, 왼쪽, 아래, 오른쪽 순
			if (vertex[end][1] == y)
				len += vertex[start][0] - vertex[end][0];
			else if (vertex[end][0] == 0)
				len += vertex[start][0] + (y - vertex[end][1]);
			else if (vertex[end][1] == 0)
				len += vertex[start][0] + y + vertex[end][0];
			else if (vertex[end][0] == x)
				len += vertex[start][0] + y + x + vertex[end][1];
		}
		// start점이 왼쪽 벽면인 경우
		else if (vertex[start][0] == 0) {  // end점 왼, 아래, 오른쪽, 위 순
			if (vertex[end][0] == 0)
				len += vertex[start][1] - vertex[end][1];
			else if (vertex[end][1] == 0)
				len += vertex[start][1] + vertex[end][0];
			else if (vertex[end][0] == x)
				len += vertex[start][1] + x + vertex[end][1];
			else if (vertex[end][1] == y)
				len += vertex[start][1] + x + y + (y - vertex[end][1]);
		}
		// start점이 아래쪽 벽면인 경우
		else if (vertex[start][1] == 0) {  // end점 아래, 오른쪽, 위, 왼쪽 순
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
		
		if (num == 0) {  // 모눈종이에 구멍이 뚫린경우
			System.out.println("남은 조각의 개수 : " + (num +1));
			
			for (int i=1;i<v;i++) {
				len += graph(vertex[i-1][0], vertex[i-1][1], vertex[i][0], vertex[i][1]);
			}
			len += graph(vertex[v-1][0], vertex[v-1][1], vertex[0][0], vertex[0][1]); 
			len += (x+y)*2;
			System.out.println("둘레의 길이 : " + len);
		}
		else {  
			System.out.println("남은 조각의 개수 : " + num);
			System.out.println("가장 긴 둘레의 길이 : " + findGraph(num));
		}
	}
}