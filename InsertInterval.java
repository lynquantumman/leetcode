/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// using binary search to find the insert position
// the merge might happen from the previous position exactly
// before the insert position
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

    	Comparator<Interval> comparator = new Comparator<Interval>(){
    		@Override
    		public int compare(Interval a, Interval b){
        		return a.start-b.start;
        	}
    	};

    	comparator =  comparator.thenComparing(new Comparator<Interval>(){
    		@Override
    		public int compare(Interval a, Interval b){
    			return a.end-b.end;
    		}
    	});


        int insertPosition = Collections.binarySearch(intervals,newInterval,comparator);

        if (insertPosition>=0) {
        	return intervals;
        }
        else{
        	insertPosition = (-insertPosition)-1;
        }

        intervals.add(insertPosition,newInterval);

        merge(intervals,insertPosition);

        return intervals;
    }
    
    private void merge(List<Interval> intervals, int left){

    	
    	while(left+1<intervals.size() && intervals.get(left).end>=intervals.get(left+1).start){
    		intervals.get(left).end = 
    			Math.max(intervals.get(left).end,intervals.get(left+1).end);
    		
    		intervals.remove(left+1);
    		
    	}

    	if (left-1>=0 && intervals.get(left-1).end>=intervals.get(left).start) {
    		intervals.get(left-1).end = 
    			Math.max(intervals.get(left-1).end,intervals.get(left).end);
    		intervals.remove(left);
    	}

    }
    

}