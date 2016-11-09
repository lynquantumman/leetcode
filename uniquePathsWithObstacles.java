public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int depth = obstacleGrid.length;
    	int width = obstacleGrid[0].length;
        int[][] dp = new int[depth][width];
        // for(int i = 0;i<depth;i++){
        // 	Arrays.fill(dp[i],0);
        // }
		//dp[][]第一行的初始化
        for(int j = 0;j<width;j++){
        	if(obstacleGrid[0][j]==1){
        		break;
        	}
        	dp[0][j] = 1; 
        }
        //dp[][]第一列的初始化
        for(int i = 0;i<depth;i++){
        	if(obstacleGrid[i][0]==1){
        		break;
        	}
        	dp[i][0] = 1;
        }

        for(int i = 1;i<depth;i++){
        	for(int j = 1;j<width;j++){
        		// int up = obstacleGrid[i-1][j]==1?0:dp[i-1][j];
        		// int left = obstacleGrid[i][j-1]==1?0:dp[i][j-1];

        		dp[i][j] = obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
        	}
        }

        return dp[depth-1][width-1];
    }
}