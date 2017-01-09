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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder.length==0||inorder.length==0) {
    		return null;
    	}
        return buildTreeRecursive(preorder,  0, preorder.length,
    	 inorder,  0,  inorder.length);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int startPre, int endPre,
    	int[] inorder, int startIn, int endIn){
    	if (startPre>=endPre || startIn>=endIn) {
    		return null;
    	}
    	int mid = find(preorder[startPre],inorder,startIn,endIn);
    	int len = mid - startIn;
    	TreeNode root = new TreeNode(preorder[startPre]);

    	root.left = buildTreeRecursive(preorder, startPre+1, startPre+1+len,
    		 inorder, startIn, mid);
    	root.right = buildTreeRecursive(preorder, startPre+1+len, endPre,
    		 inorder, mid+1, endIn);
    		 return root;
    }

    private int find(int target,int[] array, int start, int end){
    	for (int i = start;i < end;i++) {
    		if(array[i]==target)
    			return i;
    	}
    	return -1;
    }
}