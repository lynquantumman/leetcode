import java.util.StringTokenizer;
public class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        String ans = "";
        while(st.hasMoreTokens()){
        	ans = st.nextToken()+" "+ans;
        }
        ans = ans.trim();
        return ans;
    }
}