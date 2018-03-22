#17. Letter Combinations of a Phone Number (Medium)
/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

1[---]  2[abc] 3[def]
4[ghi]  5[jkl] 6[mno]
7[pqrs] 8[tuv] 9[wxyz]
        0[----]

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.*/

/*For each digit added, remove and copy every element in the queue and add the possible 
letter to each element, then add the updated elements back into queue again.
Repeat this procedure until all the digits are iterated.*/

public List<String> letterCombinations(String digits) {
	LinkedList<String> queue = new LinkedList<String>();
	if(digits.isEmpty()) return queue; //if(digits == null || digits.length() == 0) return queue;
	
	String[] buttons = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	queue.add("");
	
	for(int i = 0; i < digits.length(); i++) {
		int x = Character.getNumericValue(digits.charAt(i)); //int x = digits.charAt(i) - '0';

		while(queue.peek().length() == i) {
			String row = queue.remove();
			for (char l : buttons[x].toCharArray())
				queue.add(row + l);
		}
	}
	return queue;
}

#OR

public List<String> letterCombinations(String digits) {

	LinkedList<String> queue = new LinkedList<>();
	if (digits == null || digits.length() == 0) return queue;

	char[] dc = digits.toCharArray();

	String[] buttons = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	queue.offer("");

	for (int i = 0; i < dc.length; i++) {
		char[] letters = buttons[Character.getNumericValue(dc[i])].toCharArray();

		while(queue.peek().length() == i) {
			String row = queue.poll();
			for(char l : letters) {
				queue.offer(row + l);
			}
		}
	}
	return queue;

}

/*For some reason no one is commenting on the time complexity, 
but I think it is 4^n where 4 comes from the maximum amount of 
letters possible for a digit.

For example, the number “9” has 4 letters: “wxyz.”

If the input is “9” you will get 4 results. 
If the input is “99” you will get 16 results, etc. 
At each digit, we take the previous results, 
and for EACH letter corresponding to the digit, 
we append the letter to the previous results.*/