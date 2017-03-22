public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestRecursive(nums,0,nums.length,nums.length-k);
    }

    private int findKthLargestRecursive(int[] nums, int left, int right, int k){
    	if (1==right-left) {
    		return nums[left];
    	}
    	
    	int benchmark = nums[left];
    	int leftput = left+1;
    	int rightput = right-1;
    	while (leftput<rightput) {
    		if (nums[leftput]>benchmark) {
    			swap(nums,leftput,rightput);
    			rightput--;
    		}
    		else//nums[leftput]<=benchmark
    			leftput++;
    	}

    	if (nums[leftput]<benchmark) {
    		//benchmark is leftput th value
    		swap(nums,left,leftput);
    		if (leftput==k) {
    			return nums[k];
    		}
    		else if (leftput<k) {
    			return findKthLargestRecursive(nums,leftput+1,right,k);
    		}
    		else{//k<leftput
    			return findKthLargestRecursive(nums,left,leftput,k);
    		}
    	}
    	else{
    		swap(nums,left,leftput-1);
    		if (leftput-1==k) {
    			return nums[k];
    		}
    		else if (leftput-1<k) {
    			return findKthLargestRecursive(nums,leftput,right,k);
    		}
    		else{//k<leftput-1
    			return findKthLargestRecursive(nums,left,leftput-1,k);
    		}
    	}
    	// benchmark is the leftput-1 th value 

    }
    private void swap(int[] nums, int a, int b){
    	
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}