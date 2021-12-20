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
        	int cnt = 0;  	// ÃÑ °æ±â ¼ö
        	int win = 0;	// ÀÌ±ä È½¼ö
        	int win_heavyboxer = 0;	// ÀÚ±âº¸´Ù ¹«°Å¿î º¹¼­¸¦ ÀÌ±ä È½¼ö
        	
        	
        	for (int j=0;j<weights.length;j++) {
        		char a = head2head[i].charAt(j);
        		
        		if (a != 'N') cnt++;
        		
        		if (a == 'W') {
        			win++;
        			if (weights[i] < weights[j]) win_heavyboxer++;
        		}
        	}
        	
        	//System.out.println("win : " + win + ", cnt : " + cnt);
        	win_rate[i] = cnt != 0 ? (win/(double)cnt)*100 : 0;	// °æ±â ¼ö°¡ ¾øÀ¸¸é ½Â·üÀº 0	
        	
        	match_result[i][0] = boxernumber;	// ÀÚ½ÅÀÇ ¹øÈ£
        	match_result[i][1] = win_heavyboxer;// ¹«°Å¿î ³ðÀ» ÀÌ±ä È½¼ö
        	match_result[i][2] = win_rate[i]; // ½Â·ü
        	match_result[i][3] = weights[i];	// ¸ö¹«°Ô
        	
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
               if (o1[2] != o2[2]) {   // ½Â·ü
            	  if (o2[2]-o1[2] > 0) return 1;
            	  else return -1; 
               }
               if (o1[1] != o2[1]) {   // ¸ö¹«°Ô ¹«°Å¿î º¹¼­¿Í ´ë°á
            	   if (o2[1]-o1[1] > 0 ) return 1;
            	   else return -1;
               }
               if (o1[3] != o2[3]) {   // ¸ö¹«°Ô
                  if (o2[3]-o1[3] > 0 ) return 1;
                  else return -1;
               }
               
               if (o1[0] - o2[0] > 0) return 1;
               else return -1;
            }
           });
           
           for (int i=0;i<match_result.length;i++) {
              answer[i] = (int)match_result[i][0];   // ÀÎµ¦½º
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
