public class Solution {
	int totalRow;
    int totalCol;
    final int ROW = 0;
    final int COL = 1;
    public List<Integer> spiralOrder(int[][] matrix) {
    	int totalRow = matrix.length-1;
    	int totalCol = matrix[0].length-1;
        List<Integer> ans = new List<Integer>();
        int[] startPosition = {0,0};
    	int[] rightDown = {totalRow-startPosition[ROW] ,totalCol-startPositon[ROW]};

        while(startPosition[ROW]<=rightDown[ROW]&&startPosition[COL]<=rightDown[COL]){
        	ans.addAll(rectRead(matrix,startPosition,rightDown));
        	startPosition = {startPosition[ROW]+1,startPosition[COL]+1};
        	rightDown = {totalRow-startPosition[ROW] ,totalCol-startPositon[COL]};
        }
    }

    private List<Integer> rectRead(int[][] matrix, int[] startPosition,int[] rightDown){
    	List<Integer> rect = new List<Integer>();
    	
    	int[] rightUp = {startPosition[ROW], totalCol-startPositon[COL]};
    	//rightDown is the input
    	int[] leftDown = {totalRow-startPosition[ROW], startPosition[COL]};
    	int[] leftUp = {startPosition[ROW]+1, startPosition[COL]};
    	// left to right
    	for(int j = startPosition[COL]; j<=rightUp[COL];j++){
    		rect.add(matrix[startPosition[ROW]][j]);
    	}
    	// up to down
    	for(int i = rightUp[ROW];i<=rightDown[ROW];i++){
    		rect.add(matrix[i][rightDown[COL]]); 
    	}

    	// right to left
    	for(int j = rightDown[COL]; j>=leftDown[COL];j--){
    		rect.add(matrix[leftDown[ROW]][j]);
    	}
    	
    	// down to up
    	for(int i = leftDown[ROW];i>=leftUp[ROW];i--){
    		rect.add(matrix[i][leftDown[COL]]); 
    	}

    }
}