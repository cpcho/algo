###Linked List###
//https://stackoverflow.com/a/4066787/5922564
//https://stackoverflow.com/a/40275367/5922564
//https://stackoverflow.com/a/9517015/5922564


###Pseudocode###
LIST-SEARCH(L,k)
// theta(n) in the worst case, since it may have to search the entire list
	x = L.head;
	while (x != null && x.key != key) {
		x = x.next;
	}
	return x

LIST-INSERT(L, x)
// produces "splices" x onto the front of the linked list
// O(1) running time

// Recall that our attribute notation can cascade, so that
// L.head.prev denotes the prev attribute of the objct that
// L.head points to.

	x.next = L.head;
	if (L.head != null)
		L.head.prev = x;
	L.head = x;
	x.prev = null;

LIST-DELETE(L, x)
// O(1) running time without giving a key.
// If given key, however, worst case would be theta(n) b/c 
// we must call LIST-SEARCH first to find the element.
// It removes an element x from a linked list L.
// It must be given a pointer to x, and it then "splices" x
// out of the list by updating pointers.
	if(x.prev != null) {
		x.prev.next = x.next;
	} else {
		L.head = x.next;
	}
	if (x.next != null)
		x.next.prev = x.prev;

###################################
###Implementation of Linked List###
###################################
class Link{
	public int data1;
	public double data2;
	public Link nextLink;
	
	//Link constructor
	public Link(int d1, double d2){
		data1 = d1;
		data2 = d2;
	}
	
	//Print Link data
	public void printLink(){
		System.out.print("{" + data1 + ", " + data2 + "} ");
	}
}

class LinkList{
	private Link first;
	
	//LinkList constructor
	public LinkList(){
		//Initialize the firstList is always null.
		head = null;
	}
	
	//Returns true if list is empty
	public boolean isEmpty(){
		return head == null;
	}
	
	//Inserts a new Link at the first of the list
	public void insert(int d1, double d2){
		Link link = new Link(d1, d2);
		link.nextLink = head;
		head = link;
	}
	
	//Deletes the link at the first of the list
	public Link delete(){
		Link temp = head;
		if(head == null){
			return null;
			//throw new NoSuchElementException(); //better way
		}
		head = head.nextLink;
		return temp;
	}
	
	//Prints list data
	public void printList(){
		Link currentLink = first;
		System.out.print("List: ");
		while(currentLink != null){
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

###Linked List  - Gayle Version###
public class Node {
	Node next;
	int data;
	public Node(int data){
		this.data = data;
	}
}

public class LinkedList { 
//Will wrap our head in order to distinguish new head from existing head
	Node head;

	public void append(int data){
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null){
			current = current.next; 
			//Keep moving and get to the end of the Linked List
		}
		current.next = new Node(data); 
		//Create a new node at the end of the Linked List
	}

	public void prepend(int data) {
		Node newHead = new Node(data); //Create a newHead node
		newHead.next = head; 
		//newHead's next value will link to the old head
		head = newHead; 
		//We need to change the head pointer, making newHead to be head
	}

	public void deleteWithValue(int data) {
		if (head == null) return;
		if (head.data == data) {
			head = head.next; 
			//Delete the head if the data to be deleted is in head
			return;
		}
			
		Node current = head;
		while (current.next != null) { 
		//Walks through the Linked List and get to the end of the list
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
}

###Linked List in Java. Written by Joe James.###
//https://www.youtube.com/watch?v=ch1uQeu0PVY
// Node class
private class Node {
	private Node nextNode;
	private int data;

	// 0-arg constructor, 1-arg constructor, 2-arg constructor
	private Node() { }
	
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


#237. Delete Node in a Linked List
public void deleteNode(ListNode node) {
	#O(1) time/space complexity
	node.val = node.next.val;
	node.next = node.next.next;
}

#206. Reverse Linked List - Reverse a singly linked list.
//https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
//Iterative way
//Time complexity: O(n)
//Space Complexity: O(1)
public ListNode reverseList(ListNode head){
	ListNode newHead = null;
	while (head != null) {
		ListNode next = head.next;
		head.next = newHead;
		newHead = head;
		head = next;
	}
	return newHead;
}

//Recursive way
public ListNode reverseList(ListNode head){
	return reverseListInt(head, null);
}

private ListNode reverseListInt(ListNode head, ListNode newHead){
	if(head == null) return newHead;
	ListNode next = head.next;
	head.next = newHead;
	return reverseListInt(next, head);
}

#369. Plus One Linked List
// i stands for the most significant digit that is going to 
// be incremented if there exists a carry.
// Dummy node can handle cases such as “9->9>-9” automatically
public ListNode plusOne(ListNode head) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode i = dummy;
	ListNode j = dummy;

	while (j.next != null) {
		j = j.next;
		if (j.val != 9) {
			i = j;
		}
	}

	if (j.val != 9) {
		j.val++;
	} else {
		i.val++;
		i = i.next;
		while (i != null) {
			i.val = 0;
			i = i.next;
		}
	}

	if (dummy.val == 0) {
		return dummy.next;
	}
	return dummy;
}
###OR###
ListNode add(ListNode root) {
    if (addOne(root)  == 1)  {
        ListNode  tmp= new ListNode<>(1);
        tmp.next = root;  
        return tmp;
    }
    return root;
}

int addOne(ListNode node) {
      if  (node == null)
          return 1;
      if  (addOne(node.next) == 1) { 
          int rem = (node.val + 1)/10;
          node.val = (node.val + 1)% 10;
          return rem;
      }
      return 0;
  }

















