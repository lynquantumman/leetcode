/**
*@author this is another version of counting bits
*/
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i = 0;i<=num;i++){
        	ans[i] = countBitsOfSingleNumber(i);
        }
        return ans;
    }
    private int countBitsOfSingleNumber(int n){
    	int ans;
    	if(0==n){
    		return 0;
    	}
    	while(n!=0){
    		n = n&(n-1);
    		ans++;
    	}
    	return ans;
    }
}
