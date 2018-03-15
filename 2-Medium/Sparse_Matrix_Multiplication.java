F000. Sparse Matrix Multiplication
//https://www.cs.cmu.edu/~scandal/cacm/node9.html
/*Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.*/


//Optimized version than the below one (O(n^2))
public int[][] multiply(int[][] A, int[][] B) {
	int rowA = A.length;
	int colA = A[0].length;
	int colB = B[0].length;
	int[][] res = new int[rowA][colB];

	for (int i = 0; i < rowA; i++) {
		for (int j = 0; j < colA; j++) {
			if (A[i][j] != 0) {
				for (int k = 0; k < colB; j++) {
					if (B[j][k] != 0) res[i][k] += A[i][j] * B[j][k];
				}
			}
		}
		return res;
	}

#OR
//O(n^3) Time
public int[][] multiply(int[][] A, int[][] B) {
	int[][] C = new int[A.length][B[0].length];
	for (int = 0; i < C.length; i++) {
		for (int j = 0; j < C[0].length; j++) {
			int sum = 0;
			for (int k = 0; k<A[0].length; k++) {
				sum += A[i][k] * B[k][j];
			}
			C[i][j] = sum;
		}
	}
	return C;
}