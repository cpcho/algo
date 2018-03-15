F000. Meeting Rooms II
/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.*/

/*two sorted array of start time and end time. 
Two pointers to iterator start array and end array. 
Iterate the time line, the current time active meeting is num of 
start minus num of end. Since need sort, still O(nlog(n)) */
public int minMeetingRooms(Interval[] intervals) {
	int n = intervals.length;
	int[] start = new int[n];
	int[] end = new int[n];
	for (int i = 0; i < n; i++) {
		start[i] = intervals[i].start;
		end[i] = intervals[i].end;
	}
	Arrays.sort(start);
	Arrays.sort(end);
	int i = 0, j = 0, res = 0;
	while (i < n) {
		if (start[i] < end[j]) {
			i++;
		} else if (start[i] > end[j]) {
			j++;
		} else {
			i++;
			j++;
		}
		res = Math.max(res, i - j);
	}
	return res;
}

#OR

public int minMeetingRooms(Interval[] intervals) {
	if (intervals == null || intervals.length == 0) return 0;
	Arrays.sort(intervals, (a, b) -> a.start - b.start);
	PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.end - b.end);
	heap.add(intervals[0]);
	for (int i = 1; i < intervals.length; i++) {
		Interval now = heap.poll();
		if (intervals[i].start >= now.end) {
			now.end = intervals[i].end;
		} else {
			heap.offer(intervals[i]);
		}
		heap.offer(now);
	}
	return heap.size();
}