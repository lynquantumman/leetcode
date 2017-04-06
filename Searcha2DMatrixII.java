public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int len = matrix.length;
    	return helper(matrix,target,0,len-1,0,len-1);

    }
    public boolean helper(int[][] matrix,int target,int left, int right,int top,int bottom){
    	// it might be necessary to seperate the odd and the even
    	if (right-left<=1||bottom-top<=1) {
    		boolean flag = false;
    		for (int i = left;i<=right;i++) {
    			for (int j = top;j<=bottom;j++) {
    				flag = (target==matrix[j][i])||flag;
    			}
    		}
    		return flag;
    	}
    	int centralRow = (bottom-top)/2;
    	int centralCol = (right-left)/2;
    	if (target==matrix[centralRow][centralCol]) {
    		return true;
    	}
        else if (matrix[centralRow][centralCol]<target) {
        	return helper(matrix,target,centralCol,right,centralRow,bottom)||
        	helper(matrix,target,centralCol,right,top,centralRow)||
        	helper(matrix,target,left,centralCol,centralRow,bottom);
        }
        else{//target<matrix[centralRow][centralCol]
        	return helper(matrix,target,left,centralCol,top,centralRow)||
        	helper(matrix,target,centralCol,right,top,centralRow)||
        	helper(matrix,target,left,centralCol,centralRow,bottom);
        }
    }
}