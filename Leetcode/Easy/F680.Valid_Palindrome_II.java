#680. Valid Palindrome II (easy)
/*Given a non-empty string s, you may delete at most one character. 
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:
The string will only contain lowercase characters a-z. 
The maximum length of the string is 50000.*/


/*Use two pointers (one from left and one from right) to check if s is palindrome. 
When two chars are not equal, try to skip (pseudo delete) either left one or right one 
and continue checking.*/

public boolean validPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r && s.charAt(l) == s.charAt(r)) {
        l++; r--;
    }
    if (l >= r) return true;
    if (isPalin(s, l + 1, r) || isPalin(s, l, r - 1)) return true;
    return false;
}

private boolean isPalin(String s, int l, int r) {
    while (l < r) {
        if (s.charAt(l) == s.charAt(r)) {
            l++; r--;
        }
        else {
            return false;
        }
    }
    return true;
}

#OR

//Fancy
//Java O(n) Time O(1) Space
public boolean validPalindrome(String s) {
    int l = -1, r = s.length();
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return isPalin(s, l, r+1) || isPalin(s, l-1, r);
    return true;
}

public boolean isPalin(String s, int l, int r) {
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return false;
    return true;
}