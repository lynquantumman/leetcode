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
    public List<TreeNode> generateTrees(int n) {
    	List<Integer> input = new ArrayList<Integer>();
    	List<TreeNode> ans = new ArrayList<TreeNode>();
    	for (int i = 1;i<=n;i++ ) {
    		input.add(i);
    	}
        for (int i = 0;i<n;i++ ) {
        	ans.add(recursiveGenerate(i,input));
        }
    }
    private TreeNode recursiveGenerate(int i_th,List<Integer> input){
    	TreeNode ans = new TreeNode(input.get(i_th));
    	// there's some problems here.
    	ans.left = recursiveGenerate(input.subList(0,i));
    	ans.right = recursiveGenerate(input.subList(i));
    	
    }

}