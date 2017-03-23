public class Solution {
    public int getSum(int a, int b) {
        // 进位等于后面两个数的与AB+B*in+A*in 
        // 本位等于后面三个数的异或
        int judge = 1;
        int in = 0;
        int ans = 0;

    	for(int i = 0;i<32;i++){
    		//本位
    		ans = ans|((a&judge)^(b&judge)^(in&judge));
    		//进位
    		in = (a&judge)&(b&judge)|(b&judge)&in|(a&judge)&in;
    		in = in<<1;
    		judge = judge<<1;
    	}
    	return ans;
    }
}