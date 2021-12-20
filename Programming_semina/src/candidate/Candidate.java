package candidate;

public class Candidate {
	static int p_num = 3;
	static int r_num = 9;
	static int[] arr = {2,1,4,3,5,6,2,7,2};
	static int[] p_arr = new int[p_num];	// 사진틀 배열 생성
	static int[] cnt = new int[p_num];	// 시간 카운트 배열
	static int[] r_cnt = new int[p_num];	// 추천받은 횟수
	
	public static boolean check(int candidate) {
		for (int i=0;i<p_num;i++) {
			if (p_arr[i] == candidate) {	// 있으면 true, 아니면 false 반환
				return true;
			}
		}
		return false;
	}
	
	public static int r_min() {
		int min = r_cnt[0];
		int count = 0;
		int index = 0;
		
		for (int i=0;i<p_num;i++) {
			if (min > r_cnt[0]) {
				min = r_cnt[0];		// 최소값 구하기
			}
		}
		
		for (int i=0;i<p_num;i++) {	// 최소값 중복되는지 확인
			if (min == r_cnt[i]) {
				count++;
			}
		}
		
		// 추천 횟수가 가장 적은 학생이 1명일 경우
		if (count == 1) {
			// 해당 학생 인덱스 반환
			for (int i=0;i<p_num;i++) {
				if (cnt[i] == min) {
					index = i;
				}
			}
		} 
		else { // 추천횟수가 가장 적은 학생이 2명 이상일 경우
			// 게시된 지 가장 오래된 학생 삭제
			index = max_index();
		}
		return index;
		
	}
	
	// 가장 오래된 학생의 인덱스 반환
	public static int max_index() {
		int max = cnt[0];
		int index = 0;
		
		for (int i=0;i<p_num;i++) {
			if (max < cnt[i]) {
				max = cnt[i];
			}
		}
		
		for (int i=0;i<p_num;i++) {
			if (cnt[i] == max) {
				index = i;
			}
		}
		return index;
	}
	
	// 중복후보자 인덱스 구해주는 함수
	public static int index(int candidate) {
		int index = 0;
		
		for(int i=0;i<p_num;i++) {
			if (p_arr[i] == candidate) {
				index = i;
			}
		}
		return index;
	}
	
	public static void print() {
		for (int i=0;i<p_num;i++) {
			System.out.print(p_arr[i] + " ");
		}
	}
	
	public static void print_cnt() {
		for (int i=0;i<p_num;i++) {
			System.out.print(cnt[i] + " ");
		}
	}
	
	public static void print_r() {
		for (int i=0;i<p_num;i++) {
			System.out.print(r_cnt[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		// 사진틀 개수만큼 일단 후보자 넣기
		for(int i=0;i<p_num;i++) {
			p_arr[i] = arr[i];
			
			for (int j=0;j<=i;j++) {
				cnt[j]++;	// 전체 카운트 +1
			}
			
			r_cnt[i]++;
		}
		
		for(int i=p_num;i<r_num;i++) {
			if (check(arr[i]) == true) {	// 추천받은 학생이 걸려있으면
				r_cnt[index(arr[i])]++;	// 해당 후보자 추천횟수 늘리고
				for (int j=0;j<p_num;j++) {
					cnt[j]++;	// 전체 카운트 +1
				}
			}
			else {	// 추천받은 학생이 사진틀에 없으면
				int index = r_min();	// 삭제할 학생의 인덱스
				p_arr[index] = arr[i];
				cnt[index] = 0;
				r_cnt[index] = 1;
				
				for (int j=0;j<p_num;j++) {
					cnt[j]++;	// 전체 카운트 +1
				}
			}
			
		}
		
		// 사진틀 출력
		print();
	}
}
