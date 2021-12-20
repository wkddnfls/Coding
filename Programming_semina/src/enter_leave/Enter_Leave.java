package enter_leave;

import java.util.ArrayList;

public class Enter_Leave {
    static public int[] solution(int[] enter, int[] leave) {
    	int[] answer = new int[enter.length];
        
        ArrayList<Integer> newEnter = new ArrayList<>();
        ArrayList<Integer> newLeave = new ArrayList<>();
        
        // enter, leave ������ �ֱ�
        for(int i=0; i<leave.length; i++) {
           newEnter.add(enter[i]);
        }      
        for(int i=0; i<leave.length; i++) {
           newLeave.add(leave[i]);
        }
        
        ArrayList<Integer> room = new ArrayList<>();
     
        while(newLeave.size()!=0) { // ��� ����� ������
           int person = newLeave.get(0); 
           
           // �ش� ����� ȸ�ǽǿ� ������
           if(room.contains(person)) {            
              // �ش� ��� ����� 
              newLeave.remove(0);         
              room.remove(room.indexOf(person));
              
              // ���� ��� �� ī���� 
              answer[person-1] += room.size();    // ����ϴ� ����� ���� ��� = �뿡 �����ִ� ���
              for(int i=0; i<room.size(); i++) {  // �뿡 �����ִ� ����� ���� ��� = ���� ���
                 answer[room.get(i)-1]++;
              }

           }
           else {	// ������
              room.add(newEnter.get(0));
              newEnter.remove(0);
           }         
        }
        
        return answer;
    }

	
	public static void main(String[] args) {
		int[] enter = {1, 3, 2};
		int[] leave = {1, 2, 3};
		int[] result = {};
		
		result = solution(enter, leave);
		
		System.out.print("[ ");
		for (int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
		System.out.print("]");
	}
}
