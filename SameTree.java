/**
*@author Cradle Lee
*/
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
	boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){
        	if(p.val==q.val){
        		flag = isSameTree(p.left,q.left);
        		if(flag==false)
        			return false;
        		flag = isSameTree(p.right,q.right);
        			return flag;
        	}
        	else {
        		return false;
        	}
        }
        else if(p!=null && q==null){
        	return false;
        }
        else if(p==null && q!=null){
        	return false;
        }
        else{
        	return true;       	
        }
        
        
    }
        
}