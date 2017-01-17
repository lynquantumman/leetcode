public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (1<=numRows) {
        	ArrayList<Integer> eleLine1 =  new ArrayList<Integer>();
        	eleLine1.add(1);
        	ans.add(eleLine1);
        	
        }
        
        if (2<=numRows) {
        	List<Integer> eleLine2;
        	eleLine2 =  new ArrayList<Integer>();
        	eleLine2.add(1);
        	eleLine2.add(1);
        	ans.add(eleLine2);

        	List<Integer> output = eleLine2;
	        if (numRows>=3) {
	        	for (int i = 1;i<=numRows-2 ;i++ ) {
	        		output = nextLine(output);
	        		ans.add(output);

	        	}
	        }	
        }
        
        return ans;
    }
    List<Integer> nextLine(List<Integer> input){
    	//在这里面new 对象
    	List<Integer> ans = new ArrayList<Integer>();
    	ans.add(1);
    	int len = input.size();
    	for(int i = 0;i+1<len;i++){
    		ans.add(input.get(i)+input.get(i+1));
    	}
    	ans.add(1);
    	return ans;
    }
}
