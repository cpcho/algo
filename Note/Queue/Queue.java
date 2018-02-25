###Queue Pseudocode###
QUEUE {
	ENQUEUE(Q, x) {
		Q[Q.tail] = x;
		if (Q.tail == Q.length) {
			Q.tail = 1;
		}
		else {
			Q.tail = Q.tail + 1
		}
	}
	
	DEQUEUE(Q) {
		x = Q[Q.head];
		if Q.head == Q.length {
			Q.head = 1;
		} else {
			Q.head = Q.head + 1;
		}
	}
}

###Queues (FIFO)###
public class TheQueue {

	private String[] queueArray;
	private int queueSize;
	private int front, rear, numOfItems = 0;
	
	TheQueue(int size){
		
		queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
		
	}
	
	public void peek(){
		return queueArray[front];
	}
	
	public void insert(String input){
	
		if(numOfItems + 1 <= queueSize){
		
			queueArray[rear] = input;
			
			rear++;
			
			numOfItems++;
			
			System.out.println("INSERT " + input + " was added.");
			
		} else {
			System.out.println("The queue is full");
		}
	}
	
	public void remove(){
		if(numOfItems >0){
			queueArray[front] = "-1";
			
			front++;
			
			numOfItems--;
		} else {
			System.out.println("The queue is empty");
		}
	}
	
	public void priorityInsert(String input){
		int i;
		
		if(numOfItems == 0){
			insert(input);
		} else {
			for(i = numOfItems - 1; i >= 0; i--){
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
					
					queueArray[i + 1] = queueArray[i];
				} else break;
			}
			
			queueArray[i+1] = input;
			rear++;
			numOfItems++;		
		}
	}
}