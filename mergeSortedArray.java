public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] ans = new int[nums1.length];
    	int i = 0;
    	int j = 0;
    	for(int pos = 0;pos<ans.length;pos++){
    		
    		if(i<=m-1 && j<=n-1){
    			if(nums1[i]<nums2[j]){
	    			ans[pos] = nums1[i];
	    			i++;
    			}
	    		else {
	    			ans[pos] = nums2[j];
	    			j++;
	    		}
    		}
    		else if(i<=m-1 && j>n-1){
    			ans[pos] = nums1[i];
    			i++;
    		}
    		else if(i>m-1 && j<=n-1){
    			ans[pos] = nums2[j];
	    		j++;
    		}
    		else{
    			break;
    		}

    	}
    	
//    	nums1 = ans;
    	for(int pos = 0;pos<nums1.length;pos++){
    		nums1[pos] = ans[pos];
    	}
//    	System.out.println(nums1[0]);
    	for(int in:ans)
    		System.out.println(in);
    }

}