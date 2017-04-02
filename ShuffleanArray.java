public class Solution {
	int[] ans;
	int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        this.ans = nums.clone();

    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rd = new Random();
        int i = 0;
        for (int j = 1;j<this.ans.length ;j++ ) {
        	i = rd.nextInt(j+1);
        	swap(this.ans,i,j);
        }
        return this.ans;
    }

    private void swap(int[] ans,int i, int j){
    	int temp = ans[i];
    	ans[i] = ans[j];
    	ans[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */ 