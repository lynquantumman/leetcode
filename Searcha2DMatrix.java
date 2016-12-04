public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (0==matrix.length) {
    		return false;
    	}
        int[] small = {0,0};
        int[] big = {matrix.length, matrix[0].length};
        binarySearchMatrix(matrix, small, big);

    }

    public void midPoint(int width, int[] small, int[] big, int[] mid){
    	int total = big[0]*width+big[1]+small[0]*width+small[1];
    	mid[0] = total/width;
    	mid[1] = total%width;
    }

    public boolean binarySearchMatrix(int[][] matrix, int[] small, int[] big){
    	int[] mid = new int[2];
    	
    }
}