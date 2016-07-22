/*
@desc  Given a set of distinct positive integers, 
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine. 
@author Cradle Lee
*/

import java.util.*;
class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	//situation of there is only one element in nums;
    	if(nums.length==1){
    		List<Integer> ans = new LinkedList<Integer>();
    		ans.add(nums[0]);
    		return ans;
    	}

    	Arrays.sort(nums);
    	//use dynamic programming to 
    	TreeMap<Integer,Set<Integer>> tm = new TreeMap<Integer,Set<Integer>>();
    	tm.put(-1, new TreeSet<Integer>());
    	//System.out.println(tm);
    	for(int x:nums){
    		int temp = -1;
    		for(int i=0;nums[i]<x;i++){//use the numbers in nums, AkA the key in TreeMap to search
    			
    			if(x%nums[i]==0)//compare the size of the set, return the key
    				temp = tm.get(nums[i]).size()>=tm.get(temp).size()?nums[i]:temp;
    			//get the key whose set  is the biggest set, and key is small than x and can divide x
    		}
    		//System.out.println("put x"+x+temp+tm.get(temp));
    		//System.out.println(tm);
    		//System.out.println("==========");
    		//tm.put(x, tm.get(temp));
    		//System.out.println(tm);
    		//System.out.println("***********x="+x);
    		//tm.get(x).add(x);//great caution here.*******************************************
    		Set<Integer> out = new TreeSet<Integer>(tm.get(temp));
    		out.add(x);
    		tm.put(x, out);
    		//System.out.println(out);
    	}
    	//System.out.println(tm);
        //search the set with the biggest size();
        Set<Integer> bigSet = new TreeSet<Integer>(); 
        for(int x:nums){
            bigSet = tm.get(x).size()>bigSet.size()?tm.get(x):bigSet;
        }


        return new ArrayList<Integer>(bigSet);
        
    } 
}

class LDSDemo{
	public static void main(String[] args){
		LargestDivisibleSubset lsd =  new LargestDivisibleSubset();
		int[] nums = {1,2,3,4,8,9};
		List<Integer> ans = lsd.largestDivisibleSubset(nums);
		System.out.println(ans);
	}

	/*public static void mapTest(){
		TreeMap<Integer,Set<Integer>> tm1 = new TreeMap<Integer,Set<Integer>>();
		Set<Integer> set1 = new TreeSet<Integer>();
		set1.add(1)
		tm1.put();
	}
	*/
}