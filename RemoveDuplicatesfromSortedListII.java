/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode temp = dummy;
    	//temp.next是否为空，temp.next.next是否为空
    	while (temp.next!=null && temp.next.next!=null) {
    		if(temp.next.val==temp.next.next.val){
	    		ListNode localStart = temp;
	    		while(localStart.next!=null && localStart.next.next!=null
	    			&& localStart.next.val==localStart.next.next.val){
	    			localStart.next = localStart.next.next;
	    		}
    			localStart.next = localStart.next.next;
	    	}
	    	else if(temp.next.val!=temp.next.next.val){
	    		temp = temp.next;
	    	}
    	}
    	return dummy.next;
        
    }
}