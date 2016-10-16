public class Solution {
    public int trap(int[] height) {
    	if(height.length==0){
    		return 0;
    	}
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int heightMax = Math.max(leftMax,rightMax);
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left<right){
        	if(leftMax<heightMax || leftMax==rightMax){
        		if(height[left]>leftMax){
	        		leftMax = height[left];
	        		heightMax = Math.max(leftMax,rightMax);
	        		if(leftMax!=heightMax ||leftMax==rightMax)
	        			left++;
	        	}
	        	else{
	        		System.out.println(leftMax - height[left]+"from left");
	        		ans+=(leftMax - height[left]);
	        		left++;
	        	}
        	}
        	else{
        		if(height[right]>rightMax){
        			rightMax = height[right];
        			heightMax = Math.max(leftMax,rightMax);
        			if(rightMax!=heightMax)
        				right--;//this part has a problem
        		}
        		else{
        			System.out.println(rightMax - height[right]+"from right");
        			ans+=(rightMax-height[right]);
        			right--;
        		}
        	}
        	
        }
        return ans;
        
    }
}