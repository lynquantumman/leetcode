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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<LinkedList<Integer>> needToAdd = pathSumRecursive(root,sum);
        for (LinkedList<Integer> each:needToAdd) {
        	List<Integer> temp = each;
        	ans.add(each);
        }
        return ans;
    }

    private LinkedList<LinkedList<Integer>> pathSumRecursive(TreeNode root, int sum){
    	LinkedList<LinkedList<Integer>> ans = new LinkedList<LinkedList<Integer>>();
    	if (null==root) {
        	return ans;
        }
        if (null==root.left && null==root.right) {
        	if (sum==root.val) {
        		LinkedList<Integer> ele = new LinkedList<Integer>();
        		ele.addFirst(root.val);
        		ans.addFirst(ele);
        		return ans;
        	}
			else{
				return ans;
			}       
        }
        if (null!=root.left) {
        	ans.addAll(pathSumRecursive(root.left, sum-root.val));
        }
        if (null!=root.right) {
        	ans.addAll(pathSumRecursive(root.right,sum-root.val));
        }

        for (LinkedList<Integer> each:ans) {
        	each.addFirst(root.val);
        }

        return ans;
    }
}