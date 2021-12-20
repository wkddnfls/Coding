package average;

import java.util.*;

public class Average {
	// =====�������=====
	public static double julsa(double[] score, int num) {
		double avg = 0.0;
		double sum = 0.0;
		double result = 0.0;
		
		for (int i=num;i<score.length-num;i++) {
			sum += score[i];
		}
		avg = sum / (score.length-(2*num));	
		result = Math.round(avg*100)/100.0;
		return result;
	}
	
	// =====�������=====
	public static double bojung(double[] score, int num) {
		double avg = 0.0;
		double sum = 0.0;
		double result = 0.0;
		
		// �տ��� num���� ���� ����� ������ ��ü
		for (int i=0;i<num;i++) {
			score[i] = score[num];
		}
		// �ڿ��� num���� ���� ����� ������ ��ü
		for (int i=score.length-1;i>=score.length-num;i--) {
			score[i] = score[score.length-num-1];
		}
		
		for (int i=0;i<score.length;i++) {
			sum += score[i];
		}
		avg = sum / score.length;
		result = Math.round(avg*100)/100.0;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ ����>>");
		int N = sc.nextInt(); 
		System.out.print("���ʿ��� �����ϴ� ����>>");
		int K = sc.nextInt(); 
		
		double[] score = new double[N];
		System.out.println("�Է� ��>>");
		for (int i=0;i<N;i++) {
			score[i] = sc.nextDouble();
		}
		Arrays.sort(score);
		
		System.out.println("������� : " + julsa(score, K));
		System.out.println("������� : " + bojung(score, K));
	}
}
