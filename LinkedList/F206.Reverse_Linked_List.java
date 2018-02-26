#206. Reverse Linked List (Easy)
#Reverse a singly linked list.
#Hint: A linked list can be reversed either iteratively or recursively. Could you implement both?

###1.iterative solution###
//Time complexity: O(n)
//Space Complexity: O(1)
public ListNode reverseList(ListNode head) {
	ListNode prev = null;
	ListNode curr = head;
	while (curr != null) {
		//Since a node does not have reference to its previous node, 
		//you must store its previous element beforehand.
		ListNode nextTemp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = nextTemp;
	}
	return prev;
}

###OR###
public ListNode reverseList(ListNode head) {
	ListNode newHead = null;
	while (head != null) {
		ListNode next = head.next;
		head.next = newHead;
		newHead = head;
		head = next;
	}
	return newHead;
}

###2.recursive solution###
public ListNode reverseList(ListNode head) {
	return reverseListInt(head, null);
}

private ListNode reverseListInt(ListNode list, ListNode newHead) {
	if (head == null)
		return newHead;
	ListNode next = head.next;
	head.next = newHead;
	return reverseListInt(next, head);
}