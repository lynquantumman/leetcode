// Given a board with m by n cells,
 // each cell has an initial state live (1) or dead (0). 
 // Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 //  using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies, 
// as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population..
// Any dead cell with exactly three live neighbors becomes a live cell, 
// as if by reproduction.
// Write a function to compute the next state (after one update) of the board given its current state.


// next state 
// next generation dead is -1; alive is 2; 
public class Solution {
    public void gameOfLife(int[][] board) {
    	int numberAlive = 0;
        for (int i = 0;i<board.length ;i++ ) {
        	for (int j = 0;j<board[0].length ;j++ ) {
        		numberAlive = numberOfLive(board,i,j);
        		if (1==board[i][j]) { //alive situation
        		    numberAlive = numberAlive-1;
        			if(numberAlive<2)
        				board[i][j] = -1;
        			if (numberAlive>3) {
        				board[i][j] = -1;
        			}
        		}else{//dead situation
        			if (3==numberAlive) {
        				board[i][j] = 2;
        			}
        		}
        	}
        }

        for (int i = 0;i<board.length ;i++ ) {
        	for (int j = 0;j<board[0].length ;j++ ) {
        		
        		if (board[i][j]>0) { //alive situation
        			board[i][j] = 1;
        		}
        		else board[i][j] = 0;
        	}
        }

    }

    private int numberOfLive(int[][] board, int row,int col){
    	int count = 0;
    	for(int i = -1;i<=1;i++){
    		for (int j = -1;j<=1;j++) {
    			if( (0<=(row+i) &&
    				(row+i)<board.length &&
    				0<=(col+j) &&
    				(col+j)<board[0].length) &&
    				(board[row+i][col+j]==1 || board[row+i][col+j]==-1))
    				count++;
    		}
    	}
    	return count;
    }
}