/*
Given an array of integers,
every element appears three times except for one, 
which appears exactly once. Find that single one.

*/
public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for(int each:nums){
        	one=(~two)&(one^nums[i]);
        	two=(~two)&(two^nums[i]);
        }
        return one;
    }
}