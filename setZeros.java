// Given a m x n matrix, if an element is 0, 
// set its entire row and column to 0. Do it in place.
 // constant space solution
// 123
// 087
// 936

// 123
// 107
// 193

// 003
// 087
// 067


public class Solution {
    public void setZeroes(int[][] matrix) {
    	if (0==matrix.length) {
    		return;
    	}
    	boolean isThereZero = false;
    	int i = 0;
    	int j = 0;
        for ( i = 0;i<matrix.length ;i++ ) {
        	for ( j = 0;j<matrix[0].length ;j++ ) {
        		if (0==matrix[i][j]) {
        			isThereZero = true;
        			break;
        		}
        	}
        	if (true==isThereZero) {
        		break;
        	}
        }
        if (!isThereZero) {
        	return;
        }
        int denoteI = i;
        int denoteJ = j;
        for ( i = i+1;i<matrix.length ;i++ ) {
        	for ( j = 0;j<matrix[0].length ;j++ ) {
        		if (j==denoteJ) {
        			continue;
        		}
        		if (0==matrix[i][j]) {
        			matrix[denoteI][j] = 0;
        			matrix[i][denoteJ] = 0;
        		}
        	}
        	
        }


        for (i = 0;i<matrix.length ;i++ ) {
        	if (i==denoteI) {
        		continue;
        	}
        	if (0==matrix[i][denoteJ]) {
        		for ( j = 0;j<matrix[0].length ;j++ ) {
        			if (j==denoteJ) {
        				continue;
        			}
        			matrix[i][j] = 0;
        		}
        	}
        	
        }

        for (j = 0;j<matrix[0].length ;j++ ) {
        	if (j==denoteJ) {
        		continue;
        	}
        	if (0==matrix[denoteI][j]) {
        		for ( i = 0;i<matrix.length ;i++ ) {
        			if (i==denoteI) {
        				continue;
        			}
        			matrix[i][j] = 0;
        		}
        	}

        }

        for (i = 0;i<matrix.length ;i++ ) {
        	matrix[i][denoteJ] = 0;
        }
        
        for (j = 0;j<matrix[0].length ;j++ ) {
        	matrix[denoteI][j] = 0;
        }

    }
}