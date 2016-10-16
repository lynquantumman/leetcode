public class Solution {
    public boolean isPalindrome(int x) {
    	int reverse = 0;
    	if(x<0){
    		return false;
    	}
    	if(x/10==0){
    		return true;
    	}
    	if(x%10==0)
    		return false;
        while(x>reverse){//
        	reverse = reverse*10 + x%10;
        	x = x/10;
        }
        return x==reverse|| reverse/10==x
        
    }
}