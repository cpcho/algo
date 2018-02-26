#Problems:
//https://leetcode.com/explore/interview/card/facebook/

#100. Same Tree
//https://leetcode.com/problems/same-tree/description/
public boolean isSameTree(TreeNode p, TreeNode q) {
	// Equal nullity denotes that this branch is the same (local equality)
    // This is a base case, but also handles being given two empty trees
	if(p == null && q == null) return true;

	// Unequal nullity denotes that the trees aren't the same
    // Note that we've already ruled out equal nullity above
	if(p == null || q == null) return false;

	// Both nodes have values; descend iff those values are equal
    // "&&" here allows for any difference to overrule a local equality
	if(p.val == q.val)
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	// If we're here, both nodes have values, and they're unequal, so the trees aren't the same
	return false;
}

#17. Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
/*
 For each digit added, remove and copy every element in the queue and add the possible 
 letter to each element, then add the updated elements back into queue again. 
 Repeat this procedure until all the digits are iterated.
*/
public List<String> letterCombinations(String digits) {
	LinkedList<String> queue = new LinkedList<String>();
	if(digits.isEmpty()) return queue; //if(digits == null || digits.length() == 0) return queue;
	String[] buttonMapping = new String[] {"0", "1", "abc", "def", "ghi", 
									 "jkl", "mno", "pqrs", "tuv", "wxyz"};
	queue.add("");
	for(int i = 0; i < digits.length(); i++){
		int x = Character.getNumericValue(digits.charAt(i));
		while(queue.peek().length() == i) {
			String t = queue.remove();
			for(char s: buttonMapping[x].toCharArray())
				queue.add(t+s);
		}
	}
	return queue;
}






