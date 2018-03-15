#81. Search in Rotated Sorted Array II

/*Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.*/
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search
public boolean search(int[] nums, int target) {
	int start = 0, end = nums.length - 1;
	while (start <= end) {
		int mid = start + (end - start)/2;
		if (nums[mid] == target) return true;

		// if left part is sorted.
		if (nums[start] < nums[mid]) {
			if (target < nums[start] || target > nums[mid]) {
				start = mid + 1; //target is in rotated part
			} else {
				end = mid - 1;
			}
		} else if (nums[start] > nums[mid]) {
			//right part is rotated
			if (target < nums[mid] && target > nums[end]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
  	/*duplicates, we know nums[mid] != target, so nums[start] != target based on 
  	current information, we can only move left pointer to skip one cell thus in the worst case, 
  	we would have target: 2, and array like 11111111, then the running time would be O(n)*/
		} else {
			start++;
		}
	}
	return false;
}