#141. Linked List Cycle
/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/

/*Hash Table
O(n) time - Visiting each of the n elements in the list at most once.
Adding a node to the hash table: O(1) time and O(n) space. 
The space depends on the number of elements added to the hash table,
which contains at most n elements*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public boolean hasCycle(ListNode head) {
	
	Set<ListNode> nodeSeen = new HashSet<>();
	while (head != null) {
		if (nodeSeen.contains(head)) {
			return true;
		} else {
			nodeSeen.add(head);
		}
		head = head.next;
	}
	return false;
}

/*Two Pointers
O(N + K) ~= O(n) time, O(1) space*/
public boolean hasCycle(ListNode head) {
	
	if (head == null || head.next == null) return false;

	ListNode slow = head;
	ListNode fast = head.next;
	while (slow != fast) {
		if (fast == null || fast.next == null) return false;
		slow = slow.next;
		fast = fast.next.next;
	}
	return true;
}

/*Another Two Pointer Solution
Walker moves step-by-step. Runner moves two steps at a time.
If the LinkedList has a cycle, walker and runner will meet at some point.
http://codingfreak.blogspot.com/2012/09/detecting-loop-in-singly-linked-list_22.html*/
public boolean hasCycle(ListNode head) {
	if (head == null) return false;
	ListNode walker = head;
	ListNode runner = head;
	while (runner.next != null && runner.next.next != null) {
		walker = walker.next;
		runner = runner.next.next;
		if (walker == runner) return true;
	}
	return false;
}