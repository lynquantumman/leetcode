public class Solution {
	
    public boolean isHappy(int n) {
    	int temp = n;
    	HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        while(!map.containsKey(temp)){
        	
			map.put(temp,true);
			temp = next(temp);
			
        }
        return 1==temp;

    }
    private int next(int input){
        
    	String inputString = String.valueOf(input);

    	int sum = 0;
    	int temp = 0;
    	for (int i = 0;i<inputString.length();i++ ) {
    		temp = inputString.codePointAt(i)-'0';
    		
    		sum+=(temp*temp);
    	}

    	return sum;
    	
    }
}