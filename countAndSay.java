public class Solution {
    public String countAndSay(int n) {
    	String temp = "1";
        for(int i=1;i<n;i++){
        	temp = next(temp);
        }
        return temp;
    }
    private String next(String in){
    	String ans = "";
    	int pos = 0;
    	while(pos<in.length()){
    		int i = 1;
    		while(pos+1<in.length() && in.codePointAt(i-1)==in.codePointAt(i)){
    			i++;
    			pos++;
    		}
    		ans+=String.valueOf(i)+in.charAt(pos);
    		pos++;
    	}
    	return ans;
    }
}