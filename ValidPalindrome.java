public class Solution {
    public boolean isPalindrome(String s) {

    	int i = 0;
    	int j = s.length()-1;
    	int left = 0;
    	int right = 0;
    	while(i<=j) {
    		left = s.codePointAt(i);
    		right = s.codePointAt(j);

    		if((Character.isAlphabetic(left) || Character.isDigit(left)) && (Character.isDigit(right) || Character.isAlphabetic(right))){
    			if (Character.toLowerCase(left)==Character.toLowerCase(right)) {
    				
    				i++;
    				j--;
    			}
    			else {
    				return false;
    			}
    		}
    		else {
    			if (!(Character.isAlphabetic(left)||Character.isDigit(left))) {
    				i++;
    			}
    			if (!(Character.isAlphabetic(right)||Character.isDigit(right))) {
    				j--;
    			}
    		}

    	}
    	return true;
        
    }
}