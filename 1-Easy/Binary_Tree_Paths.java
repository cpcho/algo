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

/*The time complexity for the problem should be O(n), since we are basically visiting 
each node in the tree. Yet an interviewer might ask you for further optimization when 
one saw a string concatenation. A string concatenation is just too costly.
A StringBuilder can be used although a bit tricky since it is not immutable like string is.

When using StringBuilder, We can just keep track of the length of the StringBuilder 
before we append anything to it before recursion and afterwards set the length back. 
Another trick is when to append the “->”, since we don’t need the last arrow at the 
end of the string, we only append it before recurse to the next level of the tree.*/
public list<String> binaryTreePaths(TreeNode root) {
	List<String> ans = new ArrayList<>();
	StringBuilder sb = new StrinbBuilder();
	searchBT(ans, root, sb);
	return ans;
}

public void searchBT(List<String> ans, TreeNode root, StringBuilder sb) {
	if(root == null) return;
	int len = sb.lnegth();
	sb.append(root.val);
	if(root.left == null && root.right == null) {
		ans.add(sb.toString());
	} else {
		sb.append("->");
		searchBT(ans, root.left, sb);
		searchBT(ans, root.right, sb);
	}
	sb.setLength(len);
}

#OR

public List<String> binaryTreePaths(TreeNode root) {
	List<String> ans = new ArrayList<String>();
	if (root != null) searchBT(root, "", ans);
	return ans;
}

private void searchBT(TreeNode root, String path, List<String> ans) {
	if (root.left == null && root.right == null) ans.add(path + root.val);
	if (root.left != null) searchBT(root.left, path + root.val + "->", ans);
	if (root.right != null) searchBT(root.right, path + root.val + "->", ans);
}