#350. Intersection of Two Arrays II
/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in 
both arrays.
The result can be in any order.

Follow up:
-What if the given array is already sorted? 
 How would you optimize your algorithm?
-What if nums1's size is small compared to nums2's size? 
 Which algorithm is better?
-What if elements of nums2 are stored on disk, and 
 the memory is limited such that you cannot load all elements 
 into the memory at once?*/

public int[] intersect(int[] nums1, int[] nums2) {
	HashMap<Integer, Integer> map = new HashMap<>();
	ArrayList<Integer> result = new HashMap<>();
	for (int i = 0; i < nums1.length; i++) {
		if (map.containsKey(nums1[1])) {
			map.put(nums1[i], map.get(nums1[i]) + 1);
		} else {
			map.put(nums1[i], 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				maps.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}

		int[] r = new int[result.size()];
		for (int i = 0; i < result.length; i++) {
			r[i] = result.get(i);
		}
		return r;
	}

}

#OR

public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> res = new ArrayList<Integer>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
        if(nums1[i] < nums2[j]) {
            i++;
        }
        else if(nums1[i] == nums2[j]) {
            res.add(nums1[i]);
            i++;
            j++;
        }
        else {
            j++;
        }
    }
    int[] result = new int[res.size()];
    for(int i = 0; i<res.size();i++) {
        result[i] = res.get(i);
    }
    return result;
}