public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length()==0&&p.length()==0){
            return true;
        }
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;

        for(int i = 0;i<p.length();i++){
            if(p.charAt(i)=='*')
                dp[i+1][0] = dp[i-1][0];
        }


        for(int i = 0;i<p.length();i++){
            for(int j = 0;j<s.length();j++){
                if(p.charAt(i)==s.charAt(j)||p.charAt(i)=='.'){
                    dp[i+1][j+1] = dp[i][j]; 
                }
                if(p.charAt(i)=='*'&&(p.charAt(i-1)==s.charAt(j)||p.charAt(i-1)=='.')){
                    dp[i+1][j+1] = dp[i][j+1]||dp[i+1][j]||dp[i-1][j+1];
                }
                else if(p.charAt(i)=='*'){
                    dp[i+1][j+1] = dp[i-1][j+1];
                }
            }
        }
//        System.out.println(dp[p.length()-1][s.length()-1]);
//        System.out.println(dp[p.length()-1][s.length()]);
//        System.out.println(dp[p.length()][s.length()-1]);
//        System.out.println(dp[p.length()-2][s.length()]);
        return dp[p.length()][s.length()];
    }
}