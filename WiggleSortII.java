public class Solution{
	int midPos;
	int len;
	public void wiggleSort(int[] nums){
		this.len = nums.length;
		this.midPos = (len-1)/2;
		
		int mid = findKthElement(nums,midPos,0,len);
		
		//three partition sorting
		int i = this.len-1;
		int j = this.len-1;
		int k = 0;
		while(k<=j) {
			if (nums[indexMapping(j)]>mid) {
				swap(nums, indexMapping(j),indexMapping(k));
				k++;

			}else if (nums[indexMapping(j)]<mid) {
				swap(nums,indexMapping(i),indexMapping(j));
				i--;j--;
			}else j--;
		}
		

	}
	private int indexMapping(int input){
//mapping the natural ordering to jumping ordering
		// if (input<this.midPos) {
		// 	return 2*input+1;
		// }else{//midPos<input
		// 	return (input-this.midPos)*2;
		// }
		return (1+2*(input)) % (this.len|1);
	}
	private void swap(int[] nums,int left, int right){
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public int findKthElement(int[] nums, int k, int left, int right){

		if((right-left)==1){
			if(k==left)
				return nums[k];
		}
		int first = left+1;
		int last = right-1;
		int cmp = nums[left];
		while(first<last){
			while(first<last&&nums[first]<=cmp){
				first++;
			}
			while(first<last&&cmp<=nums[last]){
				last--;
			}
			swap(nums,first,last);
			
		}
		int th = 0;
		if (cmp>nums[first]) {
			swap(nums,left,first);
			th = first;
			
		}
		else {//when cmp<=nums[first]
			swap(nums,left,first-1);
			th = first-1;
			
		}
		if (k==th) {
			return nums[k];
		}else if (k<th) {
			return findKthElement(nums,k,left,th);
		}else {
			return findKthElement(nums,k,th+1,right);
		}
			
	}
}