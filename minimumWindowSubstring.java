//  Given a string S and a string T, 
//  find the minimum window in S 
//  which will contain all the characters 
//  in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"

// Minimum window is "BANC".

// Note:
// If there is no such window in S 
// that covers all characters in T, 
// return the empty string "".

// If there are multiple such windows,
//  you are guaranteed that there will always 
//  be only one unique minimum window in S. 

public class Solution {
    public String minWindow(String s, String t) {
// the creation of hash table of string t
        int[] hashOfT = new int[128];
        for (int i = 0;i<t.length();i++ ) {
        	hashOfT[t.codePointAt(i)]++;
        }

        int[] hashOfS = new int[128];
        int fast = 0;
        int slow = 0;
        int minimum = Integer.MAX_VALUE;
        String ans = "";
        while(fast<=s.length() ) {
        	
        	if (doesItContain(t,hashOfS,hashOfT)) {
        		if(fast-slow<minimum){
        			minimum = fast-slow;
        			ans = s.substring(slow,fast);
        			System.out.println("okay");
        		} 
        		if (slow>=s.length()) {
        			break;
        		}
        		hashOfS[s.codePointAt(slow)]--;
        		slow++;
        	}
        	else {
        		if (fast>=s.length()) {
        			break;
        		}
        		hashOfS[s.codePointAt(fast)]++;
        		fast++;
        	}
        	
        }
        return ans;
    }

    private boolean doesItContain(String t,int[] hashOfS, int[] hashOfT){

    	for(int i = 0;i<t.length();i++) {
    		int code = t.codePointAt(i);
    		if (hashOfT[code]>hashOfS[code]) {
    			return false;
    		}
    	}
    	return true;
    }
}