#209. Minimum Size Subarray Sum
Mock Interview Link: https://www.youtube.com/watch?v=GzQ1hX2jaQU
/*Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous 
subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the 
time complexity is O(n log n).*/

/*O(N) time, each element can be visited atmost twice, once by the right pointer and at most once by the left pointer. 
O(1) space, only constance space required

O(N) - keep a moving window expand until sum>=s, then shrink until sum<s. Each time after shrinking, update length. 
(similar to other solutions, just removed unnecessary min value assignment)*/

public int minSubArrayLen(int s, int[] a) {
	if (a == null || a.length == 0) return 0;
	int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

	while (j < a.length) {
		sum += a[j]; // sum += a[j++];
		j++;

		while (sum >= s) {
			min = Math.min(min, j - i);
			sum -= a[i];
			i++;
		}
	}
	return (min == Integer.MAX_VALUE) ? 0 : min;
}