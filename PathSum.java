/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (null==root) {
    		return false;
    	}
    	else {
    		return hasPathSumRecursive(root,sum);
    	}
    	
    }
    private boolean hasPathSumRecursive(TreeNode root, int sum){
    	if (null==root.left && null==root.right) {
    		return root.val==sum;
    	}
    	if (null!=root.left) {
    		if(true==hasPathSumRecursive(root.left,sum-root.val))
    			return true;
    	}
    	if (null!=root.right) {
    		if(true==hasPathSumRecursive(root.right,sum-root.val))
    			return true;
    	}	
    		
    		return false;
    	
    }

}