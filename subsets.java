

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
       	for (int i = 0;i < (1<<len) ;i++ ) {
       		ans.add(mapping(nums,i));
       	}
       	return ans;
    }

    private List<Integer> mapping(int[] nums, int input){
    	List<Integer> ans = new ArrayList<Integer>();
    	int temp = input;
    	for (int i = nums.length-1;i>=0 ;i--,temp=temp>>1 ) {
    		// 位运算符优先级较低
    		if ((temp&1)==1) {
    			ans.add(nums[i]);
    		}
    	}
    	return ans;
    }
}