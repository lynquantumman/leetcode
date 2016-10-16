public class Solution {
    public int strStr(String haystack, String needle) {
    	if("".equals(needle)){
    		return 0;
    	}
    	char head = needle.charAt(0);
    	char tail = needle.charAt(needle.length()-1);

    	for(int end=haystack.length()-1;0<=end;end--){
    		if(haystack.charAt(end)==tail)
    			break;
    	}
    	int hayLen = hayLen+1;
    	boolean found = false;
        for(int i=0;i<hayLen;i++){
        	if(haystack.charAt(i)==head){
        		int j=1;
        		for(;j<needle.length()&&(i+j)<hayLen;j++){
        			if(haystack.charAt(i+j)!=needle.charAt(j)){
        				break;
        			} 
        		}
        		if(j==needle.length())
        			return i;

        		continue;
        	}
        }
        return -1;
    }
}