###Implementation of Trie in Java###
class TrieNode {
	private TrieNode[] links;

	private final int R = 26;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public TrieNode get(char c) {
		return links[c - 'a'];
	}

	public boolean containsKey(char c) {
		return links[c - 'a'] != null;
	}

	public void put(char c, TrieNode node) {
		links[c - 'a'] = node;
	}

	private boolean isEnd;

	public void setEnd() {
		isEnd = true;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
}

class Trie { 
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
	#O(m) time complexity, where m is the key length, O(m) space complexity
		TrieNode node = root;

		for(int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!node.containsKey(currentChar)) {
				node.put(currentChar, new TrieNode());
			}
			node = node.get(currentChar);
		}
		node.setEnd();
	}

	private TrieNode searchPrefix(String word) {
	#O(m) time complexity, O(1) space complexity
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char curLetter = word.charAt(i);
			if (node.containsKey(curLetter)) {
				node = node.get(curLetter);
			} else {
				return null;
			}
		}
		return node;
	}
	
	public boolean search(String word) {
 		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	public boolean startsWith(String prefix) {
	#O(m) time complexity, O(1) space complexity
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}
}

#######################################
###Making List of Vocabulary Program###
#######################################

#Using java.util.ArrayList and java.util.Collections.binarySearch (Standard)
public class ListVocab implements Vocab {
	private List<String> words = new ArrayList<String>();

	public ListVocab(Collection<String> words){
	//Constructor that adds all the words and then sorts the underling list
		this.words.addAll(words);
		Collections.sort(this.words);
	}

	public boolean add(String word) {
		int pos = Collections.binarySearch(words, word);
		// pos > 0 means the word is already in the list.
		// Insert only if it's not there yet.
		if (pos < 0) {
			words.add(-(pos+1), words);
			return true;
		}
		return false;
	}

	public boolean isPrefix(String prefix) {
		int pos = Collections.binarySearch(words, prefix);
		//The prefix is a word. Check the following word,
		//b/c we are looking for words that are longer than prefix
		if (pos >= 0) {
			if (pos+1 < words.size()) {
				String nextWord = words.get(pos+1);
				return nextWord.startsWith(prefix);
			}
			return false;
		}
		pos = -(pos+1);
		//The prefix is not a word. Check where it would be inserted 
		//and get the next word. If it starts with prefix, return true
		if (pos == words.size()) {
			return false;
		}
		String nextWord = words.get(pos);
		return nextWord.startsWith(prefix);
	}

	public boolean contains(String word) {
		int pos = Collections.binarySearch(words, word);
		return pos >= 0;
	}
}

#Using binary tree (better)
public class TreeVocab extends TreeSet<String> implements Vocab {
	public TreeVocab(Collection<String> c) {
		super(c);
	}

	public boolean isPrefix(String prefix) {
		String nextWord = ceiling(prefix);
		if (nextWord == null) {
			return false;
		}
		if (nextWord.equals(prefix)) {
			Set<String> tail = tailSet(nextWord, false);
			if (tail.isEmpty()) {
				return false;
			}
			nextWord = tail.iterator().next();
		}
		return nextWord.startsWith(prefix);
	}
	/**
     * There is a mismatch between the parameter types of vocabulary and TreeSet, so
     * force call to the upper-class method
     */
	public boolean contais(String word) {
		return super.contais(word);
	}
}

#Using trie (best)
public LowercaseTrieVocab getNode(String s) {
	LowercaseTrieVocab node = this;
	for (int i = 0; i < s.length(); i++) {
		int index = LOWERCASE.getIndex(s.charAt(i)); 
		//return the pos of the ith character in the alphabet.
		LowercaseTrieVocab child = node.children[index];
		if (child == null) return null;
		node = child;
	}
	return node;
}


































