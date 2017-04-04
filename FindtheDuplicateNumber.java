public class Solution {
    public int findDuplicate(int[] nums) {
        int hare = nums[0];
        int turtle = nums[0];
        hare = nums[nums[hare]];
        turtle = nums[turtle]; 
        while(hare!=turtle){
        	hare = nums[nums[hare]];
        	turtle = nums[turtle]; 
        }
        
        int newStart = nums[0];
        while(newStart!=turtle){
        	newStart = nums[newStart];
        	turtle = nums[turtle];

        }
        return turtle;
    }
}