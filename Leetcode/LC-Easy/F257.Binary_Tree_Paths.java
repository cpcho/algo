#257. Binary Tree Paths (Easy)

/*Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:
["1->2->5", "1->3"]*/

public List<String> binaryTreePaths(TreeNode root) {
	List<String> answer = new ArrayList<String>();
	if (root != null) searchBT(root, "", answer);
	return answer;
}

private void searchBT(TreeNode root, String path, List<String> answer) {
	if (root.left == null && root.right == null) answer.add(path + root.val);
	if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
	if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
}

/*The time complexity for the problem should be O(n), 
since we are basically visiting each node in the tree. 
Yet an interviewer might ask you for further optimization 
when he or she saw a string concatenation. 
A string concatenation is just too costly.
A StringBuilder can be used although a bit tricky since it is
not immutable like string is.

When using StringBuilder, We can just keep track of the length of 
the StringBuilder before we append anything to it before recursion 
and afterwards set the length back. Another trick is when to 
append the “->”, since we don’t need the last arrow at the 
end of the string, we only append it before recurse to the next 
level of the tree.*/

#OR#

public list<String> binaryTreePaths(TreeNode root) {
	List<String> res = new ArrayList<>();
	StringBuilder sb = new StrinbBuilder();
	helper(res, root, sb);
	return res;
}

public void helper(List<String> res, TreeNode root, StringBuilder sb) {
	if(root == null) return;
	
	int len = sb.lnegth();
	sb.append(root.val);
	if(root.left == null && root.right == null) {
		res.add(sb.toString());
	} else {
		sb.append("->");
		helper(res, root.left, sb);
		helper(res, root.right, sb);
	}
	sb.setLength(len);
}