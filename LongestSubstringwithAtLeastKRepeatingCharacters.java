public class Solution {
    char[] ca;
    int k;
    public int longestSubstring(String s, int k) {
    	this.k = k;
        this.ca = s.toCharArray();

        return helper(0,this.ca.length);
    }

    private int helper(int start,int end){
    	if(end-start<k)
    		return 0;
    	// build hash code
    	int[] hashCode = new int[26];
    	for (int i = start;i<end;i++ ) {
    		hashCode[this.ca[i]-'a']++;
    	}

    	boolean flag = false;
    	for (int i = 0;i<26;i++) {
    		if (hashCode[i]>=k) {
    			flag = true;
    		}
    	}
    	if (false==flag) {
    		return 0;
    	}
    	int longest = 0;
    	boolean split = false;
    	for (int i = start;i<end;i++) {
    		if(hashCode[this.ca[i]-'a']<k){
    			return Math.max(longest,Math.max(helper(start,i),helper(i+1,end)));
    			
    		}
    	}
    	
    	return end-start;
    	
    	
    }
}