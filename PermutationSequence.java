public class Solution {
    public String getPermutation(int n, int k) {

        int[] out = new int[n];
        for (int i = 1;i<=n ;i++ ) {
            out[i-1] = i; 
        }
        for(int i = 2;i<=k;i++){
            nextPermutation(out);
        }
        String ans = "";
        for (int each:out ) {
            ans=ans+each;
        }
        return ans;
    }

    public void nextPermutation(int[] nums){
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

        if(changed==false){
            Arrays.sort(nums);
        }
    }
    
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


