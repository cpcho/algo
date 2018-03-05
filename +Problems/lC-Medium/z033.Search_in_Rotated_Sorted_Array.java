#33.Search in Rotated Sorted Array
/*Suppose an array sorted in ascending order is rotated at some pivot unknown 
to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, 
otherwise return -1.

You may assume no duplicate exists in the array.*/

public int search(int[] A, int target) {
	int lo = 0;
	int hi = A.length - 1;
	while (lo < hi) {
		int mid = (lo + hi) / 2;
		if (A[mid] == target) return mid;
		if (A[lo] <= A[mid]) {
			if (A[lo] <= target && target < A[mid]) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		} else {
			if (A[mid] < target && target <= A[hi]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
	}
	return A[lo] == target ? lo : -1;
}