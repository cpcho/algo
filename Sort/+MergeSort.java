###Merge Sort###
//https://youtu.be/iMT7gTPpaqw
//Given an array of items, sort them in ascending order
//MergeSort is recursive (method that calls itself)
//Divide-and-Conquer algorithm
//Very efficient for large data sets
//Merge sort does log n merge steps b/c each merge step doubles the list size.
//It does n work for each merge step b/c it must look at every item
//So it runs in O(n log n)


public void mergeSort (int[] list, int lowIndex, int highIndex) {
	if (lowIndex == highIndex)
		return;
	else {
		int midIndex = (lowIndex + highIndex) / 2;
		mergeSort(list, lowIndex, midIndex);
		mergeSort(list, midIndex + 1, highIndex);
		merge(list, lowIndex, midIndex, highIndex);
	} 
}

public void merge(int[] list, int lowIndex, int midIndex, int highIndex) {
	int[] L = new int[midIndex - lowIndex + 2];
	
	for (int i = lowIndex; i <= midIndex; i++) {
		L[i - lowIndex] = list[i];
	}
	L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
	int[] R = new int[highIndex - midIndex + 1];
	
	for (int i = midIndex + 1; i <= highIndex; i++) {
		R[i - midIndex - 1] = list[i];
	}
	R[highIndex - midIndex] = Integer.MAX_VALUE;
	int i = 0, j = 0;
	
	for (int k = lowIndex; k <= highIndex; k++) {
		if (L[i] <= R[j]) {
			list[k] = L[i];
			i++;
		}
		else {
			list[k] = R[j];
			j++;
		}
	} 
}