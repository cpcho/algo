###Hash Table 1###
https://stackoverflow.com/a/730813
#Offers fast insertion and searching
#Limited in size because they are based on arrays
#Can be resized but should be avoided
#Hard to order
#Hash functions = Speed

public class Entry{
	private int key;
	private int value;
	
	Entry(int key, int value){
		this.key = key;
		this.value = value;
	}

	public int getKey(){
		return key;
	}
	public int getValue(){
		return value;
	}
}

public class HashMap{
	private final static int TABLE_SIZE = 128;
	
	Entry[] table;
	
	HashMap(){
		table = new Entry[TABLE_SIZE];
		for(int i = 0; i < TABLE_SIZE; i++){
			table[i] = null;
		}
	}
	
	public int get(int key){
		int hash = (key % TABLE_SIZE);
		while(table[hash] != null && table[hash].getKey() != key){
			hash = (hash + 1) % TABLE_SIZE;
		}
		if(table[hash] == null){
			return -1;
		}
		else{
			return table[hash].getValue();
		}	
	}

	public void put(int key, int value){
		int hash = (key % TABLE_SIZE);
		while(table[hash] != null && table[hash].getKey != key){
			hash = (hash + 1) % TABLE_SIZE;
			table[hash] = new Entry(key, value);
		}
	}
}



###Hash Table 2###
import java.util.Arrays;

public class HashFunction{

	String[] theArray;
	int arraySize;
	int itemInArray = 0;
	
	public static void main(String[] args){
		
		HashFunction theFunc = new HashFunction(30);
		
		String[] elementsToAdd = {"1", "5", "17", "21", "26"};
		
		theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
		
	}
	
	HashFunction(int size){
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "-1");
	}
	
	public void hashFunction1(String[] stringsForArray, String[] theArray){
	
		for(int n = 0; n < stringsForArray.length; n++){
		
			String newElementVal = stringsForArray[n];
			
			theArray[Integer.parseInt(newElementVal)] = newElementVal;
		
		}
	
	}
	
	public void hashFunction2(String[] stringsForArray, String[] theArray){
	
		for(int n = 0; n < stringsForArray.length; n++){
			
			String newElementVal = stringsForArray[n];
			
			int arrayIndex = Integer.parseInt(newElementVal) % 29;
			
			System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);
			
			while(theArray[arrayIndex != "-1"]){
			
				++arrayIndex;
				
				System.out.println("Collision Try " + arrayIndex + " Instead");
				
				arrayIndex %= arraySize;
				
			}
			
			theArray[arrayIndex] = newElementVal;
		}
		
	}
	
	public String findKey(String key){
		
		int arrayIndexHash = Integer.parseInt(key) % 29;
		
		while(theArray[arrayIndexHash] != "-1"){
		
			if(thearray[arrayIndexHash] == key){
				
				System.out.println(key + " was Found in Index " + arrayIndexHash);
				
				return theArray[arrayIndexHash];
			}
			
			++arrayIndexHash;
			
			arrayIndexHash %= arraySize;
			
		}
		return null;
	}
	
	public boolean isPrime(int num){
		
		if(num % 2 == 0)
			return false;
		
		for(int i = 3; i * i <= num; i+=2){
			
			if(num % i == 0 )
			return false;
			
		}
		
		return true;
		
	}
	
	public int getNextPrime(int minNumToCheck){
		for(int i = minNumToCheck; true; i++){
			
			if(isPrime(i))
				return i;
			
		}
	}

}

