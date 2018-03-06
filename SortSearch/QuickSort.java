###Quick Sort###
/*https://youtu.be/Fiot5yuwPAg
Given an array of items, sort them in ascending order
Left partition-Pivot-Right partition
Moving both index pointers at the same time
At some point, lower and upper index pointers meet, 
and this means we are done with the sorting in this iteration

Recursive
Divide-and-Conquer algorithm
For large dataset

O(n^2) worst case
O(n log n) average case 
Performance depends largely on pivot selection
Randomly chosen pivots ensure O(n log n)*/

void quickSort(int[] arr, int left, int right) {
	int index = partition(arr, left, right);
	if (left < index - 1) quickSort(arr, left, index - 1); // Sort left half
	if (index < right) quickSort(arr, index, right); // Sort right half
}

void partition(int[] arr, int left, int right) {
	int pivot = arr[left + (right - left)/2];
	while (left <= right) {
		// Find element on left that should be on right
		while (arr[left] < pivot) left++;
		// Find element on right that should be on left
		while (arr[right] > pivot) right--;
		if (left <= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	return left;
}

//Joe

public class QuickSort {
	public void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	
	private void quickSort(int[] A, int low, int high) {
		if (low < high+1) {
			int p = partition(A, low, high);
			quickSort(A, low, p-1);
			quickSort(A, p+1, high);
		}
	}

	private void swap(int[] A, int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;		
	}
	
	// returns random pivot index between low and high inclusive.
	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}

	// moves all n < pivot to left of pivot and all n > pivot 
	// to right of pivot, then returns pivot index.
	private int partition(int[] A, int low, int high) {
		swap(A, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (A[i] < A[low]) {
				swap(A, i, border++);
			}
		}
		swap(A, low, border-1);
		return border-1;
	}
	
}
