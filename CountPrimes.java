public class Solution {
	LinkedList<Integer> primes = new LinkedList<Integer>();
    public int countPrimes(int n) {
    	if (n<=2) {
    		return 0;
    	}
    	if (n==3) {
    		return 1;
    	}
    	else{//3<n
    		primes.add(2);
    		for ( int i = 3;i<n;i+=2 ) {
        		if(isPrime(i))
        			primes.add(i);
        	}
    	}
    	return primes.size();
        
    }
    private boolean isPrime(int input){
    	double sqrt = Math.sqrt((double)i);
    	
    	for (int each : this.primes) {
    		if (each<=sqrt) {
    			if(input%each==0)
    				return false;
    		}
    		else return true;
    	}
    	return false;
    }
}