public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	int[] okay1D = new int[9];
    	Arrays.fill(okay1D,0);
    	for (int i = 0;i<board.length;i++) {
    		for(int j = 0;j<board.length;j++){
    			if(49<=board[i][j])
    				okay1D[board[i][j]-49]+=1; 
    		}
    		if(!check(okay1D)){
    			System.out.println(i);
    			System.out.println("1");
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
    			System.out.println("2");
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
    				System.out.println("3");
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

"..4...63."
".........",
"5......9.",
"...56....",
"4.3.....1",
"...7.....",
"...5.....",
".........",
"........."]

["....5..1."
,".4.3....."
,".....3..1"
,"8......2."
,"..2.7...."
,".15......"
,".....2..."
,".2.9....."
,"..4......"]