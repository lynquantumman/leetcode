public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length()==s3.length())
    		return recursiveJudge(s1,0,s2,0,s3,0);
    	else return false;
    }

    private boolean recursiveJudge(String s1, int s1Position,
    	String s2, int s2Position, String s3,int s3Position){

    	if (s1.length()<=s1Position) {
    		return s2.substring(s2Position).equals(s3.substring(s3Position));
    	}
    	if (s2.length()<=s2Position) {
    		return s1.substring(s1Position).equals(s3.substring(s3Position));
    	}

    	if( s1.charAt(s1Position)==s3.charAt(s3Position)){
        	if(recursiveJudge(s1,s1Position+1,s2,s2Position,s3,s3Position+1))
        		return true;
        }
        if(s2.charAt(s2Position)==s3.charAt(s3Position)){
        	return recursiveJudge(s1,s1Position,s2,s2Position+1,s3,s3Position+1);
        }
        return false;
    }
}