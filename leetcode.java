#Problems:
//https://leetcode.com/explore/interview/card/facebook/

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

#2. Add Two Numbers
//https://leetcode.com/problems/add-two-numbers/description/
public ListNode addTwoNumbers(ListNode l1, ListNode l2){
	ListNode c1 = l1;
	ListNode c2 = l2;
	ListNode sentinel = new ListNode(0);
	ListNode d = sentinel;
	int sum = 0;
	while (c1 != null || c2 != null){
		sum /= 10;
		if (c1 != null) {
			sum += c1.val;
			c1 = c1.next;
		}
		if (c2 != null) {
			sum += c2.val;
			c2 = c2.next;
		}
		d.next = new ListNode(sum % 10);
		d = d.next;
	}
	if (sum / 10 == 1)
		d.next = new ListNode(1);
	return sentinel.next;
}
##OR###

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
	ListNode prev = new ListNode(0);
	ListNode head = prev;
	int carry = 0;
	while (l1 != null || l2 != null || carry != 0){
		ListNode curr = new ListNode(0);
		int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null ? 0 : l2.val) + carry;
		curr.val = sum % 10;
		carry = sum / 10;
		prev.next = curr;
		prev = prev.next;

		l1 = (l1 == null) ? l1 : l1.next;
		l2 = (l2 == null) ? l2 : l2.next;
	}
	return head.next;
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
	LinkedList<String> queue = new LinkedList<String>();
	if(digits.isEmpty()) return queue; //if(digits == null || digits.length() == 0) return queue;
	String[] buttonMapping = new String[] {"0", "1", "abc", "def", "ghi", 
									 "jkl", "mno", "pqrs", "tuv", "wxyz"};
	queue.add("");
	for(int i = 0; i < digits.length(); i++){
		int x = Character.getNumericValue(digits.charAt(i));
		while(queue.peek().length() == i) {
			String t = queue.remove();
			for(char s: buttonMapping[x].toCharArray())
				queue.add(t+s);
		}
	}
	return queue;
}






