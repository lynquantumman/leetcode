/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 思路，用递归来做，设立递归上界，左枝头可以小于等于上界
public class Solution {
    public boolean isValidBST(TreeNode root) {
        long upBound = Long.MAX_VALUE;
        long downBound = Long.MIN_VALUE;
        return isValidBSTWithBounds(root,upBound,downBound);
    }

    public boolean isValidBSTWithBounds(TreeNode root,long upBound,long downBound){

    	if (null==root) {
    		return true;
    	}
    	long val = (long)root.val;
    	if (val>=upBound) {
    		return false;
    	}
    	if (val<=downBound) {
    		return false;
    	}
    	// if (root.left.val>root.val) {
    	// 	return false;
    	// }
    	// if (root.val>root.right.val) {
    	// 	return false;
    	// }
    		return isValidBSTWithBounds(root.left,val,downBound)
    	&& isValidBSTWithBounds(root.right,upBound,val);
    }
}