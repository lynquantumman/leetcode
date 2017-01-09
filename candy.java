
//1,2,3,4,5
//7,8,9,12	ratings[i] - min(ratings) + 1, then we get 1,2,3,6
//7,8,9,12,12 -------1,2,3,1
//12,7,8,9,12 -------2,1,2,3,4
// 1,2
public class Solution {
    public int candy(int[] ratings) {
        int minIndex = findMinIndex(ratings);
        int sumCandy = 0;
        //左侧遍历
        int candyThisChild = 1;
        sumCandy += candyThisChild;
        for (int i = minIndex;0<=i;i-- ) {
        	if (0<=i-1) {
        		if(ratings[i-1]<ratings[i]){
	        		candyThisChild--;
	        	}
	        	else if(ratings[i-1]>ratings[i]){
	        		candyThisChild++;
	        	}
	        	else if (ratings[i]==ratings[i-1]) {
	        		candyThisChild = 1;
	        	}
	        	
	        	sumCandy+=candyThisChild;
        	}
        	

        }
        candyThisChild = 1;
        //右侧遍历
        for (int i = minIndex;i<ratings.length;i++ ) {
        	if (i+1<ratings.length) {
        		if(ratings[i]<ratings[i+1]){
	        		candyThisChild++;
	        	}
	        	else if(ratings[i]>ratings[i+1]){
	        		candyThisChild--;
	        	}
	        	else if (ratings[i]==ratings[i+1]) {
	        		candyThisChild = 1;
	        	}
	        	sumCandy+=candyThisChild;
        	}

        	
        }
        return sumCandy;
    }

    private int findMinIndex(int[] ratings){
    	int min = Integer.MAX_VALUE;
    	int minIndex = 0;
    	for (int i = 0;i<ratings.length;i++ ) {
    		if (ratings[i]<min) {
    			min = ratings[i];
    			minIndex = i;

    		}
    	}
    	return minIndex;
    }


}