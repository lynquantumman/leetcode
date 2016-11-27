public class Solution {
    public void sortColors(int[] nums) {
//        bubbleSort(nums);
    	qsort(nums,0,nums.length);
    }

    private void qsort(int[] nums, int left, int right){
    	if (right-left<=1) {
    		return ;
    	}
    	else if(right-left==2){
    		if (nums[left]<nums[left+1]) {
    			return;
    		}
    		else {
//    			System.out.println("====21");
    			swap(nums, left, 1+left);
    			return;
    		}
    	}
    	else{
//in this algorithm  head and tail can move
    		int head = left+1;
    		int tail = right-1;
    		int compareFactor = nums[left];
    		while(head<tail){
    			while(nums[head]<=compareFactor && head<tail) {
    				head++;	
    			}
    			while(compareFactor<nums[tail] && head<tail) {
    				tail--;
    			}
    			swap(nums,head,tail);
    		}
    		// here head=tail
    		int mid = head;
//    		the meet point of head and tail, and the discussion about it
    		if (nums[left]>nums[mid]) {
    			swap(nums,left,mid);
    		}
    		else {//nums[left]<=nums[mid]
    			
    			mid--;
    			swap(nums,left,mid);
    		}
    		qsort(nums,left,mid);
    		qsort(nums,mid+1,right);
    		
    	}


    }

    private void swap(int[] nums,int left, int right){
    	int temp = 0;
    	temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
    }

    private void bubbleSort(int[] nums){
    	boolean hasChanged = true;
    	while(hasChanged){
    		hasChanged = false;
    		for (int i = 0;i<nums.length-1;i++ ) {
	    		if(nums[i]>nums[i+1]){
	    			swap(nums,i,i+1);
	    			hasChanged = true;
	    		}
    		}
    	}
    	
    }
}