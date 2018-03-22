23. Merge k Sorted Lists

/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/*The simplest solution is using PriorityQueue. The elements of the priority queue are ordered 
according to their natural ordering, or by a comparator provided at the construction time 
(in this case).

Suppose the total number of nodes is n. The total time complexity if (n * log k).
For a priority queue, insertion takes logK time*/

public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;

    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
    	public int compare(ListNode l1, ListNode l2) {
    		return l1.val - l2.val;
    	}
    });

    ListNode head = new ListNode(0);
    ListNode p = head;

    for (ListNode list : lists) {
    	if (list != null) queue.offer(list);
    }

    while (!queue.isEmpty()) {
    	ListNode n = queue.poll();
    	p.next = n;
    	p = p.next;

    	if (n.next != null) queue.offer(n.next); // we need to put the remain list to the queue again
    }
    return head.next;
}

#OR
// Merge sort

public ListNode mergeKLists(ListNode[] lists) {
	if (lists == null || lists.length == 0) return null;
	return sort(lists, 0, lists.length - 1);
}

private ListNode sort(ListNode[] lists, int lo, int hi) {
	if (lo >= hi) return lists[lo];
	int mid = lo + (hi - lo) / 2;
	ListNode l1 = sort(lists, lo, mid);
	ListNode l2 = sort(lists, mid + 1, hi);
	return merge(l1, l2);
}

private ListNode merge(ListNode l1, ListNode l2) {
	if (l1 == null) return l2;
	if (l2 == null) return l1;
	if (l1.val < l2.val) {
		l1.next = merge(l1.next, l2);
		return l1;
	}
	l2.next = merge(l1, l2.next);
	return l2;
}