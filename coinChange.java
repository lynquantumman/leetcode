// think of the impossible situation

public class Solution{
	public int coinChange(int[] coins, int amount){
		Arrays.sort(coins);
		int[] dp = new int[amount+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1;i<=amount ;i++ ) {
			for(int j = 0;j<coins.length;j++){
				if (i-coins[j]>=0 && Integer.MAX_VALUE!=dp[i-coins[j]]) {
					dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
					
				}else if (i-coins[j]>=0) {
					continue;
				}
				else{//when i-coins[j]<0
					break;
				}
			}
		}
		return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
	}
}
