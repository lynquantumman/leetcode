/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

    	Comparator<ListNode> cmp = new Comparator<ListNode>(){
    		@Override
    		public int compare(ListNode a,ListNode b){
    			return a.val-b.val;
    		}
    	};
    	PriorityQueue<ListNode> leastHeap = new PriorityQueue<ListNode>(cmp);

    	for (ListNode each:lists) {
    		if (each!=null) {
    			leastHeap.add(each);
    		}
    		
    	}
    	
    	ListNode dummy = new ListNode(0);
    	ListNode temp = dummy;
    	while(!leastHeap.isEmpty()){
    		temp.next = leastHeap.poll();
    		if (null!=temp.next.next) {
    			leastHeap.add(temp.next.next);
    		}
    		temp = temp.next;
    	}
    	return dummy.next;
    }
}