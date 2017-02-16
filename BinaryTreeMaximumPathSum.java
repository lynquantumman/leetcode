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

	class Ans{
		int rootEndMax = 0;
		int max = Integer.MIN_VALUE;;
	}
    public int maxPathSum(TreeNode root) {
    	int rootEndMax = 0;
        return maxPathSumRecursive(root).max;
    }

    private Ans maxPathSumRecursive(TreeNode root){
    	Ans leftAns = new Ans();
    	Ans rightAns = new Ans();
    	Ans ans = new Ans();
    	if (null!=root.left) {
    		leftAns = maxPathSumRecursive(root.left);
    	}
    	if (null!=root.right) {
    		rightAns = maxPathSumRecursive(root.right);
    	}
    	ans.rootEndMax = Math.max(Math.max(leftAns.rootEndMax,rightAns.rootEndMax),0)+root.val;
    	int temp = Math.max(Math.max(leftAns.rootEndMax+root.val,rightAns.rootEndMax+root.val),leftAns.rootEndMax+rightAns.rootEndMax+root.val);
    	ans.max = Math.max(Math.max(leftAns.max,rightAns.max),Math.max(temp,root.val));
    	return ans;
    	
    }
}