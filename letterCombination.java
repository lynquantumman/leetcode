public class Solution {
    char[][] keyTable= {{},
                    {},
                    {'a','b','c'},
                    {'d','e','f'},
                    {'g','h','i'},
                    {'j','k','l'},
                    {'m','n','o'},
                    {'p','q','r','s'},
                    {'t','u','v'},
                    {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<String>();
    	if("".equals(digits)){
    		return ans;
    	}
        search("", digits, ans);
        return ans;
    }
    private void search(String prefix,String digits, List<String> ans){

        if(prefix.length()==digits.length()){
            ans.add(prefix);
            return; 
        }
        else{
            int dgt = digits.codePointAt(prefix.length())-48; 
            for(int i=0;i<keyTable[dgt].length;i++){
                search(prefix + keyTable[dgt][i],digits,ans);
            }
        }
    }
}