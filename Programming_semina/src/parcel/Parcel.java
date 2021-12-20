package parcel;

import java.util.Arrays;
import java.util.Comparator;

public class Parcel {
//	static int N = 4;	// 마을 수
//	static int C = 40;	// 트럭의 용량
//	static int M = 6;	// 보내는 박스 정보의 개수
//	static int M_arr[][] = {
//			{3, 4, 20},
//			{1, 2, 10},
//			{1, 3, 20},
//			{1, 4, 30},
//			{2, 3, 10},
//			{2, 4, 20}
//	};
	
	static int N = 6;	// 마을 수
	static int C = 60;	// 트럭의 용량
	static int M = 5;	// 보내는 박스 정보의 개수
//	static int M_arr[][] = {
//			{1, 2, 30},
//			{2, 5, 70},
//			{5, 6, 60},
//			{3, 4, 40},
//			{1, 6, 40}
//	};
	static int M_arr[][] = {
			{1, 6, 60},
			{1, 2, 10},
			{2, 3, 10},
			{3, 4, 10},
			{4, 5, 10}
	};
	
	
	public static void main(String[] args) {
		
		// 받는 마을 기준으로 정렬 (오름차순)
		Arrays.sort(M_arr, new Comparator<int[]>() {
	         public int compare(int[] o1, int[] o2) {
	            if (o1[1] == o2[1])
	               return o1[0] - o2[0];
	            else
	               return o1[1] - o2[1];
	         }
         });
		
		for (int i=0;i<M;i++) {
			for (int j=0;j<M_arr[0].length;j++) {
				System.out.print(M_arr[i][j] + " ");
			}
			System.out.println();
		}
		
		int box[] = new int[N+1];
		int max, possible, total = 0;
		for (int i = 0; i < M; i++) {
			int from = M_arr[i][0];	// 보내는 곳
			int to = M_arr[i][1];	// 받는 곳
			int cnt = M_arr[i][2];	// 택배 수
			max = 0;
			
			// 이미 실린 박스의 최댓값
			for (int j = from; j < to; j++) {
				max = Math.max(max, box[j]);
//				System.out.println("box : " + box[j]);
			}
//			System.out.println("===");
			
			// 실을 수 있는 박스 수
			possible = Math.min(C-max, cnt);
			total += possible;
			
			for (int j = from; j < to; j++) {
				box[j] += possible;
			}
		}
		// 배송할 수 있는 최대 박스 수
		System.out.println(total+box[N]);
		
	}

}
