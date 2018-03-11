#236.Lowest Common Ancester in Binary Tree
//https://youtu.be/13m9ZCB8gjw
/*Given a binary tree, find the lowest common ancestor (LCA) of 
two given nodes in the tree.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes v and w 
as the lowest node in T that has both v and w as descendants s
(where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be a 
descendant of itself according to the LCA definition.*/

//O(n) Time

Node lca(Node root, Node n1, Node n2) {
	if (root == null) return null;
	if (root == n1 || root == n2) return root;
	Node left = lca(root.left, n1, n2);
	Node right = lca(root.right, n1, n2);
	
	if (left != null && right != null) return root;
	if (left == null && right == null) return null;

	return left != null ? left : right;
}