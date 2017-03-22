public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0;i<grid.length ;i++) {
        	for (int j = 0;j<grid[0].length ;j++ ) {
        		if ('1'==grid[i][j]) {
        			count++;
        			set(grid,i,j);
        		}
        	}
        }
        return count;
        
    }
    private void set(char[][] grid,int i,int j){
    	if (i<0||i>=grid.length || j<0||j>=grid[0].length) {
    		return;
    	}

    	if ('1'==grid[i][j]) {
    		grid[i][j] = 'x';
    		set(grid,i,j+1);
    		set(grid,i-1,j);
    		set(grid,i,j-1);
    		set(grid,i+1,j);
    	}
    }
}