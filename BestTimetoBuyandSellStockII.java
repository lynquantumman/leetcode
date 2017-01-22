public class Solution {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	int temp = 0;
    	int sum = 0;
        for (int i = 0;i+1<len;i++) {
        	temp = prices[i+1]-prices[i];
        	if (temp>0) {
        		sum+=temp;
        	}
        }
        return sum;
    }
}