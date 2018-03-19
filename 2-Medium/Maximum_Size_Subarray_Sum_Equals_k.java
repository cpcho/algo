F000. Maximum Size Subarray Sum Equals k

/*Given an array nums and a target value k, find the maximum length of a subarray 
that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3, return 4. 
(because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1, return 2. 
(because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?*/


/*Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k. 
Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.

Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j]. 
So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
To achieve this, we just need to go through the array, calculate the current sum and save 
number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).

*sum - k means the array elements in between add up to k

sum is the presum for first i+1 numbers in the array, for example, sum of first 1 number is nums[0].
preSum.put(0,1); because the sum of first 0 number is 0 and this is an empty array[], which is also a 
subarray for nums. In other words, the number of time sum = 0 exists is 1.
then we loop through the array, calculate the presum for first i+1 number and check if the map contains key (sum - k) , 
if it is, we increase the result by the number of (sum - k) we get from hash map.
We also need to put all sum in the map, that’s what this line of code does: preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

we need to find the number of subarrays that whose sum equals k. To compute the sum of an subarray, it is useful to use preSum. 
For example, given an arraynums = [-3, 1, 2, -3, 5], its preSum is preSum = [0, -3, -2, 0, -3, 2]. Let’s say we want to calculate 
the sum of subarray nums[1,3] which is [1, 2, -3], it can be computed using preSum: preSum[4] - preSum[1] = -3 - (-3) = 0.
If a subarray from i to j whose sum is k, it means preSum[j+1] - preSum[i] = k. So the complement (sum - k) equals another sum.*/

public int maxSubArrayLen(int[] nums, int k) {
    int sum = 0, result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int n : nums) {
        sum += n;
        result += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return result;
}

#OR

public int maxSubArrayLen(int[] nums, int k) {
	if (nums == null || nums.length == 0) return 0;

	int maxLength = 0;
    int sum = 0;
	Map<Integer, Integer> map = new HashMap<>();
	map.put(0, -1);

	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
		if (!map.containsKey(sum)) map.put(sum, i);

		if (map.containsKey(sum - k)) {
			maxLength = Math.max(maxLength, i - map.get(sum - k));
		}
	}
	return maxLength;
}

/*Understand the problem:
The problem is equal to: find out a range from i to j, in which the sum (nums[i], ..., nums[j]) = k. 
What is the maximal range? 

So we can first calculate the prefix sum of each number, so sum(i, j) = sum(j) - sum(i - 1) = k. 
Therefore, for each sum(j), we only need to check if there was a sum(i - 1) which equals to 
sum(j) - k. We can use a hash map to store the previous calculated sum. 

Note the map.put(0, -1). We need to put this entry into the map before, because if the maximal range 
starts from 0, we need to calculate sum(j) - sum(i - 1). */