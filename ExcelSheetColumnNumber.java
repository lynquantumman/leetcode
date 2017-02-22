public class Solution {
    public int titleToNumber(String s) {
    	int len = s.length();
    	int res = 0;
        for (int i = 0;i<=len-1;i++ ) {
        	res += pow(26,len-1-i)*(s.codePointAt(i)-'A'+1);
        }
        return res;
    }
    private int pow(int di, int mici){
    	int prod = 1;
    	for (int i = 1;i<=mici;i++) {
    		prod = prod*di;
    	}
    	return prod;
    }
}