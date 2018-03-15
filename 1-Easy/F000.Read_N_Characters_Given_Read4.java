#Read N Characters Given Read4

/*The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. 

For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note: The read function will only be called once for each test case.*/

public int read(char[] buf, int n) {
	boolean eof = false; 					// end of file flag
	int total = 0;							// total bytes have read
	char[] tmp = new char[4]; 				// tmp buffer

	while (!eof && total < n) {
		int count = read4(tmp);
		eof = count < 4;					// check if it's the end of file
		count = Math.min(count, n - total); // get the actual count
		for (int i = 0; i < count; i++) {
			buf[total++] = tmp[i];			// copy from temp buffer to buf
		}
	}
	return total;
}