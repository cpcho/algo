###Linked List###
//https://stackoverflow.com/a/4066787/5922564
//https://stackoverflow.com/a/40275367/5922564
//https://stackoverflow.com/a/9517015/5922564

###Pseudocode###
LIST-SEARCH(L,k) // theta(n) in the worst case, since it may have to search the entire list.
	x = L.head;
	while (x != null && x.key != key) {
		x = x.next;
	}
	return x

LIST-INSERT(L, x)
/*Produces "splices" x onto the front of the linked list.
O(1) Time.
Recall that our attribute notation can cascade, so that L.head.prev denotes the 
prev attribute of the objct that L.head points to.*/

	x.next = L.head;
	if (L.head != null)
		L.head.prev = x;
	L.head = x;
	x.prev = null;

LIST-DELETE(L, x)
/*O(1) running time without giving a key.
If given key, however, worst case would be theta(n) b/c we must call LIST-SEARCH first to find the element.
It removes an element x from a linked list L. It must be given a pointer to x, and it then "splices" x
out of the list by updating pointers.*/
	if (x.prev != null) {
		x.prev.next = x.next;
	} else {
		L.head = x.next;
	}
	if (x.next != null)
		x.next.prev = x.prev;

/*Linked List by Gayle*/
public class Node {
	Node next;
	int data;
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedList {
	Node head; // Wrap our head to distinguish new head from existing head

	public void append(int data) {
		if (head == null) head = new Node(data);
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next; // Keep moving and get to the end of the Linked List
		}
		curr.next = new Node(data); // Create a new node at the end of the Linked List
	}

	public void prepend(int data) {
		Node newHead = new Node(data); // Create a newHead node
		newHead.next = head; // newHead's next value will link to the old head
		head = newHead; // We need to change the head pointer, making newHead to be head
	}

	public void deleteWithValue(int data) {
		if (head == null) return;
		if (head.data == data) {
			head = head.next; // Delete the head if the data to be deleted is in head
			return;
		}
		Node curr = head;
		while (curr.next != null) { // Walks through the Linked List and get to the end of the list
			if (curr.next.data == data) {
				curr.next = curr.next.next;
				return;
			}
			curr = curr.next;
		}
	}
}

/*Linked List by Joe James. https://www.youtube.com/watch?v=ch1uQeu0PVY*/
private class Node {
	private Node nextNode;
	private int data;

	private Node() {} // 0-arg constructor, 1-arg constructor, 2-arg constructor
	
	private Node(int val) {
		data = val;
	}
	
	private Node(int val, Node next) {
		data = val;
		nextNode = next;
	}
	
	private void setData(int val) {
		this.data = val;
	}
	
	private int getData() {
		return this.data;
	}
	
	private void setNextNode(Node n) {
		this.nextNode = n;
	}
	
	private Node getNextNode() {
		return this.nextNode;
	}
}

public class LinkedList {
	Node root;
	int size;
	
	public LinkedList() {
		root = new Node();
		size = 0;
	}
	
	// Test code - main function
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		System.out.println(ll.getSize());
		ll.add(8);
		System.out.println(ll.getSize());
		ll.add(17);
		ll.add(5);
		ll.add(10);
		System.out.println(ll.find(17).getData());
		ll.remove(5);
		System.out.println(ll.getSize());
		System.out.println(ll.find(5));
	}
	
	public void setSize(int s) {
		this.size = s;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Node add(int data) {
		Node newNode = new Node(data, root);
		this.root = newNode;
		this.size++;
		return newNode;
	}
	
	public Node find(int data) {
		Node thisNode = this.root;
		
		while (thisNode != null) {
			if (thisNode.getData() == data)
				return thisNode;
			thisNode = thisNode.getNextNode();
		}
		return null;
	}
	
	public boolean remove(int data) {
		Node thisNode = this.root;
		Node prevNode = null;
		
		while (thisNode != null) {
			if (thisNode.getData() == data) {
				if (prevNode != null)
					prevNode.setNextNode(thisNode.getNextNode());
				else
					this.root = null;
				this.setSize(this.getSize()-1);
				return true;
			}
			prevNode = thisNode;
			thisNode = thisNode.getNextNode();
		}
		return false;
	}
}

/*Linked List Implementation*/
class Link{
	public int data1;
	public double data2;
	public Link nextLink;
	
	public Link(int d1, double d2) { //Link constructor
		data1 = d1;
		data2 = d2;
	}

	public void printLink() { //Print Link data
		System.out.print("{" + data1 + ", " + data2 + "} ");
	}
}

