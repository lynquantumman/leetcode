public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null==matrix||0==matrix.length||0==matrix[0].length) {
        	return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0){
        	if (target==matrix[row][col]) {
        		return true;
        	}
        	else if (target<matrix[row][col]) {
        		col--;
        	}else {
        		row++;
        	}
        }
        return false;
    }
}