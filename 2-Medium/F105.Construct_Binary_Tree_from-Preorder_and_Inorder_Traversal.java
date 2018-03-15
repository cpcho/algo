#105. Construct Binary Tree from Preorder and Inorder Traversal
/*Given preorder and inorder traversal of a tree, 
construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*2 arrays, PRE and IN.
Preorder traversing means that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so that from IN[0] to IN[4] is on the left side,
and from IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it.
*/
public TreeNode buildTree(int[] preorder, int[] inorder) {
	Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
	for (int i = 0; i < inorder.length; i++) {
		inMap.put(inorder[i], i);
	}

	TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	return root;
}

public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	if (preStart > preEnd || inStart > inEnd) return null;

	TreeNode root = new TreeNode(preorder[preStart]);
	int inRoot = inMap.get(root.val);
	int numsLeft = inRoot - inStart;

	root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	root.right = buildTree(prorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

	return root;
}