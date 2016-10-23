/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	Comparator<Interval> comparator = new Comparator<Interval>(){
    		@Override 
    		public int compare(Interval ob1, Interval ob2){
    			return ob1.start-ob2.start;
    		}
    	};
    	Collections.sort(intervals, comparator);

    	if(intervals.size()<=1)
    		return  intervals;
    	int i = 1;
    	// 这里有一个intervals.size()变化的问题
    	// 用ListIterator是一个比较稳健的方法
    	ListIterator<Interval> listIterator = 
    	 intervals.listIterator();
    	Interval lastItem = new Interval();
    	if(listIterator.hasNext())
    		lastItem = listIterator.next();
    	Interval currentItem;

    	if(listIterator.hasNext()){
    		currentItem = listIterator.next();
	    	while(true){
	    		if(lastItem.end<currentItem.start){
		        	lastItem = currentItem;
		        	if(listIterator.hasNext())
		        		currentItem = listIterator.next();
		        	else break;
		       	
	       		} 

	        	if(currentItem.start<=lastItem.end){

		        	lastItem.end=Math.max(lastItem.end,currentItem.end);
		        	listIterator.remove();
		        	if(listIterator.hasNext()){
		        		currentItem = listIterator.next();
		        	}
		        	else break;
	        	}
	    	}
	    }
        return intervals;
    }
}