#29. Divide Two Integers

/*Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.*/


/*The divisor will never be 0.
Make the divisor as big as possible.
long to int, narrow down the range and then convert.*/


//https://leetcode.com/problems/divide-two-integers/discuss/13397/Clean-Java-solution-with-some-comment.

public int divide(int dividend, int divisor) {
	//Reduce the problem to positive long integer to make it easier.
	//Use long to avoid integer overflow cases.
	int sign = 1;
	if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
		sign = -1;
	long ldividend = Math.abs((long) dividend);
	long ldivisor = Math.abs((long) divisor);
	
	//Take care the edge cases.
	if (ldivisor == 0) return Integer.MAX_VALUE;
	if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
	
	long lans = ldivide(ldividend, ldivisor);
	
	int ans;
	if (lans > Integer.MAX_VALUE){ //Handle overflow.
		ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	} else {
		ans = (int) (sign * lans);
	}
	return ans;
}

private long ldivide(long ldividend, long ldivisor) {
	// Recursion exit condition
	if (ldividend < ldivisor) return 0;
	
	//  Find the largest multiple so that (divisor * multiple <= dividend), 
	//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	//  Think this as a binary search.
	long sum = ldivisor;
	long multiple = 1;
	while ((sum+sum) <= ldividend) {
		sum += sum;
		multiple += multiple;
	}
	//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
	return multiple + ldivide(ldividend - sum, ldivisor);
}

#OR

public int divide(int dividend, int divisor) {
	if (dividend == 0) return 0;
	boolean neg = (dividend < 0) ^ (divisor < 0);
	long m = Math.abs((long) dividend), n = Math.abs((long) divisor);
	long result = 0;
	while (m >= n) {
		int shift = 0;
		while (m > (n << shift + 1)) {
			shift++;
		}
		m -= n << shift;
		result += (1 << shift);
	}
	result = (neg) ? ~(result - 1) : result;
	result = Math.min(Integer.MAX_VALUE, result);
	result = Math.max(Integer.MIN_VALUE, result);
	return (int) result;
}
