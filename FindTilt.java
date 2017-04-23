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
	public int totalTilt = 0;
	public class Answer{
		int tilt;
		int sum;
	}

    public int findTilt(TreeNode root) {
        Answer ans =  findTiltHelper(root);
        return this.totalTilt;
    }

    public Answer findTiltHelper(TreeNode root){
    	Answer ans = new Answer();
    	if (null==root) {
    		ans.sum = 0;
    		ans.tilt = 0;
    	}
    	else{
    		Answer leftans = findTiltHelper(root.left);
    		Answer rightans = findTiltHelper(root.right);
    		ans.tilt = Math.abs(leftans.sum-rightans.sum);
    		this.totalTilt+=ans.tilt;
    		ans.sum = leftans.sum+rightans.sum+root.val;
    	}
    	
    	return ans;

    }
}