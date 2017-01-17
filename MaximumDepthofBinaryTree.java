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
	int max = 0;
    public int maxDepth(TreeNode root) {
        int depth = 0;
        maxDepthRecursive(depth,root);
    }

    private void maxDepthRecursive(int depth, TreeNode node){
    	if (null==root) {
    		max>depth?max:depth;
    		return;
    	}
    	maxDepthRecursive(depth+1, node.left);
    	maxDepthRecursive(depth+1, node.right);
    }
}