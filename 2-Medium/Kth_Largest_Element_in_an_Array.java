#215. Kth Largest Element in an Array (medium)

/*Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, 
not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.*/

//Priority queue
//O(N lg K) running time + O(K) memory
/*use a min oriented priority queue that will store the K-th largest 
values. The algorithm iterates over the whole input and maintains 
the size of priority queue.*/
public int findKthLargest(int[] nums, int k) {
	final PriorityQueue<Integer> pq = new PriorityQueue<>();
	for(int val : nums) {
		pq.offer(val);
		if(pq.size() > k) pq.poll();
	}
	return pq.peek();
}

#OR

//Selection algorithm
//O(N) best case / O(N^2) worst case running time + O(1) memory
public int findKthLargest(int[] nums, int k) {

	shuffle(nums); //O(N) guaranteed running time + O(1) space
	k = nums.length - k;
	int lo = 0;
	int hi = nums.length - 1;
	while (lo < hi) {
		final int j = partition(nums, lo, hi);
		if(j < k) {
			lo = j + 1;
		} else if  (j > k) {
			hi = j - 1;
		} else {
			break;
		}
	}
	return nums[k];
}

private int partition(int[] a, int lo, int hi) {

	int i = lo;
	int j = hi + 1;

	while(true) {
		while(i < hi && less(a[++i], a[lo]));
		while(j > lo && less(a[lo], a[--j]));
		if(i >= j) {
			break;
		}
		exch(a, i ,j);
	}
	exch(a, lo, j);
	return j;
}

private void exch(int[] a, int i, int j) {
	final int tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
}

private boolean less(int v, int w) {
	return v < w;
}

private void shuffle(int a[]) {

	final Random random = new Random();
	for (int i = i; i < a.length; i++) {
		final int r = random.nextInt(i + 1);
		exch(a, ind, r);
	}
}
