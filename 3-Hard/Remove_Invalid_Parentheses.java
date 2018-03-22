#301. Remove Invalid Parentheses
/*Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]*/

/*Key Points:

Generate unique answer once and only once, do not rely on Set.
Do not need preprocess.
Runtime 3 ms.

Explanation:
We all know how to check a string of parentheses is valid using a stack, or even simpler use a counter.
The counter will increase when it is ‘(‘ and decrease when it is ‘)’. Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.

To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix. 
However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same (). 
Thus, we restrict ourself to remove the first ) in a series of concecutive )s.

After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string. 
However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by 
removing two ‘)’ in two steps only with a different order. For this, we keep tracking the last removal position and only remove ‘)’ after that.

Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
The answer is: do the same from right to left.
However a cleverer idea is: reverse the string and reuse the code!*/

public List<String> removeInvalidParentheses(String s) {
	List<String> ans = new ArrayList<>();
	remove(s, ans, 0, 0, new char[]{'(', ')'});
	return ans;
}

public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
	for (int stack = 0, i = last_i; i < s.length(); i++) {
		if (s.charAt(i) == par[0]) stack++;
		if (s.charAt(i) == par[1]) stack--;
		if (stack >= 0) continue;
		for (int j = last_j; j <= i; ++j)
			if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
				remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
		return;
	}
	String reversed = new StringBuilder(s).reverse().toString();
	if (par[0] == '(') // finished left to right
		remove(reversed, ans, 0, 0, new char[]{')', '('});
	else // finished right to left
		ans.add(reversed);
}
/*if (par[0] == '(') 
This is used to check if the current ‘s’ is reversed version, if it is not, that means still need to check the reversed string to make it legal, 
if it is reversed version ‘s’, then you’ve checked both ordered and reverse-ordered. What you have now is legal pattern.

The program only generates valid answers. Every path in the search generates one valid answer. The whole search space is a tree with k leaves. 
The number of nodes in the tree is roughly O(k). But this is not always true, for example a degenerated tree.

To generate one node it requires O(n) time from the string concatenation among other things. So roughly O(nk). Accurately O(nm) where m is the 
total “number of recursive calls” or “nodes in the search tree”. Then you need to relate m to n in the worst case.

I wouldn’t worry too much about the accurate complexity analysis of this problem. It would require more mathematics than an interview cares.

1. last_i and last_ j
	I once thought last_j is not necessary but I was wrong. Its essential advantage is at process redundant ")" from left to right, 
	process redundant "(" from right to left. Then let’s focus on 2 contiguous recursions. 	Let’s take ‘())())’ as an example: first recursion, 
	last_j = 1, the string is ())()), after deleting it the string is ()()). I once thought that since s[0] and s[1] is valid now like ()()), we don’t 
	need to change s[0]+s[1] in later steps. But it is not true as s[1] is still possible to be deleted in later steps, and the right logic should be: 
	once a ")" is deleted, we should restart from i=0, j=0 to look for the invalid ")" and do the recursion, and check those duplicates, this is the right way 
	to find all possible answers, just like in the above example, in the second recursion in principle we should start looking for redundant “)” from i=0, j=0, 
	and take care there will be duplicates { which means that working on ()()) and find i=4, j=1, string is like ()()), and then delete this s[j] }. 
	If we start from i=2, j=2, some answers will be missed. Fortunately, we don't need to restart from i=0, j=0 for each recursion, since all possible 
	transformation before last_j has been covered in previous recursions, { but all possible transformations in range [ last_ j, last_i ] are not, 
	take another example, ()()r)), first recursion can cover ()()r)), ()()r)), but won’t cover ()()r)) } , we just need to restart from j = last_j. 
	That’s why last_j is necessary. On the other hand, value i can restart from last_i, too. I kind of like thinking of that the reason of choosing i and j are 
	independent to each …
2. next recursion starts from i, not i+1 since 1 char is deleted, index i is automatically advanced one position.*/