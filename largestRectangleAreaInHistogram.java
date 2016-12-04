// the idea to solve this problem is to use the stack
// when the new comer is no less than the top element of the 
// stack, push it into the stack.
// when the new comer is smaller the top element of the stack, 
// continue pop the stack until the new comer is no less
// than the top element of the stack  
// a small trick to this is to add a zero to the end of the heights
// to clear the stack
// [2,1,2]
public class Solution {
    public int largestRectangleArea(int[] heights) {
    	int len = heights.length;
    	if (0==len) {
    		return 0 ;
    	}
    	int area = 0;
    	int maxArea = 0;
        Stack<Integer> stk = new Stack<Integer>();
        int hCurrentArray = 0;
        int hTopStk = 0;
        int left = 0;
        int right = 0;

        for (int i = 0;i<=len;i++ ) {//there is a problem here
        	// It is the position of the number that we should push
			hCurrentArray = i==len ? 0 : heights[i]; 	
    		while((!stk.empty() )&& hCurrentArray<heights[stk.peek()] ){
    			hTopStk = heights[stk.peek()];

    			stk.pop();
    			left = stk.empty()?-1:stk.peek();
    			right = i-1;
    			area = (right-left)*hTopStk;
    			maxArea = Math.max(area,maxArea);
    		}
    		stk.push(i);
        	
        }
    	
	   	return maxArea;
    }
}