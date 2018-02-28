//https://stackoverflow.com/a/20024503


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