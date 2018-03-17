#160.Intersection_of_Two_Linked_Lists
/*Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


/*Most solutions preprocesses LinkedLists to get the difference in len.
Actually we don’t care about the “value” of difference, we just want to make sure 
two pointers reach the intersection node at the same time.

We can use two iterations to achieve this:
	-1st iteration: reset the pointer of one LinkedList to the head of another 
	LinkedList after it reaches the tail node. 
	-2nd iteration: move two pointers until both point to the same node.

Iteration in 1st iteration will help counteract the difference.

If two LinkedLists intersect, the meeting point in 2nd iteration must be the 
point of intersection. 

If the two LinkedLists have NO intersection, the meeting pointer in 2nd iteration 
must be the tail node of both lists, which is null.*/

/*You can prove that: say A length = a + c, B length = b + c. After switching pointer, 
pointer A will move another (b + c) steps, pointer B will move (a + c) more steps, 
since a + c + b + c = b + c + a + c, it does not matter what value c is.
Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	//O(m+n) time, O(1) space
	if (headA == null || headB == null) return null; //boundary check
	ListNode a = headA;
	listNode b = headB;

	//Stop the loop after 2nd iteration if a and b have different length
	while (a != b) {
		//Reset the pointer to the head of another LinkedList at the end of 1st iteration
		a = a == null? headB : a.next;
		b = b == null? headA : b.next;
	}
	return a;
}

#OR
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	int lenA = length(headA), lenB = length(headB);
	// move headA and headB to the same start point
	while (lenA > lenB) {
		headA = headA.next;
		lenA--;
	}
	while (lenA < lenB) {
		headB = headB.next;
		lenB--;
	}
	// find the intersection until end
	while (headA != headB) {
		headA = headA.next;
		headB = headB.next;
	}
	return headA;
}
private int length(ListNode node) {
	int len = 0;
	while (node != null) {
		node = node.next;
		length++;
	}
	return length;
}