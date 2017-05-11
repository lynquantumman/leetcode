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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null==root || p==root||q==root) {
        	return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null) {
        	if (right==null) {
        		return null;
        	}else{
        		right;
        	}
        }else{
        	if (right==null) {
        		return left;
        	}else {
        		return root;
        	}
        }
    }
}