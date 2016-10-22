public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] ans = {0,0};
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        mid = (low+high)/2;
        while(low<high){//search for the left side
        	
        	if(target<nums[mid]){
        		high = mid-1;
        		mid = (low+high)/2;
        	}
        	else if(nums[mid]<target){
        		low = mid+1;
        		mid = (low+high)/2;
        	}
        	else{
        		 high = mid;
        		 mid = (low+high)/2;
        	}
        }
        if(nums[mid]==target)
	        ans[0] = mid;
	    else {
	    	ans[0] = -1;
	    	ans[1] = -1;
	    	return ans;
	    }
        low = 0;
        high = nums.length-1;
        mid = (low+high+1)/2;
        while(low<high){//search for the right side
        	
        	if(target<nums[mid]){
        		high = mid-1;
        		mid = (low+high+1)/2;
        	}
        	else if(nums[mid]<target){
        		low = mid+1;
        		mid = (low+high+1)/2;
        	}
        	else {
        		low = mid;
        		mid = (low+high+1)/2;
        	}
        }
        ans[1] = mid;
        return ans;
    }
}