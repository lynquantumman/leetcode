public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //the situation considered here is about len1<len2
        if(len1>len2)
            return findMedianSortedArrays(nums2,nums1);
        /*[#,1,#,3,#,4,#]
         [#,3,#,4,#,6,#,8,#,13,#]
        the imagining situation is like this, the total positon of this
        is 2*len1+2*len2+2. The positons on the left side is len1+len2
        because there are 2 position will exactly be on the seperating
         positon. Therefore, suppose that nums1 seperating position will be 
         `seperate1`th(0 based), then nums2 `seperate2` posittion will be 
         len1+len2-`seperate1`
    
        the `seperate1` range from 0 to 2*len1.

        the `seperate1` position can be mapped to the position of 
        up median and down median
        down median = (`seperate1`-1)/2
        up median = `seperate1`/2


        */
        int low = 0;
        int high = 2*len1;
        int total = len1+len2;
        while(low<=high){
            int seperate1 = (high+low)/2;
            int seperate2 = total-seperate1;
            int left1 = seperate1==0?Integer.MIN_VALUE:nums1[(seperate1-1)/2];
            int right1 = seperate1==2*len1?Integer.MAX_VALUE:nums1[seperate1/2];
            int left2 = seperate2==0?Integer.MIN_VALUE:nums2[(seperate2-1)/2];
            int right2 = seperate2==2*len2?Integer.MAX_VALUE:nums2[seperate2/2];

            if(left1>right2)
                high = seperate1-1;
                seperate1 = (high-low)/2;
            else if(left2>right1)
                low = seperate1+1;
                seperate1 = (high-low)/2;
            else return (double)(Math.min(right1,right2)+Math.max(left2,left1))/2
        }
        return -1;
    }
}