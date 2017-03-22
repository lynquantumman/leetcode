public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] ans = new boolean[s.length()+1];
    	ans[0] = true;
    	for(int i = 1;i<=s.length();i++){
    		for (int j = 0;j<i;j++ ) {
    			if (ans[j]==true && wordDict.contains(s.substring(j,i))) {
    				ans[i] = true;
    			}
    		}
    	}
    	return ans[s.length()];
        
    }
}
