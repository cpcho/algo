#021. Merge Two Sorted Lists
/*Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*Similar to array, the difference is if any of two listnode is not 
null after first loop, we only need to add it as previous node’s next 
and no need to add them one by one.*/

/*One thing deserves discussion is whether we should create a new ListNode as a 
convenient way to hold the list. Sometimes, in industrial projects, sometimes 
it’s not trivial to create a ListNode which might require many resource allocations 
or inaccessible dependencies (we need to mock them).

So ideally, we should pick up either the head of l1 or l2 as the head other than 
creating a new one, which however makes the initialization step tedious.

But during an interview, I would rather create a new ListNode as list holder, but 
communicate with the interviewer that I’m aware of the potential issue, and would improve 
it if he/she thinks this is a big deal.*/
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	if (l1 == null && l2 == null) return null;
	if (l1 == null) return l2;
	if (l2 == null) return l1;
	
	ListNode result = new ListNode(0);
	ListNode prev = result;
	while (l1 != null && l2 != null) {
		if (l1.val <= l2.val) {
			prev.next = l1;
			l1 = l1.next;
		} else {
			prev.next = l2;
			l2 = l2.next;
		}
		prev = prev.next;
	}

	if (l1 != null) prev.next = l1;
	if (l2 != null) prev.next = l2;
	return result.next;
}

#OR

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode fakeHead = new ListNode(0);
	ListNode curr = fakeHead;

	while (l1 != null || l2 != null) {
		if (l1 == null || (l2 != null && l1.val >= l2.val)) {
			curr.next = l2;
			curr = l2;
			l2 = l2.next;
		} else {
			curr.next = l1;
			curr = l1;
			l1 = l1.next;
		}
	}
	return fakeHead.next;
}

#OR
//Recursion
/*Personally, I don’t like this approach because in real life, 
the length of a linked list could be much longer than we expected, 
in which case the recursive approach is likely to introduce a stack overflow. 
(Imagine a file system)

But anyway, as long as we communicate this concerning properly with the interviewer, 
I don’t think it’s a big deal here.*/
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
    	l1.next = mergeTwoLists(l1.next, l2);
    	return l1;
    } else {
    	l2.next = mergeTwoLists(l1, l2.next);
    	return l2;
    }
}

#OR