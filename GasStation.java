public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int len = gas.length;
        if (1==len) {
        	return gas[0]-cost[0]>=0?0:-1;
        }
        int part1 = gas[0]-cost[0];
        int part2 = gas[1]-cost[1];
        int start1 = 0;
        int start2 = 1;
        int start = part1>=part2?start1:start2;
        int temp = 0;
        for (int i = 2;i<len;i++ ) {
        	temp = gas[i] - cost[i];
        	if(temp>0 && part2<0){
        		
        		part1 = part1+part2;
        		part2 = temp;
        		start2 = i;
        	}
        	else{
        		part2 = part2+temp;
        	}
        	
        	start = part1>=part2?start1:start2;
        }	
        
        return part2+part1>=0?start:-1;
        	
        
       
    }
}