/**
*DFS
**/
public class Solution {

    public boolean exist(char[][] board, String word) {
    	if (board.length==0) {
    		return "".equals(word);
    	}
        for (int i = 0;i<board.length;i++) {
        	for (int j = 0;j<board[0].length;j++) {
        		if(board[i][j]==word.charAt(0))
        			if (true==judge(board, word,i,j,0)) {
        				return true;
        			}
        	}
        }
        return false;
    }
    private void stateShift(char[][] input,int i, int j){
    	// the char in java is of 2 bytes.
    	return input[i][j]^256 ;
    }

    

    private boolean judge(char[][] board, String word,
     int i, int j,int th){
     	boolean isStateOk = isPositionOK(board, word, i, j, th);
    	
    		
    	
    	
		if(isStateOk){
			if (th==word.length()-1) {
				return true;
			}

			stateShift(board, i,j);
			boolean ans = judge(board, word, i-1, j, th+1)||
				judge(board, word, i+1, j, th+1)||
				judge(board, word, i, j+1, th+1)||
				judge(board, word, i, j-1, th+1);
			stateShift(board,i,j);
			return ans;
		}
		else
			return false;
    	

    	
    }
    private boolean isPositionOK(char[][] board, String word,
     int i, int j,int th){
    	if (i<0 || i>=board.length) {
    		return false;
    	}
    	if (j<0 || j>=board[0].length) {
    		return false;
    	}
    	return word.charAt(th)==board[i][j];
    }
}