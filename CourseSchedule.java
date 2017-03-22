public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // delete lines are [-1,-1]
    	TreeSet<Integer> startSet = new TreeSet<Integer>();
        startPointSift(prerequisites, startSet);
        int toRemoveStartPoint = 0;
        while(!startSet.isEmpty()){
        	while(!startSet.isEmpty()){
        		
        		toRemoveStartPoint = startSet.pollFirst();
        		removeSpecificLine(prerequisites,toRemoveStartPoint);

        	}
        	startPointSift(prerequisites,startSet); 
        }
        return isEmpty(prerequisites);
    }

    private void removeSpecificLine(int[][] prerequisites,int ele){
    	for (int i =0;i<prerequisites.length ;i++ ) {
    		if(prerequisites[i][1]==ele){
    			prerequisites[i][0] = -1;
    			
    		}
    			
    	}

    }

    private void startPointSift(int[][] prerequisites, TreeSet<Integer> startSet){
    	
    	TreeSet<Integer> endSet = new TreeSet<Integer>();
    	for (int i = 0;i<prerequisites.length ;i++ ) {
    		if (prerequisites[i][0]!=-1) {
    			startSet.add(prerequisites[i][1]);
    			endSet.add(prerequisites[i][0]);
    		}
    		
    	}
    	startSet.removeAll(endSet);
    	
    }

    private boolean isEmpty(int[][] prerequisites){
    	for (int i = 0;i<prerequisites.length ;i++) {
    		if(prerequisites[i][0]!=-1)
    			return false;
    	}
    	return true;
    }
}