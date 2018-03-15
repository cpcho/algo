###Merge Sort###
//https://youtu.be/iMT7gTPpaqw
//Given an array of items, sort them in ascending order
//MergeSort is recursive (method that calls itself)
//Divide-and-Conquer algorithm
//Very efficient for large data sets
//Merge sort does log n merge steps b/c each merge step doubles the list size.
//It does n work for each merge step b/c it must look at every item
//So it runs in O(n log n)

void mergeSort(int[] array) {
	int[] helper = new int[array.length];
	mergeSort(array, helper, 0, array.length - 1);
}

void mergeSort(int[] array, int[] helper, int low, int high) {
	if (low < high) {
		int middle = low + (high - low)/2;
		mergeSort(array, helper, low, middle);
		mergeSort(array, helper, middle+1, high);
		merge(array, helper, low, middle, high);
	}
}

void merge(int[] array, int[] helper, int low, int middle, int high) {
	/* Copy both halves into a helper array */
	for (int i = low; i <= high; i++) {
		helper[i] = array[i];
	}
	int helperLeft = low;
	int helperRight = middle + 1;
	int current = low;

	while (helperLeft <= middle && helperRight <= high) {
		if (helper[helperLeft] < = helper[helperRight]) {
			array[current] = helper[helperLeft];
			helperLeft++;
		} else {
			array[current] = helper[helperRight];
			helperRight++;
		}
		current++;
	}
	/* Copy the rest of the left side of the array into the target array */
	int remaining = middle - helperLeft;
	for (int i = 0l i <= remaining; i++) {
		array[current + i] = helper[helperLeft + i];
	}
}
/*Merge sort divides the array in half, sorts each of those halves, and then merges 
them back together. Each of those halves has the same sorting algorithm applied to it. 
Eventually, you are merging just two singleelement arrays. It is the "merge" part 
that does all the heavy lifting.

The merge method operates by copying all the elements from the target array segment 
into a helper array, keeping track of where the start of the left and right halves 
should be (helperleft and helperRight). We then iterate through helper, copying the 
smaller element from each half into the array. At the end, we copy any remaining elements 
into the target array.

You may notice that only the remaining elements from the left half of the helper array are 
copied into the target array. Why not the right half? The right half doesn't need to be copied 
because it's already there. Consider, for example, an array like [ 1, 4, 5 || 2, 8, 9] 
(the "||" indicates the partition point). Prior to merging the two halves, both the helper array 
and the target array segment will end with [ 8, 9]. Once we copy over four elements (1, 4, 5, and 2) 
into the target array, the [ 8, 9] will still be in place in both arrays. There's no need to copy them over.

The space complexity of merge sort is 0( n) due to the auxiliary space used to merge parts of the array.*/