/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
    	
    	ListNode evenHead = null;
    	ListNode odd = null;
    	if (head!=null) {
    		odd=head;
    	}else{
    		return null;
    	}    	
    	if (head.next!=null) {
    		evenHead = head.next;
    	}else{
    		return head;
    	}
    	
    	
    	ListNode even = evenHead;
    	while(odd.next!=null&&even.next!=null){
    		odd.next = odd.next.next;
    		even.next = even.next.next;

    		odd = odd.next;
    		even = even.next;
    	}
    	odd.next = evenHead;
    	

    	
    	return head;

    }
}