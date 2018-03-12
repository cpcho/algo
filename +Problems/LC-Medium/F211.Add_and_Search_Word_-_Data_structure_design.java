#211. Add and Search Word - Data structure design
/*Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing 
only letters a-z or . . 
A. means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

Hint:
You should be familiar with how a Trie works. If not, please work on this problem: 
Implement Trie (Prefix Tree) first.
*/

/*Using backtrack to check each character of word to search.*/
public class WordDictionary {
	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}

	private TrieNode root = new TrieNode();

	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	private boolean match(char[] chs, int k, TrieNode node) {
		if (k == chs.length) return node.isWord;
		if (chs[k] == '.') {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null && match(chs, k + 1, node.children[i])) return true;
			}
		} else {
			return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
		}
		return false;
	}
}