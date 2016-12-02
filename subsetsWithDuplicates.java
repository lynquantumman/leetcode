public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	if (0==nums.length) {
    		return new ArrayList<List<Integer>>();
    	}

    	ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    	
        Arrays.sort(nums);
        TreeMap<Integer,Integer> statistic = new TreeMap<Integer,Integer>();
        // statistic.put(nums[0]);
        // to make the statistic
        int count = 0;
        for (int i = 0;i<nums.length;i++) {
        	count++;
        	if(i==nums.length-1||(i+1<nums.length && nums[i]!=nums[i+1])){
        		statistic.put(nums[i],count);
        		count = 0;
        	}
        }

        // statistic.put(nums[nums.length-1], count-1);
        System.out.println("statistic"+statistic);
        for (int i = 0;i<=statistic.get(nums[0]);i++ ) {
        	recursiveAnsGenerate(statistic, ans, new ArrayList<Integer>(),
		    	nums[0],i);
        }
        

        return ans;
    }

    private void recursiveAnsGenerate(
    	TreeMap<Integer,Integer> statistic,
    	ArrayList<List<Integer>> ans, 
    	List<Integer> entry,
    	Integer k, int times){
    	// value is the total number of it.
    	Integer v = statistic.get(k);
    	
    	
		for (int i = 1;i<=times ;i++ ) {
			entry.add(k);
			System.out.println("add=="+k);
		}
		System.out.println("add over");
		if (null==statistic.higherKey(k)) {
			ans.add(new ArrayList<Integer>(entry));
			for (int i = 1;i<=times ;i++ ) 
				entry.remove(k);
			
		
			return;
		}

		for (int i = 0;i<=statistic.get(statistic.higherKey(k));i++ ) {
			recursiveAnsGenerate(statistic, ans, entry, 
				statistic.higherKey(k),i);
		}
		
		
		for (int i = 1;i<=times ;i++ ) {
			entry.remove(k);
			
		}
    	

		return;
    }
}