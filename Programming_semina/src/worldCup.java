
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
                
                sum+=(table[i][0]+table[i][1]+table[i][2]);	// ��� �� �� ��
                win+=table[i][0];	// ���� �� ����
                draw+=table[i][1];	// ���º��� �� ����
                loss+=table[i][2];	// ���� �� ����
                
                if (table[i][1] > 0) {
                	draw_cnt++;	// ���ºΰ� �Ǵ� ���� ����
                }
            }
            if (sum != 30) {
            	continue;
            }
            
            // ����(rule) �����ϸ� 1, �ƴϸ� 0
            // ���� 1. ���� ���� = ���� ����
            if (win == loss) {
            	r1 = 1;
            } else {
            	r1 = 0;
            }
            
            // ���� 2. ���º��� �� ������ ¦���̰�, ���ºΰ� �Ǵ� ���� 0 �Ǵ� 2�� �̻�
            //System.out.println("draw_cnt : " + draw_cnt);
            if (draw%2 == 0 && (draw_cnt ==0 || draw_cnt >= 2)) {
            	r2 = 1;
            } else {
            	r2 = 0;
            }
            
            // ���� 3. �� ���� ���� �� �ִ� ���º��� ���� <= �� ���� ����/2
            for (int i=0;i<6;i++) {
            	if (table[i][1] <= draw) {
            		r3 = 1;
            	} else {
            		r3 = 0;
            	}
            }
            
            // ���� 4. �� �ٿ� ��� Ƚ���� ������ (��ü �� - 1)���� ������ �־�� �Ѵ�. 
            int count = 0;
            for (int i=0;i<6;i++) {
            	count = table[i][0] + table[i][1] + table[i][2];
            	
            	if (count == 5) {
            		r4 = 1;
            	} else {
            		r4 = 0;
            	}
            }
            
            //System.out.println("���� r : " + r1 + " " + r2 + " " + r3 + " " + r4);
            // ���
            if (r1==1 && r2==1 && r3==1 && r4==1) {
            	System.out.println("1");
            } else {
            	System.out.println("0");
            }
            
        }
    }
    
}