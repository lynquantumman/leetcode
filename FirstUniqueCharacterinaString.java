import java.util.Hashtable;
public class Solution {
	public Hashtable<Character,Boolean> dic = new Hashtable<Character,Boolean>();
	
    public int firstUniqChar(String s) {
        for (int i = 0;i<s.length();i++ ) {
        	if (!dic.containsKey(s.charAt(i))) {
        		dic.put(s.charAt(i),false);
        	}
        	else{
        		dic.put(s.charAt(i),true);
        	}
        }

        for (int i = 0;i<s.length();i++ ) {
        	if(dic.get(s.charAt(i))==false)
        		return i;
        	
        }

        return -1;
    }


}