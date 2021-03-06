#26. Remove Duplicates from Sorted Array
/*Given a sorted array, remove the duplicates in-place such that each element 
appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the 
input array in-place with O(1) extra memory.

Example:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements 
of nums being 1 and 2 respectively. It doesn't matter what you leave beyond 
the new length.

O(n) time, n is the length of array, each of two pointers traverse at most n steps.
O(1) space
*/

public int removeDuplicates(int[] nums) {
	int i = 0;
	for (int n : nums) {
		if (i == 0 || n > nums[i - 1]) nums[i++] = n;
	}
	return i;
}

#OR

public int removeDuplicates(int[] nums) {
	int i = nums.length > 0 ? 1 : 0;
	for (int n : nums) {
		if (n > nums[i - 1]) nums[i++] = n;
	}
	return i;
}

#OR
public int removeDuplicates(int[] nums) {
	if (nums.length == 0) return 0;
	int i = 0;
	for (int j = 1; j < nums.length; j++) {
		if (nums[j] != nums[i]) {
			i++;
			nums[i] = nums[j];
		}
	}
	return i + 1;
}