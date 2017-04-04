public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int len = A.length;
        int count = 0;
        int pos = 0;
        int needToBeAdd = 0;
        int addA,lastA;
        int addB,lastB;
        int addC,lastC;
        for (int i = 0;i<len;i++) {
        	// check
        	if(A[i]+B[0]+C[0]+D[0]>0)
        		break;
        	if (A[i]+B[len-1]+C[len-1]+D[len-1]<0) {
        		continue;
        	}
        	for (int j = 0;j<len;j++) {
        		// check
        		if(A[i]+B[j]+C[0]+D[0]>0)
        			break;
        		if (A[i]+B[j]+C[len-1]+D[len-1]<0) {
        			continue;
        		}
        		for (int k = 0;k<len;k++) {
        			pos = Arrays.binarySearch(D,0-A[i]-B[j]-C[k]);
        			if(pos>=0){
        				addC = repeatNum(D,pos);
        				count+=addC;
        			}
        				
        			
        		}
        	}
        }
        return count;
    }
    private int repeatNum(int[] D,int pos){
    	int left = 0;
    	int right = D.length-1;
    	int i = 0;
    	for(i = pos;i>=0;i--){
    		if (D[i]!=D[pos]) {
    			left = i+1;
    			break;
    		}
    	}
    	
    	
    	for (i = pos;i<D.length;i++ ) {
    		if (D[i]!=D[pos]) {
    			right = i-1;
    			break;
    		}
    	}
    	
    	return right-left+1;
    }
}