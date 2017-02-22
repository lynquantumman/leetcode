// 从一圈的O开始探索，
public class Solution {
	int height = 0;
	int width = 0;
    public void solve(char[][] board) {
    	this.height = board.length;
    	if (0==height) {
    		return ;
    	}
    	this.width = board[0].length; 
    	// setting procejure
    	for (int j = 0;j<width;j++) {
    		judgeIfFlip(board,0,j);
    	}

    	for (int i = 0;i<height ;i++ ) {
    		judgeIfFlip(board,i,width-1);
    	}

    	for (int j = width-1;j>=0 ;j-- ) {
    		judgeIfFlip(board,height-1,j);
    	}

    	for (int i = height-1;i>=0 ;i-- ) {
    		judgeIfFlip(board,i,0);
    	}
// flipping procejure
    	for (int i = 0;i<height ;i++ ) {
    		for (int j = 0;j<width ;j++ ) {
    			board[i][j] = 'n'==board[i][j]?'O':'X';
    		}
    	}

    	

    }

    private void judgeIfFlip(char[][] board, int row, int col){
    	if (row<0||row>height-1||col<0||col>width-1) {
    		return;
    	}
    	if ('X'==board[row][col]) {
    		return ;
    	}
    	else if ('n'==board[row][col]) {
    		return ;
    	}
    	else {//'O' situation
    		board[row][col]='n';
    		// the addition of if clause is to avoid stack overflow
    		if (row>0&&row<height-1&&col-1>0&&col-1<width-1) {
    			judgeIfFlip(board,row,col-1);
    		}
			if (row-1>0&&row-1<height-1&&col>0&&col<width-1){
				judgeIfFlip(board,row-1,col) ;
			}
			if (row>0&&row<height-1&&col+1>0&&col+1<width-1){
				judgeIfFlip(board,row,col+1) ;
			}
			if (row+1>0&&row+1<height-1&&col>0&&col<width-1)
				judgeIfFlip(board,row+1,col);

    	}
    }
}