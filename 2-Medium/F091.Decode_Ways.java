#91. Decode Ways (medium)
/*A message containing letters from A-Z is being encoded to numbers 
using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number 
of ways to decode it.

For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.*/

/*The basic concept is to build up the number of ways to get to state i from all the prev states less than i (i-1). 

We can do this by initializing a cache with a size of s.length() + 1. We always set waysToDecode[0] to 1 because there is only 1 way to decode an empty string.
We can then build up the number of ways to decode starting from the first value and work our way toward the end.
We only ever need to look at the character at i - 1 because we can’t have values greater than 26, so three digits is never possible. 

There are four possibilities to consider: 

1) The prev value is 0 and the curr value is 0, we can’t make progress, return 0.
2) The curr value is 0, we have to use the prev value, if it is greater than 2, we can’t make progress, 
return 0, otherwise we have to transition to this state from waysToDecode[i - 1]. 
3) The prev value is 0, we can’t use the prev, so the only way to transition to the curr state is 
from the prev, so use waysToDecode[i]. 
4) Lastly, both prev and curr can be used so there are two ways to transition to the curr state, thus at 
waysToDecode[i + 1] we can get here by using all the ways we can get to waysToDecode[i] + all the ways to get to waysToDecode[i - 1].
Keep in mind that the indices are adjusted for the cache because its size differs from the string size.*/

/*O(n) runtime, O(1) space. Use a rolling array to get O(1) space*/

public int numDecodings (String s) {
	if (s.isEmpty() || s.charAt(0) - '0' == 0) return 0;
	int[] waysToDecode = new int[s.length() + 1];
	waysToDecode[0] = 1;
	waysToDecode[1] = 1;
	for (int i = 1; i < s.length(); i++){
		int curr = s.charAt(i) - '0';
		int prev = s.charAt(i - 1) - '0';

		//can't make progress, return 0
		if (prev == 0 && curr == 0 || curr == 0 && ((prev * 10 + curr) > 26)) {
			return 0;
		//can't use the prev value, so use current state
		} else if (prev == 0 || (prev * 10 + curr) > 26) {
			waysToDecode[i+1] = waysToDecode[i];
		//can't use current state, can get to this state from (i - 1) state
		} else if (curr == 0) {
			waysToDecode[i+1] = waysToDecode[i-1];
		//can get to this state from two previous states
		} else {
			waysToDecode[i+1] = waysToDecode[i] + waysToDecode[i-1];
		}
	}
	return waysToDecode[waysToDecode.length - 1];
}

#OR

/*DFS, O(n) time*/

public int numDecodings(String s) {
	if (s == null || s.length() == 0) return 0;
	return dfs(s, 0);
}

private int dfs(String s, int i) {
	if (i == s.length()) return 1; //return 1 if whole string has been decoded.
	if (s.charAt(i) == '0') return 0;
	if (i < s.length() - 1 && Integer.valueOf(s.substring(i, i+2)) < 26) {
		return dfs(s, i+1) + dfs(s, i+2);
	} else {
		return dfs(s, i+1);
	}
}