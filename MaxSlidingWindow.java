public class Solution {
	class Ele{
		int val;
		public Ele(int input){
			val = input;
		}
		// @Override
		// public String toString(){
		// 	return String.valueOf(val);
		// }
	}
    public int[] maxSlidingWindow(int[] nums, int k) throws InterruptedException {
    	if(nums.length==0){
    		return new int[0];
    	}
    	Comparator<Ele> cmp = new Comparator<Ele>(){
    		@Override
    		public int compare(Ele a, Ele b){
    			return a.val-b.val;
    		}
    	};
    	
    	PriorityQueue<Ele> heap = new PriorityQueue<Ele>(cmp.reversed());
    	Ele[] window = new Ele[k];
        for (int i = 0;i<k;i++ ) {
        	window[i] = new Ele(nums[i]);
        	heap.add(window[i]);
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = heap.peek().val;
    	// System.out.println(Arrays.toString(heap.toArray())+"38line");
    	Ele temp = null;
        for (int i = k;i<nums.length;i++) {
        	heap.remove(window[i%k]);
        	heap.offer(temp = new Ele(nums[i]));//shenqi**********
        	
        	//**********
        	window[i%k] = temp; 
        	
        	ans[i-k+1] = heap.peek().val;
        }
        return ans;
    }
}