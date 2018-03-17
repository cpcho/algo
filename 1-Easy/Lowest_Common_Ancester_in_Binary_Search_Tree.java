#235.Lowest Common Ancester in Binary Search Tree
/*Given a binary search tree (BST), find the lowest common ancestor 
(LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes v 
and w as the lowest node in T that has both v and w as 
descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
Another example is LCA of nodes 2 and 4 is 2, since a node can be a 
descendant of itself according to the LCA definition.*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root.val > Math.max(p.val, q.val)) {
           return lowestCommonAncestor(root.left, p, q);
       } else if (root.val < Math.min(p.val, q.val)) {
           return lowestCommonAncestor(root.right, p, q);
       } else {
           return root;
       }
}

#OR

Node lca(Node root, Node n1, Node n2) {
	if (root.val > Math.max(n1.data, n2.data)) {
		return lca(root.left, n1, n2); 
	} else if (root.val < Math.min(n1.data, n2.data)) {
		return lca(root.right, n1, n2);
	} else {
		return root;
	}
}