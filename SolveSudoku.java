public class Solution {
	boolean found = false;
    public void solveSudoku(char[][] board) {
        sudokuRecersive(board, 0);
    }

    private void sudokuRecersive(char[][] board, int pos){
    	// System.out.println("pos"+pos);
    	if(!isValidSudoku(board)){
    		return;
    	}
    	if(pos>80){
    		this.found = true;
    		return;
    	}
    	
    	if ('1'<=board[pos/9][pos%9] && board[pos/9][pos%9]<='9') {
    		sudokuRecersive(board,pos+1);
    	}
		else if('.'==board[pos/9][pos%9]){
			//这里千万注意增加与删除，修改与恢复
			for (int i = 1;i<=9 ;i++ ){
				board[pos/9][pos%9] = Integer.toString(i).charAt(0);
				sudokuRecersive(board,pos+1);
				if (true==this.found) {
					return;
				}
				board[pos/9][pos%9] = '.';
    		}
    		
		}
		else{
			System.err.println("wrong");
		}
		    	
    }

    public boolean isValidSudoku(char[][] board) {
    	int[] okay1D = new int[9];
    	Arrays.fill(okay1D,0);
    	for (int i = 0;i<board.length;i++) {
    		for(int j = 0;j<board.length;j++){
    			if(49<=board[i][j])
    				okay1D[board[i][j]-49]+=1; 
    		}
    		if(!check(okay1D)){
    			// System.out.println(i);
    			// System.out.println("1");
    			return false;
    		}
    		Arrays.fill(okay1D,0);
    	}
    	for (int i = 0;i<board.length;i++) {
    		for(int j = 0;j<board.length;j++){
    			if(49<=board[j][i])
    				okay1D[board[j][i]-49]+=1; 

    		}
    		if(!check(okay1D)){
    			// System.out.println("2");
    			return false;
    		}
    		Arrays.fill(okay1D,0);
    	}

    	for (int i = 0;i<board.length;i+=3) {
    		for(int j = 0;j<board.length;j+=3){
    			for(int m = 0;m<3;m++){
    				for(int n = 0;n<3;n++){
    					if(49<=board[i+m][j+n])
    						okay1D[board[i+m][j+n]-49]+=1; 
    				}
    			}
    			if(!check(okay1D)){
    				// System.out.println("3");
    				return false;
    				
    			}
    			Arrays.fill(okay1D,0); 	
    		}	
    	}
    	return true;
    }
    private boolean check(int[] nums){
    	for(int i = 0;i<9;i++){
    		if(nums[i]>1)
    			return false;
    	}
    	return true;
    }
}