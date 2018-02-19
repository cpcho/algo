#15. 3Sum

	public List<List<Integer>> threeSum(int[] num){

		Arrays.sum(num);
		List<List<Integer>> res = new LinkedList<>(); //Create a Linked List
		for(int i=0; i<num.length-2; i++){ 
			if(i == 0 || (i > 0 && num[i] != num[i-1])) {
				int lo = i+1;
				int hi = num.length-1; //Highest value
				int sum = 0 - num[i]; //0 = sum + num[i]
				while(lo < hi){
					if (num[lo] + num[hi] == sum){
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while(lo < hi && num[lo] == num[lo+1]){
							lo++;
						} 
						while(lo < hi && num[hi] == num[hi-1]){
							hi--;
						}
						lo++; 
						hi--;
					} else if(num[lo] + num[hi] < sum){
							lo++;
					}
					else hi--;
				}
			}
		}
		return res;
	}

#67. Add Binary

	public String addBinary(String a, String b){
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while(i >= 0 || j >= 0){
			int sum = carry;
			if (j >= 0) sum += b.charAt(j--) - '0';
			if (i >= 0) sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum/2;
		}
		if (carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}

#206. Reverse Linked List - Reverse a singly linked list.
//https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
//Iterative way
//Time complexity: O(n)
//Space Complexity: O(1)
public ListNode reverseList(ListNode head){
	ListNode newHead = null;
	while (head != null) {
		ListNode next = head.next;
		head.next = newHead;
		newHead = head;
		head = next;
	}
	return newHead;
}

//Recursive way
public ListNode reverseList(ListNode head){
	return reverseListInt(head, null);
}

private ListNode reverseListInt(ListNode head, ListNode newHead){
	if(head == null) return newHead;
	ListNode next = head.next;
	head.next = newHead;
	return reverseListInt(next, head);
}


#100. Same Tree
//https://leetcode.com/problems/same-tree/description/
public boolean isSameTree(TreeNode p, TreeNode q) {
	// Equal nullity denotes that this branch is the same (local equality)
    // This is a base case, but also handles being given two empty trees
	if(p == null && q == null) return true;

	// Unequal nullity denotes that the trees aren't the same
    // Note that we've already ruled out equal nullity above
	if(p == null || q == null) return false;

	// Both nodes have values; descend iff those values are equal
    // "&&" here allows for any difference to overrule a local equality
	if(p.val == q.val)
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	// If we're here, both nodes have values, and they're unequal, so the trees aren't the same
	return false;
}

#17. Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
/*
 For each digit added, remove and copy every element in the queue and add the possible 
 letter to each element, then add the updated elements back into queue again. 
 Repeat this procedure until all the digits are iterated.
*/
public List<String> letterCombinations(String digits) {
	LinkedList<String> ans = new LinkedList<String>();
	if(digits.isEmpty()) return ans;
	String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	ans.add("");
	for(int i = 0; i < digits.length(); i++){
		int x = Character.getNumericValue(digits.charAt(i));
		while(ans.peek().length() == i) {
			String t = ans.remove();
			for(char s: mapping[x].toCharArray())
				ans.add(t+s);
		}
	}
	return ans;
}






