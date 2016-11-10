
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = ipGenerator(s);
        siftIp(ans);
        return ans;
    }

    private List<String> ipGenerator(String s){
    	List<String> ans = new ArrayList<Integer>();
    	
    }

    private void siftIp(List<String> input){
    	ListIterator iter = input.listIterator();
    	for (iter.hasNext() ) {
    		if(!isIpValid(iter.next())){
    			iter.remove();
    		}
    	}
    }

    private boolean isIpValid(String s){
    	String[] out = s.split("[.]");
    	for (String each : out) {
    		int temp = Integer.parseInt(each);
    		if(!(0<=temp && temp<=255))
    			return false;

    	}
    	return true;
    }
}