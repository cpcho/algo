###Selection Sort (Joe James)
//https://youtu.be/cqh8nQwuKNE
//Given an array of items, sort them in increasing order
//Selection sort is not a fast sorting algorithm because it uses nested loops to sort.
//It is useful only for small data sets.
//It runs in O(n^2)

//Inner loop starts at first unsorted item and continues through last item in list.
//So inner loop is: for (j=i; j<list.length; j++)

public int[] selectionSort (int[] list) {
	int i, j, minValue, minIndex, temp = 0;
	for (i = 0; i < list.length; i++) {
		minValue = list[i];
		minIndex = i;
		for (j = i; j < list.length; j++) {
			if (list[j] < minValue) {
				minValue = list[j];
				minIndex = j;
			}
		}
		if (minValue < list[i]) {
			temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
	}
	return list;
}

###Selection Sort 2###
//Find the minimum value and move it to the leftmost
//Ascending order
public void selectionSort(int[] arr){
	
	for(int x = 0; x < arr.length; x++){
		
		int min = x;
		for(int y = x; y < arr.length; y++) {
			
			if(arr[min] > arr[y]){
				
				min = y;
			}
		}
		swapValues(x, min);
	}
}

public void swapValues(int indexOne, int indexTwo){
	int temp = theArray[indexOne];
	theArray[indexOne] = theArray[indexTwo];
	theArray[indexTwo] = temp;
}
