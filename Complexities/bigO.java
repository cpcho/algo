//https://stackoverflow.com/questions/3255/big-o-how-do-you-calculate-approximate-it
//https://youtu.be/7UwDamuC-kU

public static int findNumsOfREpetitions(String s, char c) {
	/* Linear time; O(n) time*/
	int sum = 0 // 1
	for (int i = 0; i < s.length(); i++) { // 1; n+1; n
		if (s.charAt(i) == c) { // n
			sum++; // n
		}
	}
	return sum;
}

public static int[] findNumsRepetitionsv1(String s, char[] c) {
	/* Quad time: O(n * m) */
	int[] sums = new int[c.length]; // 1
	for (int i = 0; i < s.length; i++) { // running time for initial condition is 1, 
										 // second portion's running time is n + 1, and 
										 // last incremental i++ is n running time
		for (int j = 0; j < c.length; j++) { // n; n*m + 1; n*m
			if (s.charAt(i) == c[j]) { // n*m
				sums[j] = sums[j] + 1; // n*m
			}
		}
	}
	return sums; // 1
}

/*Optimization begins*/

public static int[] findNumsOfREpetitionsv2(String s, char[] c) {
	// Optimal time: O(n+m) //n + m because you never know whether int[] size is longer than char[] size
	int[] sums = new int[c.length]; // 1
	// We will use hashmap data strucuture that will take more space but will reduce the running time.
	HashMap<Character, Integer> map = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
		if (!map.containsKey(s.charAt(i))) {
			map.put(s.charAt(i), 1);
		} else {
			int sum = map.get(s.charAt(i));
			map.put(s.charAt(i), sum + 1);
		}
	}

	for (int j = 0; j < c.length; j++) {
		int sum;
		if (!map.containsKey(c[j])) {
			sums[j] = 0;
		} else {
			sums[j] = map.get(c[j]);
		}
	}
	return sums;
}