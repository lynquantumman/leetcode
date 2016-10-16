public class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;

        int positionLeft = 0;
        int positionRight = height.length-1;
        int left = height[positionLeft];
        int right = height[positionRight];
        int tempWater;
        final boolean LEFT = false;
        final boolean RIGHT = true;
        boolean smaller;
        while(positionLeft<positionRight){
            tempWater = Math.min(left, right)*(positionRight-positionLeft) ; 
            maxWater = Math.max(maxWater, tempWater);
            smaller = left<right?LEFT:RIGHT;
            if(smaller==LEFT){
                positionLeft++;             
            }
            else{
                positionRight--;
            }
            left = height[positionLeft];
            right = height[positionRight];
        }
        return maxWater;
    }
}