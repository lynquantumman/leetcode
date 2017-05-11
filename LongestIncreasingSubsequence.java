public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int i = 0;
        int[] ans = new int[nums.length];
        for (int x : nums) {
        	i = Arrays.binarySearch(ans,0,len,x);
        	if (i<0) {
        		i = -(i+1);
        	}

        	ans[i] = x;
        	if (i==len) {
        		len++;
        	}
        	return len;
        }
    }
}