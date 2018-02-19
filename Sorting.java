###Sorting Algorithms###

###Bubble Sort###
public void bubbleSort(int[] arr){

	for(int i = arr.length - 1; i > 1; i-- ){
		
		#Compare each value next to each other, and if the value is greater, it swaps.
		for(int j = 0; j < i; j++){
			
			if(arr[j] > arr[j+1]){
				
				swapValues(j, j+1);
			}
		}
	}
}

###Swap Values###
public void swapValues(int indexOne, int indexTwo){
	
	int temp = theArray[indexOne];
	theArray[indexOne] = theArray[indexTwo];
	theArray[indexTwo] = temp;
}

###Binary Search###
public void binarySearch(int value) {
	
	int lowIndex = 0;
	int highIndex = arraySize - 1;
	
	while(lowIndex <= highIndex) {
		
		int middleIndex = (highIndex + lowIndex) / 2;
		
		if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
		
		else if(theArray[middleIndex] > value) highIndex =  middleIndex - 1;
		
		else {
			return middleIndex;
		}
	}
	return -1;
}

###Selection Sort###
###Find the minimum value and move it to the leftmost###
###Ascending order###
public void selectionSort(int[] arr){
	
	for(int x = 0; x < arr.length; x++){
		
		int min = x;
		for(int y = x; y < arr.length; y++) {
			
			if(arr[min] > arr[y]){
				
				min = y;
			}
		}
		swapvalues(x, min);
	}
}

###Insertion Sort###

public void insertionSort(int[] arr){
	
	for(int i = 1; i < arr.length; i++) {
		int j = i;
		int key = arr[i];
		
		while((j>0) && (arr[j-1] > key)){
			
			arr[j] = arr[j-1];
			j--;
			
		}
		
		arr[j] = key;
	}
}

