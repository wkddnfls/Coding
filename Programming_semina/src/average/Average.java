package average;

import java.util.*;

public class Average {
	// =====절사평균=====
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
	
	// =====보정평균=====
	public static double bojung(double[] score, int num) {
		double avg = 0.0;
		double sum = 0.0;
		double result = 0.0;
		
		// 앞에서 num개를 가장 가까운 것으로 교체
		for (int i=0;i<num;i++) {
			score[i] = score[num];
		}
		// 뒤에서 num개를 가장 가까운 것으로 교체
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
		
		System.out.print("점수의 개수>>");
		int N = sc.nextInt(); 
		System.out.print("양쪽에서 제외하는 개수>>");
		int K = sc.nextInt(); 
		
		double[] score = new double[N];
		System.out.println("입력 값>>");
		for (int i=0;i<N;i++) {
			score[i] = sc.nextDouble();
		}
		Arrays.sort(score);
		
		System.out.println("절사평균 : " + julsa(score, K));
		System.out.println("보정평균 : " + bojung(score, K));
	}
}
