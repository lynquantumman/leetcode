public class Solution {
    public int numSquares(int n) {
        // 典型的static DP
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int j = 1;
        for (int i = 1;i<=n ;i++ ) {
        	j = 1;
        	while(i-j*j>=0){
        		dp[i] = Math.min(dp[i],dp[i-j*j]+1);
        		j++;
        	}
        }
        return dp[n];
    }
}