package enter_leave;

import java.util.ArrayList;

public class Enter_Leave {
    static public int[] solution(int[] enter, int[] leave) {
    	int[] answer = new int[enter.length];
        
        ArrayList<Integer> newEnter = new ArrayList<>();
        ArrayList<Integer> newLeave = new ArrayList<>();
        
        // enter, leave 데이터 넣기
        for(int i=0; i<leave.length; i++) {
           newEnter.add(enter[i]);
        }      
        for(int i=0; i<leave.length; i++) {
           newLeave.add(leave[i]);
        }
        
        ArrayList<Integer> room = new ArrayList<>();
     
        while(newLeave.size()!=0) { // 모두 퇴실할 때까지
           int person = newLeave.get(0); 
           
           // 해당 사람이 회의실에 있으면
           if(room.contains(person)) {            
              // 해당 사람 지우기 
              newLeave.remove(0);         
              room.remove(room.indexOf(person));
              
              // 만난 사람 수 카운팅 
              answer[person-1] += room.size();    // 퇴실하는 사람이 만난 사람 = 룸에 남아있는 사람
              for(int i=0; i<room.size(); i++) {  // 룸에 남아있는 사람이 만난 사람 = 나간 사람
                 answer[room.get(i)-1]++;
              }

           }
           else {	// 없으면
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
