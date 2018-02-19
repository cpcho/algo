###Stacks & Queues###

###Stack (LIFO)###
https://stackoverflow.com/a/10852523/5922564

public class TheStack{
	
	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	
	TheStack(int size){
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}

	public String peek(){
		return stackArray[topOfStack];
	}
	
	public void push(String input){
		
		if(topOfStack + 1 < stackSize){
			
			topOfStack++;
			stackArray[topOfStack] = input;
			
		} else System.out.println("Stack is full");
		
		System.out.println("PUSH" + input + " was added.");
	}
	
	public void pop(){
		
		if(topOfStack >= 0){
			
			System.out.println("POP" + stackArray[topOfArray] + " was removed.");
			stackArray[topOfArray] = "-1";
			return stackArray[topOfStack--];
		
		} else {
			System.out.println("The stack is empty");
			return "-1";
		}
	}
	
	public void pushMany(String multipleValues){
		
		String[] tempString = multipleValues.split(" ");
		
		for(int i = 0; i < tempString.length; i++){
			
			push(tempString[i]);
			
		}
	}
	
	public void popAll(){
		
		for(int i = topOfStack; i >= 0; i--){
			pop();
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