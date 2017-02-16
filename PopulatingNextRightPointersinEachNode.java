/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void connect(TreeLinkNode root) {
    	TreeLinkNode head = root;
    	if (null==root) {
    		return ;
    	}
        while(head.left!=null){
        	TreeLinkNode temp = head;
        	while(null!=temp){
        		temp.left.next = temp.right;
        		if (temp.next!=null) {
        			temp.right.next = temp.next.left;
        		}
	        	
	        	temp = temp.next;
        	}

        	head = head.left;

        }
    }
}