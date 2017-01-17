
//1,2,3,4,5
//7,8,9,12	ratings[i] - min(ratings) + 1, then we get 1,2,3,6
//7,8,9,12,12 -------1,2,3,1
//12,7,8,9,12 -------2,1,2,3,4
//1,2,4,4,3
//1,2,3,1,0
//
public class Solution {
    public int candy(int[] ratings) {
    	int len = ratings.length;
    	if (1==len) {
    		return 1;
    	}
        int [] children = new int[len];

        Arrays.fill(children,1);

        for (int i = 1;i<len;i++ ) {
        	if (ratings[i-1]<ratings[i]) {
        		children[i] = children[i-1]+1;
        	}
        	
        }
        int sum = children[len-1];
        for (int i = len-2;0<=i;i--) {
        	if (ratings[i]>ratings[i+1]) {
        		children[i] = Math.max(children[i],children[i+1]+1);
        	}
        	sum+=children[i];
        }
        return sum;

}