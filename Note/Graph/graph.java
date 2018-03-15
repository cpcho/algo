//https://stackoverflow.com/a/20024503

class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	//we have to find the place where we want to add a new node in order to keep the tree sorted. 
	private Node addRecursive(Node curr, int val) {
		//when the current node is null, we’ve reached a leaf node and we can insert the new node in that position
		if (curr == null) return new Node(val);

		if (val < curr.value) {
			//if the new node’s value is lower than the current node’s, we go to the left child
			curr.left = addRecursive(curr.left, value);
		} else if (val > curr.value) {
			//if the new node’s value is greater than the current node’s, we go to the right child
			curr.right = addRecursive(curr.right, value);
		} else {
			//value already exists
			return curr;
		}
		return curr;
	}
	//Next, create the public method that starts the recursion from the root node.
	public void add(int val) {
		root = addRecursive(root, val);
	}

	private boolean containsNodeRecursive(Node curr, int val) {
		if (curr == null) return false;
		if (val == curr.value) return true;
		return val < curr.value ? containsNodeRecursive(curr.left, val) : containsNodeRecursive(curr.right, val);
	}

	public boolean containsNode(int val) {
		//create the public method that starts from the root.
		return containsNodeRecursive(root, val);
	}

	/*Deletion*/
	private Node deleteRecursive(Node curr, int val) {
		if (curr == null) return null;
		if (val == curr.value) {
			// Case 1: no children
			if (curr.left == null && curr.right == null) return null;
			
			// Case 2: only 1 child
			if (curr.right == null) return curr.left;
			if (curr.left == null) return curr.right;

			// Case 3: 2 children
			int smallestVal = findSmallestVal(curr.right);
			curr.value = smallestVal;
			curr.right = deleteRecursive(curr.right, smallestVal);
			return curr;
		}

		if (val < curr.value) {
			curr.left = deleteRecursive(curr.left, val);
			return curr;
		}

		curr.right = deleteRecursive(curr.right, val);
		return curr;
	}

	private int findSmallestVal(Node root) {
		return root.left == null ? root.value : findSmallestVal(root.left);
	}

	public void delete(int val) {
		deleteRecursive(root, val);
	}

	//In-order traversal
	public void trasverseInOrder(Node node) {
		if (node != null) {
			trasverseInOrder(node.left);
			System.out.print(" " + node.value);
			trasverseInOrder(node.right);
		}
	}
	//Pre-order traversal
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	} 

	//Post-order traversal
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}

	//Breadth-First Search
	public void traverseLevelOrder() {
		if (root == null) return;

		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(" " + node.value);

			if (node.left != null) nodes.add(node.left);
			if (node.right != null) nodes.add(node.right);
		}
	}


}



DFS
/*
Goes DEEP to children before going broad to neighbors
Recursive algorithm but need visited flag to prevent infinite loops
Longest path
O(n+e) => n Visits and e neighbor checks
*/

BFS
/*
Goes BROAD to neighbors before going deep
Use Queue to go in a correct order
Great for the situation when you want to see if there is a path
Shortest path
*/

public class Graph {
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static class Node {
		private int id;
		LinkedList<Node> adj = new LinkedList<Node>();
		private Node(int id) {
			this.id = id;
		}
	}

	private Node getNode(int id);
	public void addEdge(int src, int dest) {
		Node s = getNode(src);
		Node d = getNode(dest);
		s.adj.add(d);
	}
	//DFS Path
	public boolean hasPathDFS(int src, int dest) {
		Node s = getNode(src);
		Node d = getNode(dest);
		HashSet<Integer> visited = new HashSet<Integer>(); 
		//replacement for flag
		return hasPathDFS(s, d, visited);
	}

	private boolean hasPathDFS(Node src, Node dest, HashSet<Integer> visited) {
		if(visited.contains(src.id)) return false; //no path available
		visited.add(src.id);
		if (src = dest) {
			return true;
		}
		for (Node child : src.adj) {
			if (hasPathDFS(child, dest, visited)) return true;
		}
		return false;
	}

	//BFS Path
	public boolean hasPathBFS(int src, int dest) {
	//Helper method for BFS
		return hasPathBFS(getNode(src), getNode(dest));
	}

	private boolean hasPathBFS(Node src, Node dest) {
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(src);
		while (!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if (node == dest) return true; //meaning there is a path
			if (visited.contains(node.id)) continue;
			visited.add(node.id);

			for (Node child : node.adj) {
				nextToVisit.add(child); 
				//queue up children at the end of the queue to vist next
				//not prone to visit immediately, but level by level
			}
		}
		return false; //haven't found a path
	}
}	