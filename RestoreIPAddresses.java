public class Solution {
    public List<String> restoreIpAddresses(String s) {
    	if(s.length()<4 || s.length()>9){
    		List<String> ans = new ArrayList<String>();
    		return ans;
    	}
        List<String> ans = ipGenerator(s);
        siftIp(ans);
        return ans;
    }

    private List<String> ipGenerator(String s){
    	List<String> ans = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder(s);
    	for (int i = 1;i<=3 ;i++ ) {
    		if (i>sb.length()-1) {
    			break;
    		}
    		sb.insert(i,'.');
    		for (int j = 1;j<=3 ;j++ ) {
    			if (i+j+1>sb.length()-1) {
    				break;
    			}
    			sb.insert(i+j+1,'.');
    			for (int k = 1;k<=3 ;k++ ) {
    				if (i+j+k+2>sb.length()-1) {
	    				break;
	    			}
    				sb.insert(i+j+k+2,'.');
    				String ele = new String(sb);
    				ans.add(ele);
    				sb.deleteCharAt(i+j+k+2);
    			}
    			sb.deleteCharAt(i+j+1);
    		}
    		sb.deleteCharAt(i);
    	}
    	return ans;
    }

    private void siftIp(List<String> input){
    	ListIterator<String> iter = input.listIterator();
    	while(iter.hasNext()) {
    		if(!isIpValid(iter.next())){
    			iter.remove();
    		}
    	}
    }

    private boolean isIpValid(String s){
    	String[] out = s.split("[.]");
    	for (String each : out) {
    		int temp = Integer.parseInt(each);
    		if(!(0<=temp && temp<=255) )
    			return false;
    		if(each.startsWith("00") || each.startsWith("0") && 0<temp ) {
    			return false;
    		}
    	}
    	return true;
    }
}