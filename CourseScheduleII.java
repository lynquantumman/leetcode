public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	boolean adjMatrix[][] = new boolean[numCourses][numCourses];
    	for (int i = 0;i<prerequisites.length;i++) {
    		adjMatrix[prerequisites[i][1]][prerequisites[i][0]] = true; 
    	}

    	int[] ans = new int[numCourses];
    	//indegree process
        int[] indegree = new int[numCourses];
        for (int i = 0;i<prerequisites.length ;i++ ) {
        	indegree[prerequisites[i][0]]++;
        }



        int pos = 0;


        List<Integer> list = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0;i<numCourses;i++) {
        	if(0==indegree[i]){
        		list.add(i);

        		ans[pos] = i;
        		pos++;

        	}
        }
        while(!list.isEmpty()){
        	
	        

	        for (Integer each:list) {
	        	for (int i = 0;i<numCourses ;i++ ) {
	        		if(adjMatrix[each][i]==true){
	        			indegree[i]--;
	        			if(0==indegree[i]){
	        				temp.add(i);
	        				ans[pos] = i;
	        				pos++;
	        			}
	        		}
	        	}
	        	
	        }
	        list.clear();
	        list.addAll(temp);
	        temp.clear;
	       
        }
        
        if (pos==numCourses) {
        	return ans;
        }else{
        	return new int[0];
        }
        


    }
}