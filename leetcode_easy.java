#243.Shortest Word Distance
//https://leetcode.com/articles/shortest-word-distance/
public int shortestDistance(String[] words, String1, String2) {
	int minDistance = words.length;
	for (int i = 0; i < words.length; i++) {
		if (words[i] == word1){
			for (int j = 0; j < words.length; j++) {
				if (words[j] == word2) {
					minDistance = Math.min(minDistance, Math.abs(i - j));
				}
			}
		}
	}
	return minDistance;
}

public int shortestDistance(String[] words, String word1, String word2) {
	int i1 = -1;
	int i2 = -1;
	int minDistance = words.length;
	int currentDistance;

	for (int i = 0; i < words.length; i++) {
		if (words[i].equals(word1)) {
			i1 = i;
		} else if (words[i].equals(word2)) {
			i2 = i;
		}

		if (i1 != -1 && i2 != -1) {
			minDistance = Math.min(minDistance, Math.abs(i1 - i2));
		}
	}
	return minDistance;
}

#760. Find Anagram Mappings
//https://leetcode.com/articles/find-anagram-mappings/
public int[] anagramMapping(int[] A, int[] B) {

	Map<Integer, Integer> D = new HashMap();
	for (int i = 0; i < B.length; i++) {
		D.put(B[i], i);
	}
	int[] ans = new int[A.length];
	int t = 0;
	for (int x: A)
		ans[t++] = D.get(x);
	return ans;
}

public int[] anagramMapping(int[] A, int[] B) {
	int arrLength = A.length;
	int[] res = new int[arrLength];

	for (int i = 0; i < arrLength; i++) {
		for (int j = 0; j < arrLength; j++) {
			if (A[i] == B[j]) res[i] = j;
		}
	}
	return res;
}

#543. Diameter of Binary Tree (DFS)
//https://leetcode.com/articles/diameter-of-binary-tree/
//For every node, length of longest path which pass 
//it = MaxDepth of its left subtree + MaxDepth of its right subtree.
//Per the problem, the diameter of a binary tree is the length of 
//the longest path between any two nodes in a tree.
int max = 0;

public int diameterOfBinaryTree(TreeNode root) {
	maxDepth(root);
	return max;
}

private int maxDepth(TreeNode root) {
	if (root == null) return 0;
	int left = maxDepth(root.left);
	int right = maxDepth(root.right);

	max = Math.max(max, left + right);
	return Math.max(left, right) + 1;
}


#67. Add Binary
//https://leetcode.com/problems/add-binary/description/
public String addBinary(String a, String b) {
	StringBuilder sb = new StringBuilder();
	int i = a.length() - 1;
	int j = b.length() - 1;
	int carry = 0;

	while(i >= 0 || j >= 0) {
		int sum = carry;
		if (j >= 0) sum += b.charAt(j--) - '0';
		if (i >= 0) sum += a.charAt(i--) - '0';
		//https://stackoverflow.com/a/34409988/5922564
		sb.append(sum % 2);
		carry = sum / 2;
	}
	if (carry != 0) sb.append(carry);
	return sb.reverse().toString();
}





















