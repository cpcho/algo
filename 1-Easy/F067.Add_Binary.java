#67. Add Binary (Easy)
//http://chortle.ccsu.edu/assemblytutorial/Chapter-08/ass08_2.html
/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/

/*B1      101
  B2       11
  Carry   11
        -------
Sum      1000

Retrieve the last char from both the strings, get the integer value, 
add it to the sum, check if there's a carry, append the rest of the 
value to resultant string.*/
public String addBinary(String a, String b) {
	StringBuilder sb = new StringBuilder();
	int i = a.length() - 1, j = b.length() - 1, remainder = 0;

	while(i >= 0 || j >= 0) {
		int sum = remainder;
		if (j >= 0) sum += b.charAt(j--) - '0';
		if (i >= 0) sum += a.charAt(i--) - '0';
		//https://stackoverflow.com/a/34409988/5922564
		sb.append(sum % 2);
		remainder = sum / 2;
	}
	if (remainder != 0) sb.append(remainder);
	return sb.reverse().toString();
}

/*O(m+n), m is the length of the binary string,
n is the length of the binary string b.*/