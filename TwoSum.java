
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	
    	TreeMap<Integer,Integer> dictionary = new TreeMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			dictionary.put(i, nums[i]);
		}   
		
		Comparator<Map.Entry<Integer,Integer>>  cmp = 
				Map.Entry.<Integer, Integer>comparingByValue();
		cmp = cmp.thenComparing(Map.Entry.<Integer, Integer>comparingByKey());
		
		TreeSet<Map.Entry<Integer, Integer>> treeSet = new TreeSet<Map.Entry<Integer, Integer>>(cmp);
		treeSet.addAll(dictionary.entrySet());
		
		Iterator<Map.Entry<Integer, Integer>> deIter = treeSet.descendingIterator();
		Iterator<Map.Entry<Integer, Integer>> iter = treeSet.iterator();

		Map.Entry<Integer,Integer> right = deIter.next();
		Map.Entry<Integer,Integer> left = iter.next();
		int leftValue;
		int rightValue;
		while(deIter.hasNext() && iter.hasNext()){
			leftValue = left.getValue();
			rightValue = right.getValue();
			
			if(leftValue+rightValue>target){
				right = deIter.next();
			}
			else if(leftValue+rightValue<target){
				left = iter.next();
			}
			else{ 
					int[] ans = {left.getKey(),right.getKey()};
					return ans;
				}
		}
		int[] ans = {0,0};
		return ans;
    }
}