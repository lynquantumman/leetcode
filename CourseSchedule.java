public class Solution {
    class preEle{
        int start;
        int end;
        public preEle(int left,int right){
            end = left;
            start = right;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // delete lines are [-1,-1]
        HashSet<Integer> startSet = new HashSet<Integer>();
        Comparator<preEle> cmp1 = new Comparator<preEle>(){
            @Override
            public int compare(preEle a, preEle b){
                return a.start-b.start;
            }
        };
        Comparator<preEle> cmp2  = new Comparator<preEle>(){
            @Override
            public int  compare(preEle a, preEle b){
                return a.end-b.end;
            }
        };
        cmp1 = cmp1.thenComparing(cmp2);
        TreeSet<preEle> preConSet = new TreeSet<preEle>(cmp1);
        for (int i = 0;i<prerequisites.length;i++) {
            preConSet.add(new preEle(prerequisites[i][0],prerequisites[i][1]));
        }
        
        while(startPointSift(preConSet,startSet)){
            
            removeSpecificLine(preConSet,startSet);
            
        }
        return preConSet.isEmpty();
    }

    private void removeSpecificLine(TreeSet<preEle> preConSet,HashSet<Integer> startSet){
        TreeSet<preEle> toRemove = new TreeSet<preEle>(preConSet);
        for (preEle each:preConSet) {
            if(startSet.contains(each.start) ){
                toRemove.add(each);
                
            }
            
        }
        preConSet.removeAll(toRemove);
        startSet.clear();   
    }

    private Boolean startPointSift(TreeSet<preEle> preConSet, HashSet<Integer> startSet){
        
        
        for (preEle each:preConSet) {
            
            startSet.add(each.start);
                
            
        }

        for (preEle each:preConSet) {
            
            startSet.remove(each.end);
            
        }
        return !startSet.isEmpty();
        
    }

    
}