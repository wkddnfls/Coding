package school_bus;

import java.util.Arrays;
import java.util.Comparator;

public class SchoolBus {
	static int N = 3;	// 아파트 단지의 수
	static int K = 4; 	// 통학버스의 정원
	static int S = 4; 	// 학교의 위치
	static int[][] student = {	// (아파트 단지 위치, 사는 학생 수)
			{0, 1},
			{2, 2},
			{5, 1}
	};
	static int min = 0;	// 출력값 (최소 이동 거리)
	
	public static void main(String[] args) {
		
		// 학교랑 가장 거리가 먼 아파트순으로 정렬
		Arrays.sort(student, new Comparator<int[]>() {
			public int compare(int[] t1, int[] t2) {
				return Math.abs(t2[0]-S) - Math.abs(t1[0]-S);
			}
		});
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<2;j++) {
				System.out.print(student[i][j] + " ");
			}
			System.out.println();
		}
		
		int left = K;	// 버스에 남은 자리
		int num = 0;	// 지나간 아파트 수
		while (num < student.length) {
			if (left > student[num][1]) {
				left -= student[num][1];
				student[num][1] = 0;
				num++;
			} else if (left < student[num][1]) {
				student[num][1] -= left;
				left = 0;
			} else {
				student[num][1] = 0;
				left = 0;
				num++;
			}
			
		}
		
		for (int i=0;i<N;i++) {
//			if (student[i][0] < S) {	// 학교 왼쪽
//				min += S - student[i][0];
//				left -= student[i][1];
//			} else {
//				min += student[i][0] - S;
//				left -= student[i][1];
//			}
		}
		
		System.out.println("최소 이동 거리 : " + min);
	}
}
