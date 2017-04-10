public class Solution{
	int midPos;
	int len;
	public void wiggleSort(int[] nums){
		this.len = nums.length;
		this.midPos = (len-1)/2;
		for (int i = 0;i<len ;i++ ) {
			System.out.println(indexMapping(i)+"=====");
		}
		
		findKthElement(nums,midPos,0,len);

	}
	private int indexMapping(int input){
//mapping the natural ordering to jumping ordering
		if (input<=this.midPos) {
			return 2*input;
		}else{//midPos<input
			return (input-(this.midPos+1))*2+1;
		}
	}
	private void swap(int[] nums,int left, int right){
		int temp = nums[indexMapping(left)];
		nums[indexMapping(left)] = nums[indexMapping(right)];
		nums[indexMapping(right)] = temp;
	}

	public int findKthElement(int[] nums, int k, int left, int right){
// 		if (k<left||k>=right) {
// 			throw new RunTimeException();
// 		}
		if (right-left==1&&k==left) {
			return nums[indexMapping(left)];
		}
		int first = left+1;
		int last = right-1;
		int cmp = nums[indexMapping(left)];
		while(first<last){
			while(first<last&&cmp>=nums[indexMapping(first)]){
				first++;
			}
			while(first<last&&cmp<=nums[indexMapping(last)]){
				last--;
			}
			swap(nums,first,last);
			System.out.println("hello,world first"+first+"last==="+last);
		}
		
		if (cmp>nums[indexMapping(first)]) {
			swap(nums,left,first);
			if (k==first) {
				return nums[indexMapping(k)];
			}else if (k<first) {
				return findKthElement(nums,k,left,first);
			}else {
				return findKthElement(nums,k,first+1,right);
			}
		}
		else {//when cm<=nums[indexMapping() first]
			swap(nums,left,first-1);
			System.out.println("hello,world left"+left+"first-1==="+(first-1));
			if (k==first-1) {
				return nums[indexMapping(k)];
			}else if (k<first-1) {
				return findKthElement(nums,k,left,first-1);
			}else{//first-1<k
				System.out.println("first-1<k");
				return findKthElement(nums,k,first,right);
			}
		}
			
	}
}