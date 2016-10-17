
public class Solution {

    public int jump(int[] nums) {
    	int n = nums.length;
		if(n<2)return 0;
	 	int level=0,currentMax=0,i=0,nextMax=0;

	 	while(i<=currentMax){		//nodes count of current level>0
			level++;
			for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
				nextMax=Math.max(nextMax,nums[i]+i);
				if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level 
			}
			currentMax=nextMax;
	 	}
	 	return 0;
    }
}


