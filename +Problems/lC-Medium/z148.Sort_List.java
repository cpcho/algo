#148. Sort List
/*Sort a linked list in O(n log n) time using constant space 
complexity.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public ListNode sortList(ListNode head) {
	ListNode curr = head;

	if (curr == null) return null;
	while (head != null) {
		if (curr.val > curr.next.val) {
			curr = curr.next;
			
		}
		
	}
}