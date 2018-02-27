#Learn one iterative inorder traversal, 
apply it to multiple tree questions.
//https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)

/*I will show you all how to tackle various tree questions 
using iterative inorder traversal. First one is the standard 
iterative inorder traversal using stack.*/

#94. Binary Tree Inorder Traversal (Medium)
/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?*/

public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	if (root == null) return list;
	Stack<TreeNode> stack = new Stack<>(); //Create an empty stack
	while (root != null || !stack.empty()) {
		while(root != null) {
			//first node to be visited will be the left one
			//if it's not null, push to stack and go down the tree to left
			stack.push(root);
			root = root.left;
		}
		//if no left child, pop stack, and proceed the node, 
		//then let root point to the right
		root = stack.pop(); //Pop root
		list.add(root.val);
		root = root.right;
	}
	return list;
}

#OR

public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	if(root == null) return list;
	Stack<TreeNode> s = new Stack<>();
	TreeNode currNode = root;

	while(currNode != null || !stack.isEmpty()) {
		if(currNode != null) {
			s.push(currNode);
			currNode = currNode.left;
		} else {
			TreeNode n = s.pop();
			list.add(n.val);
			currNode = n.right;
		}
	}
	return list;
}


/*Now, we can use this structure to find the Kth smallest element in BST.*/

#230. Kth Smallest Element in a BST (Medium)
/*Given a binary search tree, write a function kthSmallest to find the 
kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and 
you need to find the kth smallest frequently? How would you optimize 
the kthSmallest routine?*/

public int kthSmallest(TreeNode root, int k) {
	Stack<TreeNode> stack = new Stack<>();
	while(root != null || !stack.isEmpty()) {
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		root = stack.pop();
		if(--k = 0) break;
		root = root.right;
	}
	return root.val;
}

/*We can also use this structure to solve BST validation question.*/
#98. Validate Binary Search Tree (Medium)
/*Given a binary tree, determine if it is a valid 
binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with 
keys less than the node's key.

The right subtree of a node contains only nodes 
with keys greater than the node's key.
Both the left and right subtrees must also be BST.

Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.

Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.*/

public boolean isValidBST(TreeNode root) {
	if (root == null) return true;
	Stack<TreeNode> stack = new Stack<>();
	TreeNode pre = null;
	while (root != null || !stack.isEmpty()) {
		while (root !=null) {
			stack.push(root);
			root = root.left;
		}
		root = stack.pop();
		if(pre != null && root.val <= pre.val) return false;
		pre = root;
		root = root.right;
	}
	return true;
}