public class Solution {
	int n = 0;
    public int totalNQueens(int n) {
    	// ini
        this.n = n;
        int ans = 0;
        int[] backup = new int[n];
        for(int i = 0;i<n;i++){
        	backup[i] = i+1;
        }

        boolean changed = true;
        while(true==changed){
        	if(isValid(backup)){
        		ans++;
        	}
        	changed = nextPermutation(backup);
        }
        return ans;
    }
    

    private void swap(int[] nums,int i,int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    private boolean nextPermutation(int[] nums){
    	boolean changed = false;
    	for(int i=nums.length-1;i>=1;i--){
    		if(nums[i-1]<nums[i]){
    			for(int j=nums.length-1;j>=1;j--){
    				if(nums[i-1]<nums[j]){
    					swap(nums,i-1,j);
    					changed = true;
    					Arrays.sort(nums,i,nums.length);
    					break;
    				}
    			}
    			break;
    		}
    	}

    	return changed;
    }

    private boolean isValid(int[] backup){
    	for(int ro2 = 1;ro2<n;ro2++){

    		for(int ro1 = 0;ro1<ro2;ro1++){
    			if(Math.abs(backup[ro2]-backup[ro1])==Math.abs(ro2-ro1)){
    				return false;
    			}
    		}
    	}
    	return true;
    }
}