
public class Solution {

    public int jump(int[] nums) {
    	int[] dp = new int[nums.length];
    	dp[0] = 0;
    	for(int endPoint = 1;endPoint<nums.length;endPoint++){
    		int	pos = endPoint-1;
    		int i = 1;
    		for(;0<=pos;pos--,i++){
    			if(i<nums[pos]){
    				//dp.length
    				dp[endPoint] = dp[pos]+1;
    			}
    		}
    	}
    	return dp[nums.length-1];
    }
}