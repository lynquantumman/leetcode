public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();;
        if (0==rowIndex) {
            ans.add(1);
        }

        if (1==rowIndex) {
            ans.add(1);
            ans.add(1);
        }

        if (2<=rowIndex) {
            ans.add(1);
            asn.add(1);
            for (int i = 1;i<=rowIndex-1;i++ ) {
                ans = nextLine(ans);    
            } 
        }
        return ans;
    }
    List<Integer> nextLine(List<Integer> input){
    	//在这里面new 对象
    	List<Integer> ans = new ArrayList<Integer>();
    	ans.add(1);
    	int len = input.size();
    	for(int i = 0;i+1<len;i++){
    		ans.add(input.get(i)+input.get(i+1));
    	}
    	ans.add(1);
    	return ans;
    }
}