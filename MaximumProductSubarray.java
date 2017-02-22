public class Solution {
    public int maxProduct(int[] nums) {
    	if (nums.length==1) {
    		return nums[0];
    	}
    	int minPre = nums[0];
    	int maxHere = nums[0];
        int maxSoFar = nums[0];
        int minHere = 0;
        for (int i = 1;i<nums.length;i++) {
        	minHere = Math.min(Math.min(minPre*nums[i],maxHere*nums[i]),nums[i]);
       		maxHere = Math.max(Math.max(minPre*nums[i],maxHere*nums[i]),nums[i]);
       		maxSoFar = Math.max(maxHere,maxSoFar);
       		minPre = minHere;

        }
        return maxSoFar;
    }
}