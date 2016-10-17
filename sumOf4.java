public class Solution {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int tempTarget;
		int left, right;
		int lasti;
        for(int i=0;i<nums.length-3;i++){
        	tempTarget = target-nums[i];
        	lasti = nums[i];
        	left = i+1;
        	right = nums.length-1;
        	if(tempTarget<nums[left]*3){
    			break;
    		}
    		if(nums[right]*3<tempTarget){
    			continue;
    		}
        	List<List<Integer>> temp = threeSum(nums, left, tempTarget);
        	if(!temp.isEmpty())
        		ans.addAll(temp);
        	while(i+1<nums.length&&nums[i+1]==lasti){
        		i++;
        	}
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
    	ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
		int tempTarget;
    	
    	int left;
    	int right = nums.length-1;
    	int lasti;
        for(int i=start;i<nums.length-2;i++){
        	lasti = nums[i];
        	tempTarget= target-nums[i];
        	left = i+1;
        	
        	if(tempTarget<nums[left]*2){
    			break;
    		}
    		if(nums[right]*2<tempTarget){
    			continue;
    		}
        	
    		
        	ArrayList<List<Integer>> temp = doubleEndSearch(nums, left, right, tempTarget);
        	if(!temp.isEmpty())
        		ans.addAll(temp);
        	while(i+1<nums.length&&nums[i+1]==lasti){
        		i++;
        	}

        }
        return ans;
    }
    //to help to search nums[i]+nums[j]==tempTarget,
//   in which left<i,j<right, if this method find the answer, it will stop and return.
    private ArrayList<List<Integer>> doubleEndSearch(int[] nums, int left, int right, int target){
    	ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    	while(left<right){
    		int sum = nums[left]+nums[right];
    		int lastRight = nums[right];
    		int lastLeft = nums[left];
    		if(sum>target){
    			right--;
    			while(left<right&&nums[right]==lastRight){
    				lastRight = nums[right];
    				right--;
    			}
    		}
    		else if(sum<target){
    			left++;
    			while(left<right&&nums[left]==lastLeft){
    				lastLeft = nums[left];
    				left++;
    			}
    			
    		}
    		else{   			  			
    			List<Integer> intList = new ArrayList<Integer>();
    			intList.add(0-target);
    			intList.add(nums[left]);
    			intList.add(nums[right]);
    			ans.add(intList);   			
    			left++;
    			while(left<right&&nums[left]==lastLeft){
    				lastLeft = nums[left];
    				left++;
    			}
    			right--;
    			while(left<right&&nums[right]==lastRight){
    				lastRight = nums[right];
    				right--;
    			}
    		}
    	}
    	return ans;
    	
    }
}