class LinkList{
	private Link head;
	
	public LinkList() { // LinkList constructor
		head = null; // Initialize the firstList is always null.
	}
	
	public boolean isEmpty() {
		return head == null; // Returns true if list is empty
	}
	
	public void insert(int d1, double d2) {
		Link link = new Link(d1, d2);
		link.nextLink = head;
		head = link; // Inserts a new Link at the first of the list
	}
	
	
	public Link delete() { // Deletes the link at the first of the list
		Link temp = head;
		if(head == null) throw new NoSuchElementException(); // Better way
		head = head.nextLink;
		return temp;
	}

	public void printList(){ //	Prints list data
		Link currentLink = head;
		System.out.print("List: ");
		while(currentLink != null) {
			currentLink.printLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println("");
	}
}

class LinkListTest{
	public static void main(String[] args){
		LinkList list = new LinkList();
		
		list.insert(1, 1.01);
		list.insert(2, 2.02);
        list.insert(3, 3.03);
        list.insert(4, 4.04);
        list.insert(5, 5.05);
		
		list.printList();
		
		while(!list.isEmpty()) {
            Link deletedLink = list.delete();
            System.out.print("deleted: ");
            deletedLink.printLink();
            System.out.println("");
        }
        list.printList();
	}
}

###Linked List - Doubly Linked###
class Neighbor{
	public String homeOwnerName;
	public int houseNumber;
	
	public Neighbor next;
	public Neighbor previous;

	public Neighbor(String homeOwnerName, int houseNumber){
		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;
	}
	
	public void display(){
		System.out.println(homeOwnerName + ": " + houseNumber + " Privet Drive");
	}
	
	public String toString(){
		return homeOwnerName;
	}
	
}

public class DoubleEndedLinkedList{
	Neighbor firstLink;
	Neighbor lastLink;
	
	public void insertInFirstPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		if(isEmpty()){
		
			lastLink = theNewLink;
		
		} else {
		
			firstLink.previous = theNewLink;
		
		}
		
		theNewLink.next = firstLink;
		firstLink = theNewLink;
	
	}
	
	public void insertInLastPosition(String homeOwnerName, int houseNumber){
		
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		if(isEmpty()){
		
			firstLink = theNewLink;
		
		} else {
		
			lastLink.next = theNewLink;
			theNewLink.previous = lastLink;
		
		}
		
		lastLink = theNewLink;
	}
	
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key){
		
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		Neighbor currentNeighbor = firstLink;
		
		while(currentNeighbor.houseNumber != key){
			
			currentNeighbor = currentNeighbor.next;
			
			if(currentNeighbor == null){
				return false;
			}
		}
		
		if(currentNeighbor == lastLink){
			theNewLink.next = null;
			lastLink = theNewLink;
		} else {
			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink;
		}
		
		thenewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;
		
	}
	
	public void insertInOrder(String homeOwnerName, int houseNumber){
		
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		Neighbor previousNeighbor = null;
		Neighbor currentNeighbor = firstLink;
		
		while((currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)){
			
			previousNeighbor = currentNeighbor; //assign currentNeighbor to the previousNeighbor
			currentNeighbor = currentNeighbor.next;
			
		}
		
		if(previousNeighbor == null){
			firstLink = theNewLink;
		} else{
			previousNeighbor.next = theNewLink;
		}
		
		theNewLink.next = currentNeighbor;
		
	}

	public void display(){
		Neighbor theLink = firstLink;
		
		while(theLink != null){
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			theLink = theLink.next;
			
			System.out.println("");
		}	
	}	
}

class NeighborIterator{
	
	Neighbor currentNeighbor;
	Neighbor previousNeighbor;
	
	DoubleEndedLinkedList theNeighbors;

	NeighborIterator(DoubleEndedLinkedList theNeighbors){
		this.theNeighbors = theNeighbors;
		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;
	}
	
	public boolean hasNext(){
		if(currentNeighbor.next != null){
			return true;
		}
		return false;
	}
	
	public Neighbor next(){
		if(hasNext()){
			
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
			
			return currentNeighbor;
			
		}
		return null;
	}
	
	public void remove(){
		if(previousNeighbor == null){
			theNeighbors.firstLink = currentNeighbor.next;
		} else {
			previousNeighbor.next = currentNeighbor.next;
			
			if(currentNeighbor.next == null){
				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;
			} else{
				currentNeighbor = currentNeighbor.next;
			}
		}
	}
}