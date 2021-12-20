package candidate;

public class Candidate {
	static int p_num = 3;
	static int r_num = 9;
	static int[] arr = {2,1,4,3,5,6,2,7,2};
	static int[] p_arr = new int[p_num];	// ����Ʋ �迭 ����
	static int[] cnt = new int[p_num];	// �ð� ī��Ʈ �迭
	static int[] r_cnt = new int[p_num];	// ��õ���� Ƚ��
	
	public static boolean check(int candidate) {
		for (int i=0;i<p_num;i++) {
			if (p_arr[i] == candidate) {	// ������ true, �ƴϸ� false ��ȯ
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
				min = r_cnt[0];		// �ּҰ� ���ϱ�
			}
		}
		
		for (int i=0;i<p_num;i++) {	// �ּҰ� �ߺ��Ǵ��� Ȯ��
			if (min == r_cnt[i]) {
				count++;
			}
		}
		
		// ��õ Ƚ���� ���� ���� �л��� 1���� ���
		if (count == 1) {
			// �ش� �л� �ε��� ��ȯ
			for (int i=0;i<p_num;i++) {
				if (cnt[i] == min) {
					index = i;
				}
			}
		} 
		else { // ��õȽ���� ���� ���� �л��� 2�� �̻��� ���
			// �Խõ� �� ���� ������ �л� ����
			index = max_index();
		}
		return index;
		
	}
	
	// ���� ������ �л��� �ε��� ��ȯ
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
	
	// �ߺ��ĺ��� �ε��� �����ִ� �Լ�
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
		
		// ����Ʋ ������ŭ �ϴ� �ĺ��� �ֱ�
		for(int i=0;i<p_num;i++) {
			p_arr[i] = arr[i];
			
			for (int j=0;j<=i;j++) {
				cnt[j]++;	// ��ü ī��Ʈ +1
			}
			
			r_cnt[i]++;
		}
		
		for(int i=p_num;i<r_num;i++) {
			if (check(arr[i]) == true) {	// ��õ���� �л��� �ɷ�������
				r_cnt[index(arr[i])]++;	// �ش� �ĺ��� ��õȽ�� �ø���
				for (int j=0;j<p_num;j++) {
					cnt[j]++;	// ��ü ī��Ʈ +1
				}
			}
			else {	// ��õ���� �л��� ����Ʋ�� ������
				int index = r_min();	// ������ �л��� �ε���
				p_arr[index] = arr[i];
				cnt[index] = 0;
				r_cnt[index] = 1;
				
				for (int j=0;j<p_num;j++) {
					cnt[j]++;	// ��ü ī��Ʈ +1
				}
			}
			
		}
		
		// ����Ʋ ���
		print();
	}
}
