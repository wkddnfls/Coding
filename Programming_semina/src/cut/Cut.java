package cut;

import java.io.*;
import java.util.ArrayList;

public class Cut {
	static int n; // 가로 길이
	static int m; // 세로 길이
	static int a; 
	static int num; // 점선 번호

	public static void main(String[] args) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		
		try {
			File input_file = new File("D:\\input.txt");
			File output_file = new File("D:\\output.txt");
			BufferedReader br = new BufferedReader(new FileReader(input_file));
			FileWriter fw = new FileWriter(output_file, true);

			// 첫 번째 줄 : 가로, 세로 길이 입력 받기
			String line = br.readLine();
			n = Integer.parseInt(line.split(" ")[0]);
			m = Integer.parseInt(line.split(" ")[1]); 

			// 두 번째 줄 : 칼로 잘라야하는 점선의 개수
			line = br.readLine();
			col.add(m);  // 10 
			row.add(n);  // 8
			
			// 나머지 줄 읽기
			while ((line = br.readLine()) != null) {
				a = Integer.parseInt(line.split(" ")[0]);
				num = Integer.parseInt(line.split(" ")[1]);

				if(a == 0) { // 가로
					int i;
					for(i=0;num-col.get(i)>0;i++) {
						num -= col.get(i);
					}
					
					int temp = col.remove(i);
					
					col.add(i,temp-num);
					col.add(i,num);
				}
				else { // 세로
					int i;
					for(i=0;num-row.get(i)>0;i++) {
						num -= row.get(i);
					}
					int temp = row.remove(i);
					row.add(i,temp-num);
					row.add(i,num);
				}
			} 
			
			// 가장 큰 넓이 구하기
			int max = 0;
			for (int i=0;i<col.size();i++) {
				for (int j=0;j<row.size();j++) {
					int temp = col.get(i)*row.get(j);
					
					if (temp > max) {
						max = temp;
					}
				}
			}
			
			System.out.println(max);
			fw.write(Integer.toString(max));
			
			br.close();
			fw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
