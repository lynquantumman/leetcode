//不要被n很小的情况蒙蔽了眼睛
public class Solution {
    public int numTrees(int n) {
    	int[] out = new int[n+1];
        out[0] = 1;
        out[1] = 1;
        for (int i = 2 ;i<=n ;i++ ) {
        	for (int mid = 1;mid<=i ;mid++ ) {
        		out[i] += out[mid-1]*out[i-mid];
        	}
        }
        return out[n];
    }  
}