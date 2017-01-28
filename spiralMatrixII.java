public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        for (int i = 0;i<n ;i++ ) {
        	ans[0][i] = i+1;
        }

        int[] len = {n-1,n-1};
        int[][] direct = {{1,0},
        				{0,-1},
        				{-1,0},
        				{0,1}}; 
        int dir = 0;
        int col = n-1;
        int row = 0;
        int[] lenCount = {0,0};
        for (int i = n+1;i<=n*n;i++) {
        	row = row+direct[dir%4][0];
        	col = col+direct[dir%4][1];
        	ans[row][col] = i;
        	lenCount[dir%2]++;
        	if (lenCount[dir%2]==len[dir%2]) {
        		lenCount[dir%2] = 0;
        		len[dir%2]--;
        		dir++;
        	}
        }
        return ans;
    }
}