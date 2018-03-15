###Bubble Sort (Joe James)###
//https://youtu.be/F13_wsHDIG4
//Given an array of items, sort them in increasing order
//Repeatedly compares adjacent items and move larger items to the rightmost
//Larger items "bubble" right
//Bubble sort is not an efficient sorting algorithm b/c it uses nested loops
//It is usefull only for small data sets.
//It runs in O(n^2)

public int[] bubbleSort (int[] list) {
	int i, j, temp = 0;
	for (i = 0; i < list.length - 1; i++) {
		for (j = 0; j < list.length - 1 - i; j++) {
		//subtract the number of items, i, that are already sorted in right bubble 
			if (list[j] > list[j + 1]) {
			//If item in the left is greater than item on the right, we swap them
				temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
			}
		}
	}
	return list;
}

###Bubble Sort 2###
public void bubbleSort(int[] arr){

	for(int i = arr.length - 1; i > 1; i-- ){
		
		//Compare each value next to each other, and if the value is greater, it swaps.
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