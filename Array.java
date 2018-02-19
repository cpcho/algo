###Array###

public class ArrayStructures {
	
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray() {
		
		for(int i = 0; i < arraySize ; i++){
			theArray[i] = (int)(Math.random()*10)+10;
		}
	}
	
	public static void main(String[] args) {
	
		ArrayStructures newArray = new ArrayStructures();
		newArray.generateRandomArray();
		
	}
	
	public int getValueAtIndex(int index) {
		if(index < arraySize) return theArray[index];
		return 0;
	}
	
	public boolean doesArrayContainThisValue(int searchValue){
		
		boolean valueInArray = false;
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == searchValue) {
				valueInArray = true;
			}
		}
	}
	
	public void deleteIndex(int index) {
		
		if(index < arraySize) {
			for (int i = index; i < (arraySize - 1); i++) {
				theArray[i] = theArray[i+1];
			}
			arraySize--;
		}
	}
	
	public void insertValue(int value) {
		
		if(arraySize < 50) {
			theArray[arraySize] = value;
			
			arraySize++;
		}
	}

		
###Linear Search###		
public String linearSearch(int value) {
	
	boolean valueInArray = false;
	String indexWithValue = "";
	System.out.print("The value was found in the following: ");
	
	for(int i = 0; i < arraySize; i++) {
	
		if(theArray[i] == value) {
			
			valueInArray = true;
			System.out.print(i + " ");
			indexWithValue+= i + " ";
		}
	}
	
	if(!valueInArray) {
	
		indexWithValue = "None";
		System.out.print(indexWithValue);
		
	}
	System.out.print();
	return indexWithValue;	
}