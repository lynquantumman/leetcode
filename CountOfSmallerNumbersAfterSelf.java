public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] arrayAns = new int[nums.length];
		for (int i =  nums.length-1;i>=0 ;i-- ) {
			for (int j = i;j<nums.length ;j++ ) {
				if (nums[i]>nums[j]) {
					arrayAns[i]+=(arrayAns[j]+1);
					break;
				}
			}
		}
		for (int each:arrayAns) {
			ans.add(each);
		}
		return ans;
    }
}