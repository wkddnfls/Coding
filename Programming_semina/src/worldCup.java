
public class worldCup {
   static int input[][] = {
         {5,0,0,3,0,2,2,0,3,0,0,5,4,0,1,1,0,4},
         {4,1,0,3,0,2,4,1,0,1,1,3,0,0,5,1,1,3},
         {5,0,0,4,0,1,2,2,1,2,0,3,1,0,4,0,0,5},
         //{5,0,0,3,1,1,2,1,2,2,0,3,0,0,5,1,0,4}
         {5,0,0,5,0,0,2,1,2,2,1,2,0,0,5,0,0,5}
   };
   
    static int[][] table;
    
    public static void main(String[] args) {
    	
        for(int tc=1;tc<=4;tc++) {
            table=new int[6][3];
            int sum=0;
            int win=0, draw=0, loss=0;
            int draw_cnt = 0;
            int r1 = 0, r2 = 0, r3 = 0, r4 = 0;
            
            for(int i=0;i<6;i++) {
                table[i][0]=input[tc-1][i*3];
                table[i][1]=input[tc-1][i*3+1];
                table[i][2]=input[tc-1][i*3+2];
                
                sum+=(table[i][0]+table[i][1]+table[i][2]);	// 경기 수 총 합
                win+=table[i][0];	// 승의 총 개수
                draw+=table[i][1];	// 무승부의 총 개수
                loss+=table[i][2];	// 패의 총 개수
                
                if (table[i][1] > 0) {
                	draw_cnt++;	// 무승부가 되는 조의 개수
                }
            }
            if (sum != 30) {
            	continue;
            }
            
            // 조건(rule) 충족하면 1, 아니면 0
            // 조건 1. 승의 개수 = 패의 개수
            if (win == loss) {
            	r1 = 1;
            } else {
            	r1 = 0;
            }
            
            // 조건 2. 무승부의 총 개수는 짝수이고, 무승부가 되는 조는 0 또는 2조 이상
            //System.out.println("draw_cnt : " + draw_cnt);
            if (draw%2 == 0 && (draw_cnt ==0 || draw_cnt >= 2)) {
            	r2 = 1;
            } else {
            	r2 = 0;
            }
            
            // 조건 3. 한 조가 가질 수 있는 무승부의 개수 <= 총 무의 개수/2
            for (int i=0;i<6;i++) {
            	if (table[i][1] <= draw) {
            		r3 = 1;
            	} else {
            		r3 = 0;
            	}
            }
            
            // 조건 4. 한 줄에 경기 횟수는 무조건 (전체 팀 - 1)개를 가지고 있어야 한다. 
            int count = 0;
            for (int i=0;i<6;i++) {
            	count = table[i][0] + table[i][1] + table[i][2];
            	
            	if (count == 5) {
            		r4 = 1;
            	} else {
            		r4 = 0;
            	}
            }
            
            //System.out.println("조건 r : " + r1 + " " + r2 + " " + r3 + " " + r4);
            // 결과
            if (r1==1 && r2==1 && r3==1 && r4==1) {
            	System.out.println("1");
            } else {
            	System.out.println("0");
            }
            
        }
    }
    
}