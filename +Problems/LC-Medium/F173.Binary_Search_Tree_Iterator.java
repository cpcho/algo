#173. Binary Search Tree Iterator

/*Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and 
uses O(h) memory, where h is the height of the tree.*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

#OR
public class BSTIterator {
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		fillStack(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode cur = stack.pop();
		fillStack(cur.right);
		return cur.val;
	}

	private void fillStack(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}

#OR

public class BSTIterator {
	private Stack<TreeNode> stack;

	public BTSIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			if (cur.left != null)
				cur = cur.left;
			else
				break;
		}
	}

	 /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
    	TreeNode cur = node;
    	if (cur.right != null) {
    		cur = cur.right;
    		while (cur != null) {
    			stack.push(cur);
    			if (cur.left != null)
    				cur = cur.left;
    			else
    				break;
    		}
    	}
    	return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */




#OR
public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
    	pushAll(root);    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }

    private void pushAll(TreeNode node) {
    	for (; node != null; stack.push(node), node.left);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */