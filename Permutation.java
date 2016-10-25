import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cradle Lee
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	   	
    	if(nums.length==1){
    		ans.add(toList(nums));
    		return ans;
    	}

    	Arrays.sort(nums);
    	boolean changed = true;
    	
    	while(changed){
    		ans.add(toList(nums));
    		changed = nextPermutation(nums);

    	}
    	return ans;
    	
    }
    
    private List<Integer> toList(int[] nums){
    	List<Integer> intList = new ArrayList<Integer>();
    	for (int index = 0; index < nums.length; index++)
    	{
    	    intList.add(nums[index]);
    	}
    	return intList;
    }
    
    private void swap(int[] nums,int i,int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    private boolean nextPermutation(int[] nums){
    	boolean changed = false;
    	for(int i=nums.length-1;i>=1;i--){
    		if(nums[i-1]<nums[i]){
    			for(int j=nums.length-1;j>=1;j--){
    				if(nums[i-1]<nums[j]){
    					swap(nums,i-1,j);
    					changed = true;
    					Arrays.sort(nums,i,nums.length);
    					break;
    				}
    			}
    			break;
    		}
    	}

    	return changed;
    }
}



