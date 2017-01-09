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
    public boolean isSymmetric(TreeNode root) {
        if (null==root) {
        	return true;
        }
        return isSymmetricRecursive(root.left,root.riht);
    }

    private boolean isSymmetricRecursive(TreeNode left, TreeNode right){
    	if (null==left || null==right) {
    		return left==right;
    	}
    	if (left.val!=right.val) {
    		return false;
    	}
    	return isSymmetricRecursive(left.left,right.right) && isSymmetricRecursive(left.right,right.left);
    }
}