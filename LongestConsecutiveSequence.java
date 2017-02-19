// HashMap
public class Solution {
    public int longestConsecutive(int[] nums) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int left = 0;
    	int right = 0;
    	int result = 0;
    	int sum = 0;
        for (int i :nums ) {
        	if (!map.containsKey(i)) {
        		left = map.containsKey(i-1)?map.get(i-1):0;
        		right = map.containsKey(i+1)?map.get(i+1):0;

        		sum = left+right+1;
        		map.put(i,sum);
        		result = Math.max(result,sum);
        		map.put(i-left,sum);
        		map.put(i+right,sum);


        	}
        	else {
        		continue;
        	}
        }
        return result;
    }
}