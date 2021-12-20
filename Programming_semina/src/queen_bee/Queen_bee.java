package queen_bee;

public class Queen_bee {
	static int M = 4;  // 격자칸 크기
	static int N = 2;  // 날짜 수
	static int[][] map = new int[M][M];
	static int[][] num_arr = {
			{2, 3, 2},
			{0, 6, 1}
	};
//	static int[][] num_arr = {
//			{1, 1, 1},
//			{0, 3, 0},
//			{0, 0, 3}
//	};
	static int[][] num_arr2 = new int[N][(M*2)-1];  // 애벌레가 날마다 커지는 정도 저장
	
	public static void bee_map() {	
		int[][] pre_map = new int[M][M];  // 변하기 전 맵 저장
		int[][] next_map = new int[M][M]; // 변한 후 맵 저장
		
		for (int i=0;i<M;i++) {
			for (int j=0;j<M;j++) {
				pre_map[i][j] = map[i][j];
				next_map[i][j] = map[i][j];
			}
		}
		
		for (int i=0;i<N;i++) {
			int index = 0;
			int num = 0;
			
			// 가장 윗쪽 줄, 윗 줄 증가량 저장
			for (int j=0;j<num_arr[i].length;j++) {
				if (num_arr[i][j] != 0) {
					for (int k=0;k<num_arr[i][j];k++) {
						num_arr2[i][index++] = num;
					}
				}
				num++;
			}

			// 가장 왼쪽 줄, 윗 줄 증가
			index = 0;
			for (int j=M-1;j>=0;j--) {
				next_map[j][0] += num_arr2[i][index++];
			}
			for (int j=1;j<M;j++) {
				next_map[0][j] += num_arr2[i][index++];
			}
			
			map = plus_bee(pre_map, next_map);  // (1,1)부터 애벌레 증가
			
//			System.out.println("[ " + (i+1) + "번째 날" + "  ]");
//			print();
		}
		
	}
	
	public static int[][] plus_bee(int pre_map[][], int next_map[][]) {
		for (int i=1;i<M;i++) {
			for (int j=1;j<M;j++) {
				int L = next_map[i][j-1] - pre_map[i][j-1];  // 왼쪽
				int D = next_map[i-1][j-1] - pre_map[i-1][j-1];  // 왼쪽 위
				int U = next_map[i-1][j] - pre_map[i-1][j];  // 위
				
				// 세 개의 숫자 중 가장 큰 증가량 고르기
				int value = (L > D)? L : D;
				int max = (U > value)? U : value;
				
				next_map[i][j] = pre_map[i][j] + max;
			}
		}
		return next_map;
	}
	
	public static void print() {
		for (int i=0;i<M;i++) {
			for (int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// 처음 초기화
		for (int i=0;i<M;i++) {
			for (int j=0;j<M;j++) {
				map[i][j] = 1;
			}
		}
		System.out.println("[ 처음 맵  ]");
		print();
		
		bee_map();
		
		System.out.println("[ 결과  ]");
		print();
	}
}
