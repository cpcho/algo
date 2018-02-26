#Problems:
//https://leetcode.com/explore/interview/card/facebook/

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

#369. Plus One Linked List
// i stands for the most significant digit that is going to 
// be incremented if there exists a carry.
// Dummy node can handle cases such as “9->9>-9” automatically
public ListNode plusOne(ListNode head) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode i = dummy;
	ListNode j = dummy;

	while (j.next != null) {
		j = j.next;
		if (j.val != 9) {
			i = j;
		}
	}

	if (j.val != 9) {
		j.val++;
	} else {
		i.val++;
		i = i.next;
		while (i != null) {
			i.val = 0;
			i = i.next;
		}
	}

	if (dummy.val == 0) {
		return dummy.next;
	}
	return dummy;
}
###OR###
ListNode add(ListNode root) {
    if (addOne(root)  == 1)  {
        ListNode  tmp= new ListNode<>(1);
        tmp.next = root;  
        return tmp;
    }
    return root;
}

int addOne(ListNode node) {
      if  (node == null)
          return 1;
      if  (addOne(node.next) == 1) { 
          int rem = (node.val + 1)/10;
          node.val = (node.val + 1)% 10;
          return rem;
      }
      return 0;
  }




