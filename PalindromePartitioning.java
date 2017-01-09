
public class Solution {
    public List<List<String>> partition(String s) {
    	List<List<String>> ans = new ArrayList<List<String>>();
    	List<String> done = new ArrayList<String>();
    	partitionRecursive(ans, done, s, 0);
    	return ans;
        
    }
    private boolean isPalindrome(String s, int start, int end){
    	int len = end-start;
    	if (0==len) {
    		return false;
    	}
    	int halfOfLen = (int)Math.ceil((double)len/2.0);
    	boolean ans = true;
    	for (int i = 0;i<halfOfLen;i++) {

    		if(s.charAt(start+i)!=s.charAt(end-1-i))
    			ans = false;
    	}
    	return ans;
    }

    private void partitionRecursive(List<List<String>> ans, List<String> done, String s,int start){
    	if (start==s.length()) {
    		ans.add(done);
    		return;
    	}
    	else{
    		for (int i = start;i<s.length();i++ ) {
    			if (isPalindrome(s,start,i+1)) {
    				List<String> doneCopy = new ArrayList<String>(done);
    				doneCopy.add(s.substring(start,i+1));
    				partitionRecursive(ans,doneCopy,s,i+1);
    			}
    		}
    	}
    }
}