// Rotate an array of n elements to the right by k steps.

public class Solution {
    public void rotate(int[] nums, int k) {
    	k = k%nums.length;
    	k = nums.length-1-k;//"to the right" action
        int[] transfer = new int[k+1];
        int i;
        for (i = 0;i<=k;i++ ) {
        	transfer[i] = nums[i];
        }
        int j;
        for (j = 0;i<nums.length;i++,j++) {
        	nums[j] = nums[i];
        }

        for (i = 0;i<=k ;i++,j++ ) {
        	nums[j] = transfer[i];
        }

    }
}