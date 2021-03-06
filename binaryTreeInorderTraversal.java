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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();

        TreeNode cur = root;
        while(cur!=null || !stk.empty()){
        	while(cur!=null){
        		stk.push(cur);
        		cur = cur.left;
        	}
        	cur = stk.pop();
        	ans.add(cur.val);
        	cur = cur.right;
        }
        return ans;
    }
}