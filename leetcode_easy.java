#720. Longest Word in Dictionary
#Trie + DFS
class Solution {
	public String longestWord(String[] words) {
		Trie trie = new Trie();
		int index = 0;
		for (String word:words) {
			trie.insert(word, ++index); //indexed by 1
		}
		trie.words = words;
		return trie.dfs();
	}
}
class Node {
	char c;
	HashMap<Character, Node> children = new HashMap();
	int end;
	public Node(char c) {
		this.c = c;
	}
}

class Trie {
	Node root;
	String[] words;
	public Trie() {
		root = new Node('0');
	}
	
	public void insert(String word, int index) {
		Node cur = root;
		for (char c: word.toCharArray()) {
			cur.children.putIfAbsent(c, new Node(c));
			cur = cur.children.get(c);
		}
		cur.end = index;
 	}
	
	public String dfs() {
		String ans = "";
		Stack<Node> stack = new Stack();
		stack.push(root);
		while (!stack.empty()) {
			Node node = stack.pop();
			if (node.end > 0 || node == root) {
				if (node != root) {
					String word = words[node.end -1];
					if (word.length() > ans.length() ||
						word.length() == ans.length() &&
						word.compareTo(ans) < 0) { 
						ans = word;
					}
				}
				for (Node nei: node.children.values()) {
					stack.push(nei);
				}
			}
		}
		return ans;
	}
}


#Bruteforce
public String longestWord(String[] words) {
	String ans = "";
	Set<String> wordset = new HashSet();
	for (String word: words) wordset.add(word);
	for (String word: words) {
		if (word.length() > ans.length()) ||
			word.length() == ans.length() &&
			word.compareTo(ans) < 0) {
			boolean good = true;
			for (int k = 1; k < word.length(); ++k) {
				if(!wordset.contains(word.substring(0,l))) {
					good = false;
					break;
				}
			}
			if (good) ans = word;
		}	
	}
	return ans;
}




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