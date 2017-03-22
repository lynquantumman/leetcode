// 12,128
// 9,91
// 0,0
public class Solution {
    public String largestNumber(int[] nums) {
    	String [] stringNums = new String[nums.length];
    	for (int i = 0;i<nums.length;i++) {
    		stringNums[i] = new String(String.valueOf(nums[i]));
    	}
    	Comparator<String> comparator  = new Comparator<String>(){
    		@Override
    		public int compare(String a,String b){
    			int i = 0;
    			int j = 0;
    			while(i<a.length() && j<b.length()) {
    				if (a.codePointAt(i)==b.codePointAt(j)) {
    					i++;
    					j++;
    				}
    				else {
    					return a.codePointAt(i)-b.codePointAt(j);
    				}
    			}
    			if (i>=a.length()&&j<b.length()) {
    				return compare(a,b.substring(j));
    			}
    			else if (i<a.length()&&j>=b.length()) {
    				return compare(a.substring(i),b);
    			}
    			else {
    				return 0;
    			}
    		}
    	};
    	Arrays.sort(stringNums,comparator);
    	String ans = "";
        for (int i = stringNums.length-1;i>=0;i--) {
        	ans = ans+stringNums[i];
        }
        int i = 0;
        while (i<ans.length()&&ans.codePointAt(i)=='0') {
        	i++;
        }
        ans = ans.substring(i);
        if (ans.equals("")) {
        	return "0";
        }
        return ans;
    }
}