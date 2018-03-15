#56. Merge Intervals
/*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
- O(n log n) time: Other than the sort invocation, we do a simple linear scan of the list, 
so the runtime is dominated by the O(nlgn) complexity of sorting.
Sorting takes O(n log(n)) and merging the intervals takes O(n).
- O(1) or O(n):If we can sort intervals in place, we do not need more than constant additional 
space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
*/

#OR

public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1) return intervals;

    // sort by ascending starting point using an anonymous comparator
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

    List<Interval> result = new LinkedList<Interval>();
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;

    for (Interval interval : intervals) {
    	if (interval.start <= end) {
    		// Overlapping intervals, move the end if needed
    		end = Math.max(end, interval.end);
    	} else {
    		// Disjoint intervals, add the previous one and reset bounds
    		result.add(new Interval(start, end));
    		start = interval.start;
    		end = interval.end;
    	}
    }
    // add the last interval
    result.add(new Interval(start, end));
    return result;
}

#OR

public List<Interval> merge(List<Interval> intervals) {
	// sort start&end
	int n = intervals.size();
	int[] start = new int[n];
	int[] end = new int[n];

	for (int i = 0; i < n; i++) {
		start[i] = intervals.get(i).start;
		end[i] = intervals.get(i).end;
	}
	Arrays.sort(start);
	Arrays.sort(end);

	List<Interval> result = new ArrayList<Interval>();
	for (int i = 0, j = 0; i < n; i++) { // j is start of interval
		if (i == n - 1 || start[i+1] > end[i]) {
			result.add(new Interval(start[j], end[i]));
			j = i + 1;
		}
	}
	return result;
}

#OR
public List<Interval> merge(List<Interval> intervals) {
	List<Interval> result = new LinkedList<Interval>();
	Collections.sort(intervals, new Comparator<Interval>() {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	});

	int i = 0;
	while (i < intervals.size() - 1) {
		Interval current = intervals.get(i);
		Interval next = intervals.get(i+1);
		if (next.start <= current.end) {
			int max = Math.max(next.end, current.end);
			current.end = max;
			intervals.remove(i+1);
		} else {
			i++;
		}
	}
	return intervals;
}