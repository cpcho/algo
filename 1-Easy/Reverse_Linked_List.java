#206. Reverse Linked List (Easy)
/*Reverse a singly linked list.
Hint: A linked list can be reversed either iteratively or recursively.*/

/*Iterative - Time O(n), Space O(1)
https://youtu.be/jY-EUKXYT20*/
public ListNode reverseList(ListNode head) {
	if (head == null) return head;
	ListNode curr = head, prev = null, next = null;
	while (curr != null) {
		//Since a node does not have reference to its previous node, 
		//you must store its previous element beforehand.
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
	}
	return prev;
}

/*Recursive*/
public ListNode reverseList(ListNode head) {
	return reverse(head, null);
}

private ListNode reverse(ListNode list, ListNode newHead) {
	if (head == null) return newHead;
	ListNode next = head.next;
	head.next = newHead;
	return reverse(next, head);
}