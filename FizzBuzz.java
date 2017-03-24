public class Solution {
    public List<String> fizzBuzz(int n) {
    	List<String> ans  = new ArrayList<String>(); 
    	for (int i = 1;i<=n ;i++ ) {
    		if (0==i%3) {
    			if (0==i%5) {
    				ans.add("FizzBuzz");
    			}else{
    				ans.add("Fizz");
    			}
    		}
    		else if(0==i%5){
    			ans.add("Buzz");
    		}
    		else {
    			ans.add(String.valueOf(i));
    		}
    	}
    	return ans;
        
    }
}