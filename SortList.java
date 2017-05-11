/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (null==head||null==head.next) {
        	return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        ListNode h2 = sortList(slow.next);
        slow.next=null;
        head = sortList(head);
        return merge(head,h2);
    }

    private ListNode merge(ListNode a, ListNode b){
    	ListNode dummy = null;
    
    	if (null!=a&&null!=b) {
    		if (a.val<b.val) {
    			dummy = a;
    			a = a.next;
    		}else{
    			dummy = b;
    			b = b.next;
    		}
    		
    	}
    	ListNode temp = dummy;
    	while(null!=a&&null!=b){
    		if (a.val<b.val) {
    			temp.next = a;
    			a = a.next;
    		}else{
    			temp.next = b;
    			b = b.next;
    		}
    		temp = temp.next;
    	}

    	if (a!=null) {
    		temp.next = a;
    	}

    	if (b!=null) {
    		temp.next = b;
    	}
    	return dummy;
    }
}