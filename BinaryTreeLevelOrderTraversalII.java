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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> everyRow = new LinkedList<TreeNode>();;
		LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
		everyRow.offer(root);
		int fatherCount = everyRow.size();
		while(0!=fatherCount){

			List<Integer> ele = new ArrayList<Integer>();
			for (int i = 0;i<fatherCount;i++) {
				TreeNode father = everyRow.poll();
				if (father!=null) {
					if (father.left!=null) {
						everyRow.add(father.left);
					}
					if (father.right!=null) {
						everyRow.add(father.right);
					}
					ele.add(father.val);
				}
				
			}
			fatherCount = everyRow.size();
			if (0!=ele.size()) {
				ans.addFirst(ele);
			}
			
		}
			
		return ans;
    }
}