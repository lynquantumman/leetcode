public class Solution {
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stk = new Stack<Integer>();
    	for (String each:tokens) {
    		try{
    			int number = Integer.valueOf(each);
    			stk.push(number);
	        }
	        catch(NumberFormatException e){
	        	int secondNumber = stk.pop();
	        	int firstNumber = stk.pop();
	        	if ("+".equals(each)) {
	        		ans = firstNumber+secondNumber;
	        	}
	        	if ("-".equals(each)) {
	        		ans = firstNumber-secondNumber;
	        	}
	        	if ("*".equals(each)) {
	        		ans = firstNumber*secondNumber;
	        	}
	        	if ("/".equals(each)) {
	        		ans = firstNumber/secondNumber
	        	}
	        	stk.push(ans);

	        }
    	}
    	return stk.pop();
        
    }
}