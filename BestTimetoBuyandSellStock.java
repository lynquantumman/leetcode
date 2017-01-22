public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<=1) {
        	return 0;
        }
        int[] diff = new int[len-1];

        for (int i = 0;i<len-1;i++ ) {
        	diff[i] = prices[i+1]-prices[i];
        }

        return maxSubarray(diff);

    }

    private int maxSubarray(int[] input){
    	int max = 0;
    	int temp = 0;
    	for (int each:input) {
    		if (temp>0) {
    			temp += each;
    			max = Math.max(max,temp);
    		}
    		else{
    			temp = each;
    			max = Math.max(max,temp);
    		}
    	}
    	return max;
    }
}