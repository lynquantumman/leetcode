public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ans = new ArrayList<Integer>();
    	if(matrix.length==0){
    		return ans;
    	}
    	int totalRow = matrix.length;
    	int totalCol = matrix[0].length;
        //the first row
        for (int i = 0;i<matrix[0].length ;i++ ) {
            ans.add(matrix[0][i]);
        }
        
        //to low and to the right side is positive
        int[][] direct = {{1,0},{0,-1},{-1,0},{0,1}};
        //how many integers are there needed to be added to the ans
        int total = (matrix.length-1)*matrix[0].length;
        //增加转向次数、向前步数的概念
        int turnTimes = 0;
        int[] forwardSteps = {totalRow-1,totalCol-1};
        int row = 0;
        int col = matrix[0].length-1;
        int stepCount = forwardSteps[0];
        for (;total>0;total--) {
            --stepCount;
            row = row+direct[turnTimes][0];
            col = col+direct[turnTimes][1];
            ans.add(matrix[row][col]);
            //the difference between forwardSteps and step count 
            if(stepCount==0){
                --forwardSteps[turnTimes%2]; 
                turnTimes = (turnTimes+1)%4;
                stepCount = forwardSteps[turnTimes%2];
            }
        }

        return ans;
        
    }
    
}