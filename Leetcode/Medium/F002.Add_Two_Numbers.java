#002. Add Two Numbers (Medium)
/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single 
digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, 
except the number 0 itself.

Example
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
	ListNode c1 = l1;
	ListNode c2 = l2;
	ListNode sentinel = new ListNode(0);
	ListNode d = sentinel;
	int sum = 0;
	while (c1 != null || c2 != null){
		sum /= 10;
		if (c1 != null) {
			sum += c1.val;
			c1 = c1.next;
		}
		if (c2 != null) {
			sum += c2.val;
			c2 = c2.next;
		}
		d.next = new ListNode(sum % 10);
		d = d.next;
	}
	if (sum / 10 == 1)
		d.next = new ListNode(1);
	return sentinel.next;
}

##OR###

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
	ListNode prev = new ListNode(0);
	ListNode head = prev;
	int carry = 0;
	while (l1 != null || l2 != null || carry != 0){
		ListNode curr = new ListNode(0);
		int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null ? 0 : l2.val) + carry;
		curr.val = sum % 10;
		carry = sum / 10;
		prev.next = curr;
		prev = prev.next;

		l1 = (l1 == null) ? l1 : l1.next;
		l2 = (l2 == null) ? l2 : l2.next;
	}
	return head.next;
}