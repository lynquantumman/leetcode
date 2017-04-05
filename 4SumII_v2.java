public class Solution {
    ArrayList<Integer> leftEnds = new ArrayList<Integer>();
    ArrayList<Integer> rightEnds = new ArrayList<Integer>();
    int chosen = 0;
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        ArrayList<int[]> al = new ArrayList<int[]>();
        al.add(A);
        al.add(B);
        al.add(C);
        al.add(D);
        if (0==len) {
            return 0;
        }
        leftEnds.add(A[0]);
        leftEnds.add(B[0]);
        leftEnds.add(C[0]);
        leftEnds.add(D[0]);

        rightEnds.add(A[len-1]);
        rightEnds.add(B[len-1]);
        rightEnds.add(C[len-1]);
        rightEnds.add(D[len-1]);
        

        return sumCount(al,0,0);
    }
    
    // possibility check
    private int sumCount(ArrayList<int[]> al, int target, int level){
        
        int sum = 0;
        int pos = 0;
        int[] needtodetect = al.get(level);
        if (3==level) {
            pos = Arrays.binarySearch(needtodetect,target);
            if (pos>=0) {
                sum = repeatNum(needtodetect,pos);
            }
            
            
            return sum; 
        }

        int last = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0;i<needtodetect.length ;i++ ) {
            if(!isPossible(needtodetect[i],level))
                return sum;
            if (isItSmall(needtodetect[i],level)) {
                continue;
            }
            while(i<needtodetect.length&&needtodetect[i]==last){
                sum+=count;
                i++;
            }

            if(i<needtodetect.length&&needtodetect[i]!=last){
                chosen+=needtodetect[i];
                count = sumCount(al,target - needtodetect[i],level+1);
                last = needtodetect[i];
                sum+=count;
                chosen-=needtodetect[i];
            }


            
        }
        
        return sum;
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
// 上一层选的什么数没有渗透到下层
    public boolean isPossible(int input, int level){
        int sum = chosen;

        
        sum += input;
        for (int i = level+1;i<leftEnds.size();i++ ) {
            sum+=leftEnds.get(i);
        }
        return sum<=0;
    }

    public boolean isItSmall(int input, int level){
        int sum = chosen;

        
        sum += input;
        for (int i = level+1;i<rightEnds.size();i++ ) {
            sum+=rightEnds.get(i);
        }
        return sum<0;
    }
}