public class Solution{

	public List<List<Integer>> levelOrder(TreeNode root){
		Queue<TreeNode> everyRow = new LinkedList<TreeNode>();;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
				ans.add(ele);
			}
			
		}
			
		return ans;
	}

}


