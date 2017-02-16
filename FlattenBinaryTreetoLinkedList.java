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
	LinkedList<TreeNode> preOrderList = new LinkedList<TreeNode>();
    public void flatten(TreeNode root) {
    	if (null==root) {
    		return ;
    	}
    	preOrder(root);
    	for (TreeNode each:preOrderList) {
    		if(each.left!=null){
    			add(each,each.left);
    			each.left = null;
    		}	
    	}
    	
    	
    }

    private void preOrder(TreeNode root){
    	preOrderList.add(root);
    	if (null!=root.left) {
    		preOrder(root.left);
    	}
    	if (null!=root.right) {
    		preOrder(root.right);
    	}
    	
    }
    private boolean add(TreeNode to, TreeNode from){
    	TreeNode end = from;
    	while (end.right!=null ) {
    		end = end.right;
    	}
    	end.right = to.right;
    	to.right = from;
    	return true;
    }
    

}