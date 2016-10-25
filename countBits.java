
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        int delimiter = 2;
        int rightMoveTime = 0;
        int temp = 0;
        for(int i = 0;i<=num;i++){
            
            temp = i;
            if(i<delimiter){
                for(int j = 0;j<=rightMoveTime;j++){
                    if(temp&1==1){
                        ans[i]++;
                    }
                    temp = temp>>1;
                }
            }
            else{
                ans[i]=1;
                delimiter = delimiter<<1;
                rightMoveTime++;
            }
        }
        return ans;
    }
}