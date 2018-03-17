#350. Intersection of Two Arrays II
/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in 
both arrays. The result can be in any order.

Follow up:
Q1.What if the given array is already sorted? How would you optimize your algorithm?
Q2.What if nums1's size is small compared to nums2's size? Which algorithm is better?
Q3.What if elements of nums2 are stored on disk, and the memory is limited such that 
you cannot load all elements into the memory at once?

Answer to Q3 - If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, 
read chunks of array that fit into the memory, and record the intersections.

If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually 
(external sort), then read 2 elements from each array at a time in memory, record intersections.*/

/*The goal of this question is to test whether the interviewee understands some of the data engineering 
techniques. From a data engineer’s perspective,there are three ideas to solve the question:

1.Store the two strings in distributed system (whether self designed or not), then using MapReduce technique 
to solve the problem;
2.Processing the Strings by chunk, which fits the memory, then deal with each chunk of data at a time;
3.Processing the Strings by streaming, then check.*/

//O(m + n) time, O(min(m, n)) space
public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int i : nums1) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
        } else {
            map.put(i, 1);
        }
    }
    for (int i : nums2) {
        if(map.containsKey(i) && map.get(i) > 0) {
            list.add(i);
            map.put(i, map.get(i) - 1);
        }
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        result[i] = list.get(i);
    }
    return result;
}

#OR

public int[] intersect(int[] nums1, int[] nums2) {
	HashMap<Integer, Integer> map = new HashMap<>();
	ArrayList<Integer> result = new ArrayList<>();
	for (int i = 0; i < nums1.length; i++) {
		if (map.containsKey(nums1[i])) 
            map.put(nums1[i], map.get(nums1[i]) + 1);
		else 
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