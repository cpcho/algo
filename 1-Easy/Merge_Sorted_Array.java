#88. Merge Sorted Array
/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as 
one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. The number of elements initialized in 
nums1 and nums2 are m and n respectively.*/

/*What if you fill the longer array from the end instead of start?

Merge nums1[0..n1-1] and nums2[0..n2-1] into merged[0..n1+n2-1]*/

public static void mergeArrays(int[] nums1, int[] nums2, int n1, int n2, int[] merged) {
	int i = 0, j = 0, k = 0;
		while (i<n1 && j <n2) { // Traverse both array
		/*Check if current element of first array is smaller than current element 
		of second array. If yes, store first array element and increment first array
		index. Otherwise do same with second array*/
		if (nums1[i] < nums2[j])
		    merged[k++] = nums1[i++];
		else
		    merged[k++] = nums2[j++];
		}

		// Store remaining elements of first array
		while (i < n1)
			merged[k++] = nums1[i++];

		// Store remaining elements of second array
		while (j < n2)
			merged[k++] = nums2[j++];
		}
