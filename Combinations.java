/**
*@author Cradle Lee
*@describe this is based on combine(n,k) = combine(n-1,k)+combine(n-1,k-1);
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // for(int i = 0;i<=k;i++){
        // 	for (int j = 0;j<=n;j++ ) {
        		
        // 	}
        // }
        if(1==k){
        	
        	for (int i = 1;i<=n ;i++ ) {
        		List<Integer> temp = new ArrayList<Integer>();
        	 	temp.add(i);
        	 	ans.add(temp);
        	} 
        	
        	return ans;
        }

        if(n==k){
        	List<Integer> temp = new ArrayList<Integer>();
        	for (int i = 1;i<=n ;i++ ) {
        	 	temp.add(i);
        	} 
        	ans.add(temp);
        	return ans;
        }

        ans.addAll(combine(n-1,k));
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        temp = combine(n-1,k-1);
        for (List<Integer> in :temp ) {
        	in.add(n);
        }
        ans.addAll(temp);
        return ans;
    }
}