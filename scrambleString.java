public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length()!=s2.length()) {
        	return false;
        }
        int len = s1.length();
        if (len==1) {
        	return s1.equals(s2);
        }
        
        for (int i = 1;i<=len-1;i++ ) {
        // deals with the common parts of s1 and s2 which are at
        // the same side
        	if (doesContainSameCharacter(s1.substring(0,i),
        		s2.substring(0,i)) && 
        		doesContainSameCharacter(s1.substring(i),s2.substring(i))) {

        		if(isScramble(s1.substring(0,i),s2.substring(0,i)) &&
        		 isScramble(s1.substring(i),s2.substring(i)))
        			return true;
        	}

        // deals with the common parts of s1 and s2 which are at
        // the different side
        	if (doesContainSameCharacter(s1.substring(0,i),
        		s2.substring(len-i)) && 
        		doesContainSameCharacter(s1.substring(i,len),s2.substring(0,len-i))) {
        		if(isScramble(s1.substring(0,i),s2.substring(len-i,len)) &&
        		 isScramble(s1.substring(i,len),s2.substring(0,len-i)))
        			return true;
        	}
        }

        return false;

    }
    public boolean doesContainSameCharacter(String s1, String s2){
    	long s1hash = 1;
    	long s2hash = 1;
    	if (s1.length()!=s2.length()) {
        	return false;
        }
    	for (int i = 0;i<s1.length() ;i++ ) {
    		s1hash *=s1.codePointAt(i);
    		s2hash *=s2.codePointAt(i);
    	}

    	return s1hash==s2hash;
    }
}