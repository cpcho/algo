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


/*Follow normal way (two pointers) to check if s is palindrome. 
When two chars are not equal, try to skip (pseudo delete) either 
left one or right one and continue checking.*/

public boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j && s.charAt(i) == s.charAt(j)) {
        i++; j--;
    }

    if (i >= j) return true;

    if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) return true;
    return false;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            }
            else return false;
        }
        return true;
    }
#OR

//Fancy
//Java O(n) Time O(1) Space
public boolean validPalindrome(String s) {
    int l = -1, r = s.length();
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
    return true;
}

public boolean isPalindromic(String s, int l, int r) {
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return false;
    return true;
}