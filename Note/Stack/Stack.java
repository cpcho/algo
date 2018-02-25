###Stacks & Queues###

###Stack Pseudocode###

//isEmpty, push and pop take O(1) time 
public class Stack{

	public boolean isEmpty(String[] array){
		if (array.top == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(String[] array, int x){
		array.top = array.top + 1;
		array[array.top] = x;
	}

	public void pop(String[] array){
		if (isEmpty(array)) {
			System.out.println("underflow");
		} else {
			array.top = array.top - 1
		}
		return array[array.top + 1]			
	}
}

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
	
