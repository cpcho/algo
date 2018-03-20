#19. Remove Nth Node From End of List
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

/*First we will add an auxiliary "dummy" node, which points to the list head.
The "dummy" node is used to simplify some corner cases such as a list with only one node, 
or removing the head of the list.*/
public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode fast = dummy;
	ListNode slow = dummy;

	// Advances fast pointer so that the gap between fast and slow is n nodes apart
	for (int i = 0; i <= n; i++) {
		fast = fast.next;
	}

	while (fast != null) { // Move fast to the end, maintaining the gap
		fast = fast.next;
		slow = slow.next;
	}
	slow.next = slow.next.next;
	return dummy.next;
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

#OR

/* To start off with, mathematically orient yourself to be able to explain this problem
    Assume you have N nodes total, we are trying to get the nth from the end, how can we illustrate this
    Trust your gut -> Moving n steps, then restarting pointer until the first pointer hits null is correct
    But how do you rationalize this? Let us illustrate with a diagram, where N = 5, n = 2, and nth means nth from end:
    
                    / ----------[ N - n ]----------- \           /---n---\ 
       D    -->    o   -->    o    -->    o    -->    o    -->   o  -->   o    -->    x 
    
    Notice how if there are n nodes at the end, then if we traverse n nodes during travel #1...
    That means during travel #2, the new pointer will be able to travel exactly N - n
    If we do this starting from a dummy node, then after traveling N - n, we point to the nth node from the end!
    Now the algo becomes obvious! With the dummy node, this seems to fix for itself tricky edge cases!*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 0; i < n; i ++) 
			head = head.next;
        ListNode node = dummy;
        while (head != null) {
            head = head.next;
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
        
    }