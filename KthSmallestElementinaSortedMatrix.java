public class Solution {
	class Tuple{
		int row;
		int col;
		int val;
		public Tuple(int row,int col,int val){
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
    public int kthSmallest(int[][] matrix, int k) {
        // 看其处于对角线上哪两个元素之间
        int len = matrix.length;
        Comparator<Tuple> cmp = new Comparator<Tuple>(){
        	@Override
        	public int compare(Tuple a,Tuple b){
        		return a.val-b.val;
        	}
        };
    	PriorityQueue<Tuple> smallestHeap = new PriorityQueue<Tuple>(len,cmp);

    	for (int i = 0;i<len;i++ ) {
    		// matrix[0][i]
    		smallestHeap.add(new Tuple(i,0,matrix[i][0]));

    	}
    	Tuple temp;
    	for (int i = 1;i<k;i++ ) {
    		temp = smallestHeap.poll();
    		if (temp.col<len-1) {
    			smallestHeap.add(new Tuple(temp.row,temp.col+1,matrix[temp.row][temp.col+1]));
    		}
    		
    	}
    	return smallestHeap.poll().val;
    }
}