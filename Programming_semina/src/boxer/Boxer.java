package boxer;

import java.util.Arrays;
import java.util.Comparator;

public class Boxer {
	static public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        double[][] match_result = new double[weights.length][4];
        double[] win_rate = new double[weights.length];
        
        for (int i=0;i<weights.length;i++) {
        	int boxernumber = i+1;
        	int cnt = 0;  	// �� ��� ��
        	int win = 0;	// �̱� Ƚ��
        	int win_heavyboxer = 0;	// �ڱ⺸�� ���ſ� ������ �̱� Ƚ��
        	
        	
        	for (int j=0;j<weights.length;j++) {
        		char a = head2head[i].charAt(j);
        		
        		if (a != 'N') cnt++;
        		
        		if (a == 'W') {
        			win++;
        			if (weights[i] < weights[j]) win_heavyboxer++;
        		}
        	}
        	
        	//System.out.println("win : " + win + ", cnt : " + cnt);
        	win_rate[i] = cnt != 0 ? (win/(double)cnt)*100 : 0;	// ��� ���� ������ �·��� 0	
        	
        	match_result[i][0] = boxernumber;	// �ڽ��� ��ȣ
        	match_result[i][1] = win_heavyboxer;// ���ſ� ���� �̱� Ƚ��
        	match_result[i][2] = win_rate[i]; // �·�
        	match_result[i][3] = weights[i];	// ������
        	
        }
        
        for (int i=0;i<match_result.length;i++) {
        	for (int j=0;j<match_result[i].length;j++) {
        		System.out.print(match_result[i][j] + " ");
        	}
        	System.out.println();
        }
        
        Arrays.sort(match_result, new Comparator<double[]>() {

            @Override
            public int compare(double[] o1, double[] o2) {
               // TODO Auto-generated method stub
               if (o1[2] != o2[2]) {   // �·�
            	  if (o2[2]-o1[2] > 0) return 1;
            	  else return -1; 
               }
               if (o1[1] != o2[1]) {   // ������ ���ſ� ������ ���
            	   if (o2[1]-o1[1] > 0 ) return 1;
            	   else return -1;
               }
               if (o1[3] != o2[3]) {   // ������
                  if (o2[3]-o1[3] > 0 ) return 1;
                  else return -1;
               }
               
               if (o1[0] - o2[0] > 0) return 1;
               else return -1;
            }
           });
           
           for (int i=0;i<match_result.length;i++) {
              answer[i] = (int)match_result[i][0];   // �ε���
           }
       
        return answer;
    }
	
	public static void main(String[] args) {
		int[] weights = {50, 82, 75, 120};
		String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
		int[] result = {};
		
		result = solution(weights, head2head);
		
		System.out.print("[ ");
		for (int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
		System.out.print("]");
		
	}
}
