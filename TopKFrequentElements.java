/*
Given a non-empty array of integers, return the k most frequent elements.
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	Comparator<Map.Entry<Integer,Integer>> cmptor = Map.Entry.<Integer,Integer>comparingByValue();
    	cmptor = cmptor.thenComparing(Map.Entry.<Integer,Integer>comparingByKey());
        HashMap<Integer,Integer> dict = 
        	new HashMap<Integer,Integer>();
        int numberBefore = 0;
        for (int each:nums) {
        	if(!dict.containsKey(Integer.valueOf(each)))
        		dict.put(each,1);
        	else{
        		numberBefore = dict.get(each);
        		dict.put(each,numberBefore+1);
        	}
        }
        // 将其转换为entrySet
        List<Integer> ans = new ArrayList<Integer>();
        Set<Map.Entry<Integer,Integer>> entrySet = dict.entrySet();
        TreeSet<Map.Entry<Integer,Integer>> ts = new TreeSet<Map.Entry<Integer,Integer>>(cmptor);
        ts.addAll(entrySet);
        Iterator<Map.Entry<Integer,Integer>> iter = ts.descendingIterator();
        int i = 1;
        while(iter.hasNext()&&i<=k){
        	ans.add(iter.next().getKey());
        	i++;
        }
        return ans;
    }
}