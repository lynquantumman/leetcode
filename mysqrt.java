public class Solution {
    public int mySqrt(int x) {
        // if(x<0){

        // }
        if(1==x || 0==x){
            return x;
        }

        int left = 1;
        int right = x;
        int mid = (int)(((long)left+(long)right)/2);
        while(left+1<right){
            long tempAns = (long)mid*(long)mid;
            if(tempAns>x){
                right = mid;
                mid = (left+right)/2;
            }
            else if(tempAns<x){
                left = mid;
                mid = (left+right)/2;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}