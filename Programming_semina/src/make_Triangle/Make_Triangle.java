package make_Triangle;

public class Make_Triangle {
    public static void main (String args[]){
        int input = 9;   // ���ɰ��� ����
        int cnt = 0; // ����� �ִ� �ﰢ�� ����
        
        for (int a = 1; a < input; a++) {
            for (int b = a; b <= input - a - b; b++) {
                int c = input - a - b;	// ���� �� ��
                System.out.println("a:" + a + ", b:" + b + ", c:" + c);
                
                // �ﰢ���� ���� ����
                // �ٸ� �κ��� ������ ��(a+b) > ���� �� ��(c)
                if (a + b > c) {
                	cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}