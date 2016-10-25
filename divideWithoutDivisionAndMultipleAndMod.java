public class Solution {
    public int divide(int dividend, int divisor) {
        if(0==divisor)
        	return Integer.MAX_VALUE;
        if(0==dividend){
        	return 0;
        }
        long ans = 1;
        // In this part, either the dividend or the divisor are not 0
        long dividendLong = (long)dividend;
        long divisorLong = (long)divisor;
        boolean signum = true;
        if(dividendLong>0&&divisor>0 || dividendLong<0&&divisor<0)
        	signum = true;
        if(dividendLong>0&&divisor<0 || dividendLong<0&&divisor>0)
        	signum = false;
        
    	dividendLong = dividendLong<0?-dividendLong:dividendLong;
    	divisorLong = divisorLong<0?-divisorLong:divisorLong;
//    	System.out.println(dividendLong+"   "+divisorLong);
    	

        ans = positivedivide(dividendLong, divisorLong);
        ans = signum==true?ans:-ans;
        System.out.println(ans);
        if(ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE)
        	return Integer.MAX_VALUE;

        return (int)ans;
        
    }
    private long positivedivide(long dividendLong, long divisorLong){
    	long ans = 0;
    	if(dividendLong<divisorLong){
    		return 0;
    	}
    	else if(dividendLong==divisorLong){
    		return 1;
    	}
    	else {
    		ans = 1;
    		long temp = divisorLong;
    		while(dividendLong>=temp){
    			ans = ans<<1;
    			temp = temp<<1;
    		}
    		
    		ans = ans>>1;
    		
    		ans+=positivedivide(dividendLong-divisorLong*ans, divisorLong);
    	}
    	return ans;
    }
}