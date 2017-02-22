// use the hash idea
public class Solution {
    public int majorityElement(int[] nums) {
    	int majority = nums[0];
    	int count = 0;
        for (int each : nums) {
        	if (count==0) {
        		majority = each;
        	}
        	else if (majority==each) {
        		count++;
        	}
        	else{
        		count--;
        	}
        }
    }
}