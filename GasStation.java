public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int len = gas.length;
        int[] diff = new int[len];
        for (int i = 0;i<len;i++ ) {
        	diff[i] = gas[i] - cost[i];
        }	
        int fast = 0;
        int slow = 0;
        while(true){
        	if (tempSum<0) {
        		tempSum-=diff[slow%len];
        		slow++;
        	}
        	if (tempSum>=0) {
        		tempSum+=diff[fast%len];
        		fast++;
        	}
        	if (fast-slow>=len) {
        		break;
        	}
        }
        return slow;
    }
}