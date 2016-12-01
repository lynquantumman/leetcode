/**
*@desc for this problem, you need to consider '0',
*when a code starts with 0, the ans should be 0;
*when if the substring is "10", the ans should not be augmented.
*/
// 0
// 10
// 110
// 101
// 13724
// 1
// 230
public class Solution {
    public int numDecodings(String s) {
    	int len = s.length();
    	if(0==len) return 0;
    	if (1==len) {
    		return s.charAt(0)=='0'? 0 : 1;
    	}
    	int[] nums = new int[len+1];

    	nums[len] = 1;
    	
    	nums[len-1] = s.charAt(len-1)=='0'?0:1;
    	
    	for (int i = len-2 ;i>=0 ;i-- ) {
    		if ('0'==s.charAt(i)) {
    			continue;
    		}
    		else  {
    			
    			nums[i] = Integer.parseInt(s.substring(i,i+2))<=26?nums[i+2]+nums[i+1]:nums[i+1];		
    		}
    	}
       	return nums[0];
    }
}