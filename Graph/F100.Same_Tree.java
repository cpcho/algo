#100. Same Tree (Easy)
/*
Given two binary trees, write a function to check if 
they are the same or not.
Two binary trees are considered the same if they are 
structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
*/

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