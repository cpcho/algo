#20. Valid Parentheses
/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid. 

The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "([)]" are not.*/


/*This solution includes a string length check that would return false if the string has an odd length. 
This would prevent extraneous calculations.

The basic idea is to push the right parentheses ')', ']', or '}' into the stack each time when we encounter left ones. 
If a right bracket appears in the string, check if the stack is empty and also whether the top element is 
the same as the right bracket. If not, the string is not a valid one. Lastly, we also need check if the stack is empty.

Adding the closing character to the stack, in order to avoid matching closing with opening brackets!*/

public boolean isValid(String s) {
	if (s.length() % 2 == 1) return false;

	Stack<Character> stack = new Stack<>();
	for (int i = 0; i < s.length(); i++) {	//	for (char c : s.toCharArray()) {
		if(s.charAt(i) == '(') 				//		if (c == '(') {
			stack.push(')');
		else if (s.charAt(i) == '{')
			stack.push('}');
		else if (s.charAt(i) == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != s.charAt(i)) //	else if (stack.isEmpty) || stack.pop() != c) {
			return false;
	}
	return stack.isEmpty();
}

#OR
public boolean isValid(String s) {
	Stack<Integer> stack = new Stack<>();
	for (int i = 0; i < s.length(); i++) {
		int index = "(){}[]".indexOf(s.substring(i, i+1));
		if (q % 2 == 1) {
			if(stack.isEmpty() || stack.pop() != index - 1) return false;
		} else {
			stack.push(index);
		}
	}
	retun stack.isEmpty();
}

#OR
//did not pass
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        switch (s.charAt(i)) {
            case '(':
                stack.push('(');
                break;
            case '{':
                stack.push('{');
                break;
            case '[':
                stack.push('[');
                break;
            case ')':
                if (stack.size() == 0 || stack.pop() != '(')
                    return false;
                break;
            case '}':
                if (stack.size() == 0 || stack.pop() != '{')
                    return false;
                break;
            case ']':
                if (stack.size() == 0 || stack.pop() != '[')
                    return false;
                break;
        }
    }
    return stack.isEmpty();
}