/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	Stack<Iterator<NestedInteger>> stk;
	Iterator<NestedInteger> iter;
	Integer num = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        stk = new Stack<Iterator<NestedInteger>>();
        iter = nestedList.iterator();
    }

    @Override
    public Integer next() {
    	Integer ans = null;
        if (num!=null) {//just runned hasNext()
        	ans = num;
        	num = null;
        	return ans;
        }else{
        	if (hasNext()) {
        		ans = num;
        		num = null;
        		return ans;
        	}else{
        		return null;
        	}
        }

        
    }
    // [[1],2]
    @Override
    public boolean hasNext() {
    	NestedInteger temp = null;
    	//push stage
    	while(true){
    		while(iter.hasNext()){
	        	if ((temp = iter.next()).isInteger()) {
	        		num = temp.getInteger();
	        		return true;
	        		
	        	}else{
	        		stk.push(iter);
	        		iter = temp.getList().iterator();
	        		
	        	}
	        }
	        //pop stage
	        while(!iter.hasNext()){
	        	if (stk.empty()) {
	        		return false;
	        	}else{
	        		iter = stk.pop();

	        	}
	        }
    	}
        

    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */