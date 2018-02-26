#67. Add Binary (Easy)

/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/

public String addBinary(String a, String b) {
	StringBuilder sb = new StringBuilder();
	int i = a.length() - 1;
	int j = b.length() - 1;
	int carry = 0;

	while(i >= 0 || j >= 0) {
		int sum = carry;
		if (j >= 0) sum += b.charAt(j--) - '0';
		if (i >= 0) sum += a.charAt(i--) - '0';
		//https://stackoverflow.com/a/34409988/5922564
		sb.append(sum % 2);
		carry = sum / 2;
	}
	if (carry != 0) sb.append(carry);
	return sb.reverse().toString();
}
