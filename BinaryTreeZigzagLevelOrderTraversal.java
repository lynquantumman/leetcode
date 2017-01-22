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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> everyRow = new LinkedList<TreeNode>();;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		everyRow.offer(root);
		int fatherCount = everyRow.size();
		while(0!=fatherCount){
// 从左侧往右侧添加
			List<Integer> ele = new ArrayList<Integer>();
			for (int i = 0;i<fatherCount;i++) {
				TreeNode father = everyRow.pollFirst();
				if (father!=null) {
					if (father.left!=null) {
						everyRow.addLast(father.left);
					}
					if (father.right!=null) {
						everyRow.addLast(father.right);
					}
					ele.add(father.val);
				}
				
			}
			fatherCount = everyRow.size();
			if (0!=ele.size()) {
				ans.add(ele);
			}
			// 从右侧往左侧添加
			ele = new ArrayList<Integer>();
			for (int i = 0;i<fatherCount;i++) {
				TreeNode father = everyRow.pollLast();
				if (father!=null) {
					if (father.right!=null) {
						everyRow.addFirst(father.right);
					}
					if (father.left!=null) {
						everyRow.addFirst(father.left);
					}
					ele.add(father.val);
				}
				
			}
			fatherCount = everyRow.size();
			if (0!=ele.size()) {
				ans.add(ele);
			}
			
		}
			
		return ans;
    }
}

