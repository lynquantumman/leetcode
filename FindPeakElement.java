public class Solution {
    public int findPeakElement(int[] nums) {
    	int len = nums.length;
    	if (1==len) {
    		return 0;
    	}
        for (int i = 0;i<len;i++) {
        	if(nums[i]>nums[i+1]){
        		return i;
        	}
        	if (nums[len-1-i-1]<nums[len-1-i]) {
        		return len-1-i;
        	}
        }
    }
}