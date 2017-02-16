/**
*try to find subsequences in S, such that the subsequence is same as T
*S = "rabbbit", T = "rabbit"
*return 3;
*the solution of this is quite amazing for using a 2 dimensional method to solve it
*/
public class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        if (0==m && 0==n) {
        	return 1;
        }
        int[][] ans = new int[n+1][m+1];
        for (int j = 0;j<=m ;j++ ) {
            ans[0][j] = 1;

        }

        for (int i = 1;i<=n ;i++) {
            for (int j = 1;j<=m;j++) {
                if (s.codePointAt(j-1)==t.codePointAt(i-1)) {
                    ans[i][j] = ans[i-1][j-1] + ans[i][j-1];
                }
                else ans[i][j] = ans[i][j-1];
            }
        }
        return ans[n][m];
    }
    
}