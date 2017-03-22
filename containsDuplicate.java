public class Solution {
    public boolean containsDuplicate(int[] nums) {
    	Hashtable<Integer,Boolean> ht = new Hashtable<Integer,Boolean>();
        for (int each : nums) {
        	if(ht.containsKey(each))
        		return true;
        	else
        		ht.put(each,true);
        }
        return false;
    }
}