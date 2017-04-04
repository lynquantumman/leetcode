public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        ans[1] = nums[0];
        for (int i = 2;i<nums.length ;i++ ) {
        	ans[i] = nums[i-1]*ans[i-1];
        }
        int right = 1;
        for (int i = nums.length-1;i>=0 ;i-- ) {
        	ans[i] = ans[i]*right;
        	right = right*nums[i];
        }
        return ans;
    }
}