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
	if (nums == null || nums.length == 0) return false;
	int left = 0, right = nums.length - 1;
	while (left <= right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) return true;

		if (nums[mid] < nums[right] || nums[mid] < nums[left]) { // left side unsorted, right side sorted 
			if (nums[mid] < target && target <= nums[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		} else if (nums[mid] > nums[left] || nums[mid] > nums[right] ) { // left side sorted, right side unsorted
			if (nums[left] <= target && target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		/*at this point, nums[left] == nums[mid] == nums[right], so shfiting out 
		any of the two sides won't change the result but it will help remove duplicate 
		from consideration, here we use right-- */
		} else {
			right--;
		}
	}
	return false;
}

#OR

public boolean search(int[] nums, int target) {
	if (nums == null || nums.length == 0) return false;
	int start = 0, end = nums.length - 1;
	while (start != end) {
		int mid = (start + end) / 2;
		if (nums[mid] == target) return true;
		if (nums[mid] < nums[end]) {
			if (nums[mid] < target && nums[end] >= target)
				start = mid + 1;
			else
				end = mid;
		} else if (nums[mid] > nums[end]) {
			if (nums[start] <= target && nums[mid] > target)
				end = mid;
			else
				start = mid + 1;
		} else {
			end--;
		}
	}
	return nums[start] == target;
}