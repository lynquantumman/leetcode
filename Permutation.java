package leetcode;
/**
 * @author Cradle Lee
 * @inputFormat 
 * 		ArrayList<Integer> prefix = new ArrayList<Integer>();
		
		Integer[] inputArray = {1,2,3,4};
		LinkedList<Integer> input = new LinkedList<Integer>(Arrays.asList(inputArray));
		
		int n=4;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
@outputFormat	result is a ArrayList<ArrayList<Integer>>
	and the ArrayList<Integer> in it is a permutation
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Permutation {
	
	public static void Creator(ArrayList<Integer> prefix, 
			LinkedList<Integer> input,
			int n,
			ArrayList<ArrayList<Integer>> result)
	{
		if(prefix.size()>=n){
			result.add(prefix);
			return;
		}
		int size = input.size();
		for(int i=0;i<size;i++){
			LinkedList<Integer> inputNext = new LinkedList<Integer>(input);
			ArrayList<Integer> prefixPlus = new ArrayList<Integer>(prefix);
			prefixPlus.add(inputNext.get(i));
			inputNext.remove(i);
			Creator(prefixPlus,inputNext,n,result);
		}
	}
}
