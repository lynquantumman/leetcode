public class Solution {
    public int uniquePaths(int m, int n) {
        return collect(m+n-2,Math.min(n-1,m-1));
    }
    private int collect(int a, int b){
        long up = 1;
        for(int i = a;i>a-b;i--){
            up*=(long)i;
        }

        long down = 1;
        for(int i = b;i>=1;i--){
            down*=(long)i;
        }

        return (int)(up/down);
    }
}