public class Solution {
	int height = 0;
    public int minimumTotal(List<List<Integer>> triangle) {
        int this.height = triangle.size()-1;
        return minimumTotalRecursive(triangle,0,0);

    }
    private int minimumTotalRecursive(List<List<Integer>> triangle,int toTop,int toLeft){
    	if (toTop>this.height) {
    		return 0;
    	}
    	else{
    		return Math.min(minimumTotalRecursive(triangle,toTop+1,toLeft),
    			minimumTotalRecursive(triangle,toTop+1,toLeft+1))+triangle.get(toTop).get(toLeft);
    		
    	}
    }
}