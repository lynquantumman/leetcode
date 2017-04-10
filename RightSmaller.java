public class Solution {
	class TreeNode{
		int val;
		int lessSum = 0;
		int count = 1;
		TreeNode left = null;
		TreeNode right = null;
		TreeNode(int val){
			this.val = val;
		}
	}

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        if (nums.length==0) {
        	return Arrays.asList(ans);
        }
        TreeNode root = new TreeNode(nums[nums.length-1]);
        ans[nums.length-1] = Integer.valueOf(0);
        for (int i = nums.length-2;i>=0 ;i-- ) {
        	ans[i] = Integer.valueOf(insert(root,nums[i]));
        }

        return Arrays.asList(ans);
    }

    private int insert(TreeNode root, int val){
    	int sum = 0;
    	if (val==root.val) {
    		root.count++;
    		return root.lessSum;
    	}
    	else if (val<root.val) {
    		root.lessSum++;
    		if (null!=root.left) {
    			return sum+insert(root.left,val);
    		}
    		else{
    			root.left = new TreeNode(val);
    			return sum;
    		}
    	}else {//when root.val<val
    		sum+=root.lessSum;
    		sum+=root.count;
    		if (root.right!=null) {
    			return sum+insert(root.right,val);
    		}else{
    			root.right = new TreeNode(val);
    			return sum;
    		}
    	}
    		
    }
}





