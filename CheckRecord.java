public class Solution {
    public boolean checkRecord(String s) {
        int[] reward = new int[2];
        for (int i = 0;i<s.length() ;i++ ) {
        	if(s.charAt(i) == 'A'){
        		reward[0]++;
        		
        		reward[1] = 0;
        		
        	}
        	else if(s.charAt(i)=='L'){
        		reward[1]++;
        	}else{
        		
        		reward[1] = 0;
        		
        	}
        	if (reward[0]>1||reward[1]>2) {
        		return false;
        	}
        }
    
        return true;
    }
}