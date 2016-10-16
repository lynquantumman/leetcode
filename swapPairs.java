
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        if(head==null){
        	return null;
        }
        dummy.next = head;
        temp = dummy;
        while(temp.next.next!=null){
        	ListNode right = temp.next.next.next;
        	swap(temp,right);
        	temp = temp.next.next;
        }
        return dummy.next;
    }
    private void swap(ListNode left, ListNode right){
    	ListNode first = left.next;
    	ListNode second = first.next;
    	first.next = right;
    	left.next = second;
    	second.next = first;
    }
}