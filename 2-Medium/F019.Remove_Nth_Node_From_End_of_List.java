#19. Remove Nth Node From End of List (Medium)
/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.

Try to do this in one pass.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//One Pass
//O(L) time, O(1) space
public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode start = new ListNode(0);
	start.next = head;
	ListNode fast = start;
	ListNode slow = start;

	// Advances fast pointer so that the gap between fast and slow is n nodes apart
	for (int i = 1; i <= n; i++) {
		fast = fast.next;
	}

	while (fast != null) { // Move fast to the end, maintaining the gap
		fast = fast.next;
		slow = slow.next;
	}
	slow.next = slow.next.next;
	return start.next;
}
/*The first pointer advances the list by n+1 steps from the beginning, while the second pointer 
starts from the beginning of the list. Now, both pointers are exactly separated by n nodes apart. 
We maintain this constant gap by advancing both pointers together until the first pointer 
arrives past the last node. The second pointer will be pointing at the nth node counting 
from the last. We relink the next pointer of the node referenced by the second pointer to point 
to the node's next.next node.*/

#OR
public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode h1 = head, h2 = head;
	while (n-- > 0) h2 = h2.next; // Decrease n by one in every loop
	if (h2 == null) return head.next; // The head will be removed.
	h2 = h2.next;

	while (h2 != null) {
		h1 = h1.next;
		h2 = h2.next;
	}
	h1.next = h1.next.next; // Node after the h1 will be removed.
	return head;
}