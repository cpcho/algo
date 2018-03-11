#114. Flatten Binary Tree to Linked List (Medium)

/*Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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

//This is a post-order traverse, and also a reverse of preorder.
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}

#OR
//Reusable
public void flatten(TreeNode root) {
	flatten(root, null);   
}

private TreeNode flatten(TreeNode root, TreeNode pre) {
	if (root == null) return pre;
	pre = flatten(root.right, pre);
	pre = flatten(root.left, pre);
	root.right = pre;
	root.left = null;
	pre = root;
	return pre;
}
