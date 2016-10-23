/**
*Suppose a sorted array is rotated 
*at some pivot unknown to you beforehand.
*(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
*You are given a target value to search. 
*If found in the array return its index, otherwise return -1.
*You may assume no duplicate exists in the array.
*Subscribe to see which companies asked this question
*/
public class Solution {
	final boolean HIGH = false;
	final boolean LOW = true;
    public int search(int[] nums, int target) {
    	int len = nums.length;
		if(0==len)
			return -1;
		if(1==len){
			if(target == nums[0])
				return 0;
			else {
				return -1;
			}
		}
        // the situation of len>=2
        int rotateNum = nums[0];
        boolean side = HIGH;
        int left = 0;
        int right = len-1;
        int mid = (left+right)/2;
        if(target<rotateNum){
        	side = LOW;
        	while(left<right){
	        	if(nums[mid]==target)
	        		return mid;
	        	else if (nums[mid]>target) {
	        		if(nums[mid]>=rotateNum){
	        			left = mid+1;
	        			mid = (left+right)/2;
	        		}
	        		else{
	        			right = mid-1;
	        			mid = (left+right)/2;
	        		}
	        		
	        	}
	        	else{//nums[mid]<target
	        		left = mid+1;
	        		mid = (left+right)/2;
	        	} 
        	}
        	if(nums[mid]==target)
        		return mid;
        	else return -1;
        }
        else if (target==rotateNum) {
        	return 0;
        }
        else{//side=HIGH
        	while(left<right){
	        	if(nums[mid]==target)
	        		return mid;
	        	else if (nums[mid]>target) {

	        			right = mid-1;
	        			mid = (left+right)/2;
	        		
	        		
	        	}
	        	else{//nums[mid]<target
	        		if(nums[mid]<rotateNum){
	        			right = mid-1;
	        			mid = (left+right)/2;
	        		}
	        		else{
	        			left = mid+1;
	        			mid = (left+right)/2;
	        		}
	        		
	        	} 
        	}
        	if(nums[mid]==target)
        		return mid;
        	else return -1;
        }
    }
}