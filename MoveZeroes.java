public class Solution {
    public void moveZeroes(int[] nums) {
        int targetPosition = 0;
        int numberPosition = 0;
        while(numberPosition<nums.length){
        	while(numberPosition<nums.length&&0==nums[numberPosition]) {
        		numberPosition++;
        	}
        	if (numberPosition>=nums.length) {
        		break;
        	}
        	nums[targetPosition] = nums[numberPosition];
        	targetPosition++;
        	numberPosition++;
        }
        for (int i = targetPosition;i<nums.length ;i++ ) {
        	nums[i] = 0;
        }
    }
}