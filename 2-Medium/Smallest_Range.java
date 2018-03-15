#632. Smallest Range

//https://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
//https://leetcode.com/problems/smallest-range/solution/

/*You have k lists of sorted integers in ascending order. 
Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:

Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24, 26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

Note:

1) The given list may contain duplicates, so ascending order means >= here.
2) 1 <= k <= 3500
3) -10^5 <= value of elements <= 10^5.
4) For Java users, please note that the input type has been changed to List<List<Integer>>. 
And after you reset the code template, you'll see this point.*/

/*Imagine you are merging k sorted array using a heap. Then everytime you pop the smallest element out and 
add the next element of that array to the heap. Keeping doing this will result in the smallest range.*/

class Element {
	int val, idx, row;
	public Element(int r, int i, int v) {
		val = v;
		idx = i,
		row = r;
	}
}

public int[] smallestRange(int[]][] nums) {
	PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator <Element> () {
		public int compare(Element a, Element b) {
			return a.val - b.val;
		}
	});
	int min = Integer.MAX_VALUE, max = Intger.MIN_VALUE;
	for (int i = 0; i < nums.length; i++) {
		Element e = new Element(i, 0, nums[i][0]);
		pq.offer(e);
		max = Math.max(max, nums[i][0]);
	}
	int range = Integer.MAX_VALUE;
	int start = -1, end = -1;
	while (pq.size() == nums.length) {
		Element curr = pq.poll();
		if (max - curr.val < range) {
			range = max - curr.val;
			start = curr.val;
			end = max;
		}
		if (curr.idx + 1 < nums[curr.row].length) {
			curr.idx = curr.idx + 1;
			curr.val = nums[curr.row][curr.idx];
			pq.offer(curr);
			if (curr.val > max) max = curr.val;
		}
	}
	return new int[] {start, end};
}