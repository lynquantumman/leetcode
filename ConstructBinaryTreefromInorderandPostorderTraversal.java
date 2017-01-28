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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRecursive(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode buildTreeRecursive(int[] inorder,
    	int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
    	

    	if (inEnd-inStart<=0 || postEnd-postStart<=0) {
    		return null;
    	}
    	TreeNode ans = new TreeNode(postorder[postEnd-1]);
    	int centerPosition = find(inorder,inStart,inEnd,postorder[postEnd-1]);
    	if (centerPosition==-1) {
    		System.out.println("error");
    	}
    	int postCenter = postStart+centerPosition-inStart; 
    	ans.left = buildTreeRecursive(inorder,inStart,centerPosition,postorder,postStart,postCenter);
    	ans.right = buildTreeRecursive(inorder,centerPosition+1,inEnd,postorder,postCenter,postEnd-1);
    	return ans;
    }

    private int find(int[] scope,int scopeStart, int scopeEnd, int target){
    	for (int i = scopeStart;i<scopeEnd;i++) {
    		if (target==scope[i]) {
    			return i;
    		}
    	}
    	return -1;
    }
}