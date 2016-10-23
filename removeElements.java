public class Solution {
    public int removeElement(int[] nums, int val) {
    	int len = nums.length;
        if(len==0)
        	return 0;
        if(len==1){
        	if(nums[0]==val)
        		return 0;
        	else {
        		return 1;
        	}
        }

        int left = 0;
        int right = len-1;
        while(left<right){
        	while(left<len&&nums[left]!=val)
        		left++;
        	while(0<=right&&nums[right]==val)
        		right--;
        	if(left<right){
        		swap(nums,left,right);
        	}
        	else {
        		break;
        	}
        }
        return left;
    }

    private void swap(int[] nums, int left, int right){
    	int temp = 0;
    	temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
    }
       
}