public class Solution {
    public int missingNumber(int[] nums) {
    	long sum = 0;
    	for (int each : nums ) {
    	   	sum = sum + (long)each;
    	}
    	int expected = (0+nums.length-1)*nums.length/2;

    	return (int)((long)nums.length - sum+(long)expected);


    }
}