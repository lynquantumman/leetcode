/**
*_|_|_|
*_|_|_|
*use a structure like this to solve this question
*let the row be the s2
*let the collumn be s1
*the way from the left up corner to the right down corner means s3
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length()!=s3.length()){
    		return false;
    	}
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        // to simplify these code, we can decides the range of i,j 
        // depending on if dp[i][j] is true
        for (int i = 1;i<=s1.length();i++ ){
        	if(s1.charAt(i-1)==s3.charAt(i-1)){
        		dp[i][0] = true;
        	}
        	else break;
        }
        
        for (int j = 1;j<=s2.length();j++ ){
        	if(s2.charAt(j-1)==s3.charAt(j-1)){
        		dp[0][j] = true;
        	}
        	else break;
        }
        
        for (int i = 1;i<=s1.length();i++ ) {
        	for (int j = 1;j<=s2.length();j++ ) {
        		// s1的第i个字符
        		if (s1.charAt(i-1)==s3.charAt(i+j-1)) {
        			dp[i][j] = dp[i-1][j]||dp[i][j];
        		}
        		// s2的第j个字符
        		if (s2.charAt(j-1)==s3.charAt(i+j-1)) {
        			dp[i][j] = dp[i][j-1]||dp[i][j];
        		}
        	}
        }

        return dp[s1.length()][s2.length()];
    }
}