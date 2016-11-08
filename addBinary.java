public class Solution {
    public String addBinary(String a, String b) {
    	int ans_length = Math.max(a.length(),b.length());
    	int in = 0;
    	String ans = "";
    	int temp;
        for(int i = 0;i<ans_length+1;i++){
        	temp = in+get(a,i)+get(b,i);
        	ans = Integer.toString(temp%2,10)+ans;
        	in = temp/2;
        }
        if(ans.charAt(0)=='0'){
        	ans = ans.substring(1);
        }
        return ans;
    }
    //reverse_ith is like 6543210
    private int get(String input, int reverse_ith){
    	if(input.length()>reverse_ith){
    		return input.codePointAt(input.length()-1-reverse_ith)-'0';
    	}
    	else {
    		return 0;
    	}
    }
}