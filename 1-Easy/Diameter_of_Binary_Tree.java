#543. Diameter of Binary Tree (Easy)
/*Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between 
any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by 
the number of edges between them.*/

/*For every node, length of longest path which pass 
it = MaxDepth of its left subtree + MaxDepth of its right subtree.
Per the problem, the diameter of a binary tree is the length of 
the longest path between any two nodes in a tree.*/

//https://youtu.be/ey7DYc9OANo
//https://youtu.be/_O-mK2g_jhI

/*O(N) time, visiting every node once.
**O(H) space, the size of implicit call stack during DFS.*/
public class Solution{

  int ans = 0;
      
  public int diameterOfBinaryTree(TreeNode root) {
      depth(root);
      return ans;
  }

  private int depth(TreeNode root) {
      if (root == null) return 0;

      int left = depth(root.left);
      int right = depth(root.right);
      
      ans = Math.max(ans, left + right);
      
      return Math.max(left, right) + 1;
  }
}

#OR
/*calculate the depth of a node in the usual way: 
max(depth of node.left, depth of node.right) + 1.
While we do, a path "through" this node uses 
1 + (depth of node.left) + (depth of node.right) nodes. 
Let's search each node and remember the highest number of 
nodes used in some path. 

The desired length is 1 minus this number.*/
class Solution {
  int ans;

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 1;
    depth(root);
    return ans - 1;
  }

  public int depth(TreeNode root) {
    if (root == null) return 0;
    int left = depth(root.left);
    int right = depth(root.right);
    ans = Math.max(ans, left+right+1);
    return Math.max(left, right) + 1;
  }
}

#OR
/*The longest path through the root is simply the sum of 
the heights of the left & right sub-trees plus 1 (for the root node), 
and the other two can be found recursively*/
public int diameterOfBinaryTree(TreeNode root) {        
  if (root == null) return 0;
  int total = getHeight(root.left) + getHeight(root.right) + 1;
  int left = diameterOfBinaryTree(root.left);
  int right = diameterOfBinaryTree(root.right);
  return Math.max(total, Math.max(left, right));
}

public int getHeight(TreeNode root) {
  if (root == null) return 0;
  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

