package secret_letter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Secret_letter {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		try{
            File input_file = new File("D:\\programming_semina_test\\input.txt");     
            File output_file = new File("D:\\programming_semina_test\\output.txt");        
            BufferedReader rb = new BufferedReader(new FileReader(input_file));
            BufferedWriter wb = new BufferedWriter(new FileWriter(output_file));
            
            String line = "";
            String input_line ="";                     
            
            while((line = rb.readLine()) != null){
            	input_line = line;  // ��ȣ���� ����
                System.out.println(input_line);
            }
            char[] list = input_line.toCharArray();  // String �迭�� �ٲ�
      
            
            for (int i=0;i<list.length/6;i++) { // 6���� �� �� ����
            	String word = "";
            	for (int j=0;j<6;j++) {
            		word += list[i*6+j];  
            	}
            	//System.out.println(word);
            	
            	if (!isword(word)) {	// ���ڸ� �� �� ���� ��
            		System.out.println((i + 1)); 
            		wb.write(Integer.toString(i+1));
            		
            		rb.close();
            		wb.flush(); wb.close();
            		return;
            	}
            }
            
            System.out.println(sb.toString());      
            wb.write(sb.toString());
            
            rb.close();
            wb.flush(); wb.close();
            
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            System.out.println(e);
        }
	}
	
	public static boolean isword(String word) {
		String arr[] = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};  // A, B, C, D, E, F, G, H 
		
		for (int i=0;i<arr.length;i++) { 
			// ���ڰ� ���� ��
//			if (word.equals(arr[i])) {    
//				sb.append((char)(i + 'A'));
//				return true;
//			}
			
			// �� ���ڸ� �ٸ� ��
			int count = 0;
			for (int j=0;j<6;j++) {    
				if (arr[i].charAt(j) != word.charAt(j)) 
					count++;
			}
			
			if (count <= 1) {
				String t = "";
				t = t + (char)(i + 'A');
				sb.append((char) (i + 'A'));
				return true;
			}
		}
		return false;  // �� �� �̻� �ٸ� ��
	}
}
