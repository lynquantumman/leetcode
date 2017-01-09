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

    public boolean isBalanced(TreeNode root) {
        return -1!=height(root,0);
    }
    private int height(TreeNode root, int h){
    	if (null==root) {
    		return h;
    	}
    	else{
    		int hLeft = height(root.left,h+1);
    		if (-1==hLeft) {
    			return -1;
    		}
    		int hRight = height(root.right,h+1);
    		if (-1==hRight) {
    			return -1;
    		}
    		if (Math.abs(hLeft-hRight)>1) {
    			return -1;
    		}
    		return Math.max(hLeft,hRight);
    	}
    }
}