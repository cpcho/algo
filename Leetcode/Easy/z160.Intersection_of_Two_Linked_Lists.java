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


/*I found most solutions here preprocess linkedlists to get the difference in len.
Actually we don’t care about the “value” of difference, we just want to make sure 
two pointers reach the intersection node at the same time.

We can use two iterations to do that. 
First iteration - reset the pointer of one linkedlist to the head of another 
LinkedList after it reaches the tail node. 
Second iteration - move two pointers until both point to the same node.

Iteration in first iteration will help counteract the difference. 
If two LinkedLists intersect, the meeting point in second iteration must be the 
point of intersection. If the two LinkedLists have no intersection at all, the meeting 
pointer in second iteration must be the tail node of both lists, which is null.*/

/*You can prove that: say A length = a + c, B length = b + c. After switching pointer, 
pointer A will move another (b + c) steps, pointer B will move (a + c) more steps, 
since a + c + b + c = b + c + a + c, it does not matter what value c is.
Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	//O(m+n) time, O(1) space
	if (headA == null || headB == null) return null; //boundary check

	ListNode a = headA;
	listNode b = headB;

	//if a & b have different len, we will stop the loop after second iteration
	while (a != b) {
		//at the end of first iteration, we will reset the pointer to the head of another Linked List
		a = a == null? headB : a.next;
		b = b == null? headA : b.next;
	}

	return a;
}
