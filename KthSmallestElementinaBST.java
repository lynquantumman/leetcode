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
    public int kthSmallest(TreeNode root, int k) {
    	int temp = numberOfNodes(root.left)+1;
        if (k<temp) {
        	return kthSmallest(root.left,k);
        }else if (temp<k) {
        	return kthSmallest(root.right,k-temp);
        }else{//(numberOfNodes(root.left)+1)<k
        	return root;
        }
    }
    private int numberOfNodes(TreeNode root){
    	return null==root? 0:(numberOfNodes(root.left)+1+numberOfNodes(root.right));
    }
}