#243.Shortest Word Distance (Easy)

/*Given a list of words and two words word1 and word2, return the shortest distance between 
these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.*/

//Brute force
public int shortestDistance(String[] words, String word1, String word2) {
	int minDist = words.length;
	for (int i = 0; i < words.length; i++) {
		if (words[i] == word1){
			for (int j = 0; j < words.length; j++) {
				if (words[j] == word2) {
					minDist = Math.min(minDist, Math.abs(i - j));
				}
			}
		}
	}
	return minDist;
}
/*O(n^2) time. For every occurrence of word1, we traverse the entire array in search for the 
closest occurrence of word2.
O(1) space. No additional space is allocated.*/

#OR

/*We can greatly improve on the brute-force approach by keeping two indices i1 and i2 where 
we store the most recent locations of word1 and word2. Each time we find a new occurrence of one of 
the words, we do not need to search the entire array for the other word, since we already have the 
index of its most recent occurrence.*/
public int shortestDistance(String[] words, String word1, String word2) {
	int i1 = -1;
	int i2 = -1;
	int minDist = words.length;

	for (int i = 0; i < words.length; i++) {
		if (words[i].equals(word1))
			i1 = i;
		else if (words[i].equals(word2))
			i2 = i;
		if (i1 != -1 && i2 != -1) minDist = Math.min(minDist, Math.abs(i1 - i2));
	}
	return minDist;
}
/*O(n) time. This problem is inherently linear. We cannot do better than O(n) because at the very least,
we have to read the entire input.
O(1) space. No additional space is allocated.
*/