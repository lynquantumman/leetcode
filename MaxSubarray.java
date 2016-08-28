
/**
@describe Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
@author Cradle Lee
*/
package leetcode;

import java.util.ArrayList;

public class MaxSubarray{
	public static Integer[] valueOf(int[] input){
		Subarray temp =  new Subarray();
		Subarray max = new Subarray();
		int i;
		for(i=0;i<input.length;i++){
			if(temp.sum>=0){
				temp.al.add(input[i]);
				temp.sum+=input[i];
			}
			else{
				temp = new Subarray();
				temp.al.add(input[i]);
				temp.sum+=input[i];
			}
			if(max.sum<temp.sum){
				max=new Subarray(temp);
			}
		}
		int size = max.al.size();
		return max.al.toArray(new Integer[size]);
	}
	
}

class Subarray{
	public ArrayList<Integer> al;
	
	public int sum;
	public Subarray(){
		al = new ArrayList<Integer>();
		sum=0;
	}
	public Subarray(Subarray input){
		al = new ArrayList<Integer>(input.al);
		sum=input.sum;
	}
	
}


