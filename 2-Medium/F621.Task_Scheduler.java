#621. Task Scheduler

/*Given a char array representing tasks CPU need to do. It contains capital letters A to Z where 
different letters represent different tasks. Tasks could be done without original order. 
Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be 
at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].*/

/*Priority-Queue Method
We need to arrange the characters in string such that each same character is K distance apart, 
where distance in this problems is time b/w two similar task execution.

Idea is to add them to a priority Q and sort based on the highest frequency.
And pick the task in each round of ‘n’ with highest frequency. As you pick the task, decrease the 
frequency, and put them back after the round.*/
public int leastInterval (char[] tasks, int n) {
	int[] frequencies = new int[26];
	for (char c : tasks) frequencies[c - 'A']++;

	Queue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
	for (int i : frequencies) {
		if (i != 0) pq.add(i);
	}

	Map<Integer, Integer> map = new HashMap<>();
	int time = 0;
	int tasksRemaining = tasks.length;
	while (tasksRemaining > 0) {
		Integer prev = map.get(time);
		if (prev != null) pq.add(prev);
		Integer cur = pq.poll();
		if (cur != null) tasksRemaining--;
		if (cur != null && --cur > 0) map.put(time + n + 1, cur);
		time++
	}
	return time;
}

/*
++a increments and then uses the variable.
a++ uses and then increments the variable.

If you have

a = 1;

and you do

System.out.println(a++); //You will see 1

//Now a is 2

System.out.println(++a); //You will see 3*/

//Sorting Method
public int leastInterval(char[] tasks, int n) {
	int[] map = new int[26];
	for (char c : tasks) {
		map[c - 'A']++;
	}
	Arrays.sort(map);
	int time = 0;
	while (map[25] > 0) {
		int i = 0;
		while (i <= n) {
			if (map[25] == 0) break;
			if (i < 26 && map[25 - i] > 0) map[25 - i]--;
			time++;
			i++;
		}
		Arrays.sort(map);
	}
	return time;
}

#OR
public int leastInterval(char[] tasks, int n) {
	int[] c = new int[26];
	for (char t : tasks) {
		c[t - 'A']++;
	}
	Arrays.sort(c);
	int i = 25;
	while (i >= 0 && c[i] == c[25]) i--;

	return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
}

/*consider the most frequent characters, we can determine their relative positions first and use 
them as a frame to insert the remaining less frequent characters. Here is a proof by construction:

Let F be the set of most frequent chars with frequency k.
We can create k chunks, each chunk is identical and is a string consists of chars in F in a specific fixed order.
Let the heads of these chunks to be H_i; then H_2 should be at least n chars away from H_1, 
and so on so forth; then we insert the less frequent chars into the gaps between these chunks sequentially 
one by one ordered by frequency in a decreasing order and try to fill the k-1 gaps as full or evenly 
as possible each time you insert a character. In summary, append the less frequent characters to the end of 
each chunk of the first k-1 chunks sequentially and round and round, then join the chunks and keep 
their heads’ relative distance from each other to be at least n.

Examples:

AAAABBBEEFFGG 3

here X represents a space gap:

Frame: "AXXXAXXXAXXXA"
insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
insert 'E': "ABEXABEXABXXA"
insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
insert 'G': "ABEFABEGABFGA"

AACCCBEEE 2

3 identical chunks "CE", "CE CE CE" <-- this is a frame
insert 'A' among the gaps of chunks since it has higher frequency than 'B' ---> "CEACEACE"
insert 'B' ---> "CEABCEACE" <----- result is tasks.length;

AACCCDDEEE 3

3 identical chunks "CE", "CE CE CE"
Begin to insert 'A'->"CEA CEA CE"
Begin to insert 'B'->"CEABCEABCE" <---- tasks.length;

ACCCEEE 2

3 identical chunks "CE", "CE CE CE" <-- this is a frame
Begin to insert 'A' --> "CEACE CE" <-- result is (c[25] - 1) * (n + 1) + 25 -i = 2 * 3 + 2 = 8

For the last line (c[25] - 1) * (n + 1) + 25 - i:

	c[25]-1: we have totally “c[25]” frames,
	*(n+1): the length of each frame, each of the first c[25]-1 frames must have a length of “n+1”
	+25-i: count for the most frequent letters, it is the length of the last frame*/


#OR
//One Pass Solution
public int leastInterval(char[] tasks, int n) {
	int len = tasks.length;
	int[] count = new int[26];
	int max = 0, maxNum = 0;
	for (char c : tasks) {
		count[c - 'A']++;
		if (count[c - 'A'] > max) {
			max = count[c - 'A'];
			maxNum = 1;
		} else if (count[c - 'A'] == max) {
			maxNum++;
		}
	}
	return Math.max(len, (max - 1) * (n + 1) + maxNum);
}