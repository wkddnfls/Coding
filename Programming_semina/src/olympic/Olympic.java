package olympic;

import java.util.*;

public class Olympic {
	public static void print(int[][] arr) {
        for( int i = 0; i < arr.length; i++ ) {
            for( int j = 0; j < arr[i].length; j++ )
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ ��>>");
		int N = sc.nextInt(); 
		System.out.print("���� ��ȣ>>");
		int K = sc.nextInt(); 
		
		int[][] country_score = new int[N][N];  // (������ȣ,��,��,��)
		int answer = 0;
		int rank = 1;
		
		System.out.println("�Է� ��>>");
		for (int i=0;i<N;i++) {
			country_score[i][0] = sc.nextInt();
			country_score[i][1] = sc.nextInt();
			country_score[i][2] = sc.nextInt();
			country_score[i][3] = sc.nextInt();
		}
		Arrays.sort(country_score, Comparator.comparingInt(arr1->arr1[0]));   // ������ȣ�� �������� ����
		//print(country_score);
		
		for (int i=0;i<N;i++) {
			if (country_score[i][0] == K) {
				answer = i;
			}
		}
		
		for (int i=0;i<N;i++) {  
			if (country_score[i][1] > country_score[answer][1]) {
				rank++;
			}
			else if ((country_score[i][1] == country_score[answer][1]) && (country_score[i][2] > country_score[answer][2])) {
				rank++;
			}
			else if ((country_score[i][1] == country_score[answer][1]) && (country_score[i][2] == country_score[answer][2]) && (country_score[i][3] > country_score[answer][3])) {
				rank++;
			}
		}
		System.out.print("���� " + K + "�� ���� : " + rank);
	}
}
