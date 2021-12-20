package make_Triangle;

public class Make_Triangle {
    public static void main (String args[]){
        int input = 9;   // 성냥개비 개수
        int cnt = 0; // 만들수 있는 삼각형 개수
        
        for (int a = 1; a < input; a++) {
            for (int b = a; b <= input - a - b; b++) {
                int c = input - a - b;	// 가장 긴 변
                System.out.println("a:" + a + ", b:" + b + ", c:" + c);
                
                // 삼각형의 결정 조건
                // 다른 두변의 길이의 합(a+b) > 가장 긴 변(c)
                if (a + b > c) {
                	cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}