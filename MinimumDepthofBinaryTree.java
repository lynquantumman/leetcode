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
	int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (null==root) {
            return 0;
        }
       

        minDepthRecursive(1,root);
        

        return min;
    }

    private void minDepthRecursive(int depth, TreeNode node){
    	if (null==node.left && null==node.right) {
            min = Math.min(min,depth);
    		return;
    	}

        if (null!=node.right) {
            minDepthRecursive(depth+1, node.right);
        }
        if (null!=node.left) {
            minDepthRecursive(depth+1, node.left);
        }
    	
    }
}