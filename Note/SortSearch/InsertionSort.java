###Insertion Sort (Joe James)
//https://youtu.be/lCDZ0IprFw4
//Given an array of items, sort them in increasing order
//Insertion sort is not a fast sorting algorithm because it uses nested loops to shift items into place.
//It is useful only for small data sets
//It runs in O(n^2)

// using Array
public int[] insertionSort (int[] list) {
	int i, j, key, temp;
	for (i = 1; i < list.length; i++) {
		key = list[i];
		j = i - 1;
		while (j >= 0 && key < list[j]) {
			temp = list[j];
			list[j] = list[j + 1];
			list[j + 1] = temp;
			j--;
		}
	}
	return list;
}

// using ArrayList
public ArrayList<Integer> insertionSort (ArrayList<Integer> list) {
	int i, j, key, temp;
	for (i = 1; i < list.size(); i++) {
		key = list.get(i);
		j = i - 1;
		while (j >= 0 && key < list.get(j)) {
			temp = list.get(j);
			list.set(j, list.get(j + 1));
			list.set(j + 1, temp);
			j--;
		}
	}
	return list;
}

###Additional###

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

