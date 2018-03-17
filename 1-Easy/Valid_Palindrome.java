#125. Valid Palindrome
/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.*/

public boolean isPalindrome(String s) {
	if (s.isEmpty()) return true;
	int left = 0, right = s.length() - 1;
	while (left < right) {
		char cLeft = s.charAt(left), cRight = s.charAt(right);
		if (!Character.isLetterOrDigit(cLeft)) {
			left++;
		} else if (!Character.isLetterOrDigit(cRight)) {
			right--;
		} else {
			if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) return false;
			left++; 
			right--;
		}
	}
	return true;
}