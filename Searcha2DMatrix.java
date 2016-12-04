public class Solution {
	int target;
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (0==matrix.length) {
    		return false;
    	}
    	this.target = target;
        int[] small = {0,0};
        int[] big = {matrix.length-1, matrix[0].length-1};
        return binarySearchMatrix(matrix, small, big);

    }

    public void midPoint(int width, int[] small, int[] big, int[] mid){
    	// 这里求出的中位数是下中位数
    	int total = (big[0]*width+big[1]+small[0]*width+small[1])/2;
    	mid[0] = total/width;
    	mid[1] = total%width;
    }

    public boolean binarySearchMatrix(int[][] matrix, int[] small, int[] big){
    	int[] mid = new int[2];
    	int width = matrix[0].length;
    	midPoint(width, small, big, mid);
    	if (small[0]*width+small[1]>big[0]*width+big[1]) {
    		return false;
    	}
    	if (target==matrix[mid[0]][mid[1]]) {
    		return true;
    	}
    	else if (target<matrix[mid[0]][mid[1]]) {
    		
    		smallerOne(width,big,mid);
    		midPoint(width, small, big, mid);
    		return binarySearchMatrix(matrix, small, big);
    	}
    	else  {
    		
    		biggerOne(width,small,mid);
    		midPoint(width, small, big, mid);
    		return binarySearchMatrix(matrix, small, big);
    	}
    }

    public void smallerOne(int width, int[] ans,int[] mid){
    	int total = mid[0]*width+mid[1]-1;
    	ans[0] = total/width;
    	ans[1] = total%width;
    }

    public void biggerOne(int width, int[] ans, int[] mid){
    	int total = mid[0]*width+mid[1]+1;
    	ans[0] = total/width;
    	ans[1] = total%width;
    }
}