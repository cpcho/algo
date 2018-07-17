//Permutation
public class StringFindAllPermutation {
	public static Set<String> permutationFinder(String str) {
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // full string w/o first character

		Set<String> words = permutationFinder(rem);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}

	public static String charInsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}
}


//Write a method that will remove given character from the String
private static String removeChar(String str, char c) {
	if (str == null) return null;
	return str.replaceAll(Character.toString(c), "");
}


//Write a method to check if input String is Palindrome?
private static boolean isPalindrome(String str) {
	if (str == null) return false;
	StringBuilder strBuilder = new StringBuilder(str);
	strBuilder.reverse();
	return strBuilder.toString().equals(str);
}
//Write a method to check if input String is Palindrome (2nd method)

private static boolean isPalindromeString(String str) {
	if (str == null) return null;
	int length = str.length();
	for (int i = 0; i < length/2; i++) {
		if (str.charAt(i) != str.charAt(length - i - 1))
			return false;
	}
	return true;
}

// Valid parenthesis
public boolean isValid(String s) {
	
	if (s.length() % 2 == 1) return false;

	Stack<Character> stack = new Stack<>();
	for (Char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')')
		else if (c == '[')
			stack.push(']')
		else if (c == '{')
			stack.push('}')
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}

public boolean isValid(String s) {
	Stack<Integer> stack = new Stack<>();
	for (int i = 0; i < s.length(); i++) {
		int index = "()[]{}".indexOf(s.substring(i, i+1));
		if (q % 2 == 1) {
			if (stack.isEmpty() || stack.pop() != index - 1) return false;
		} else {
			stack.push(index);
		}
	}
	return stack.isEmpty();
}

// Square root
public int sqrt(int x) {
	int left = 1, right = x;
	while (left <= right) {
		int mid = left + (right - left) /2 ;
		if (mid == x/mid) {
			return mid;
		} else if (mid < x/mid) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	return right;
}


// moveZeroes
public void moveZeroes(int[] nums) {

	int index = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] != 0) nums[index++] = nums[i];
	}
	while (index < nums.length) {
		nums[index++] = 0;
	}
}

//Count number of each char in a String

String str = "Hello World";
int len = str.length();
Map<Character, Integer> numChars = new HashMap<>(Math.min(len, 26));

for (int i = 0; i < len; ++i) {
	char charAt = str.charAt(i);
	if (!numChars.containsKey(charAt)) {
		numChars.put(charAt, 1);
	} else {
		numChars.put(charAt, numChars.get(charAt) + 1);
	}
}

// max Profit within a period of times.
public int maxProfit(int[] prices) {
	int maxCur = 0;
	int maxSoFar = 0;
	for (int i = 1; i < prices.length; i++) {
		maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
		maxSoFar = Math.max(maxCur, maxSoFar);
	}	
	return maxSoFar;
}
