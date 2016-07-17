/*
Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.
@author Cradle Lee
*/
import java.util.*;
class TwoSum{
	//1. we use map to save the input.
	//2. sort the Map according to the value
	//3. use 2 ends scanning method to tell the sum of which 2 equals the target.
	public static void main(String[] args){
		int[] input = {2, 7, 11, 15};
		int target = 9;
		//1.we use map to save the input.
		Map<Integer,Integer> inputMap = new TreeMap<Integer, Integer>();
		for(int i=0;i<input.length;i++){
			inputMap.put(i, input[i]);
		}

		//2.sort the Map according to the value
		//in the listInput, the key is the original indices
		Set<Map.Entry<Integer, Integer>> inputSet =  inputMap.entrySet();
		List<Map.Entry<Integer,Integer>> listInput = new ArrayList<Map.Entry<Integer,Integer>>(inputSet);
		Collections.sort(listInput, new Comparator<Map.Entry<Integer,Integer>>(){
			@Override
			public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
				return a.getValue()-b.getValue();
			}
		});

		//3. use 2 ends scanning method to tell the sum of which 2 equals the target.
		int left=0;
		int right = input.length-1;
		while(left<right){
			if(listInput.get(left).getValue()+listInput.get(right).getValue()>target){
				right--;
			}
			else if(listInput.get(left).getValue()+listInput.get(right).getValue()<target){
				left++;
			}
			else{
				break;
			}
		}

		//output phase
		left = listInput.get(left).getKey();
		right = listInput.get(right).getKey();
		System.out.println("answer is "+left+" "+right);
	}
}