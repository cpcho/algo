Two-pointer Technique

/*Array is one of the fundamental blocks in algorithms. Since a string is just formed by an array of characters, they are both similar. Most interview questions fall into this category. Here we will discuss some common techniques to help you solve these problems.*/

/*I. Two-pointer technique:
These kind of problems usually involve two pointers:

One slow-runner and the other fast-runner.

A classic example is to remove duplicates from a sorted array, which is available for you to practice here.
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

There is another variation to that:

One pointer starts from the beginning while the other pointer starts from the end. They move toward each other until 
they both meet. Let's take a look at a classic problem: Reverse the characters in a string:

First, let's assume that we already have the swap function defined below:*/

private void swap(char[] str, int i, int j) {
    char temp = str[i];
    str[i] = str[j];
    str[j] = temp;
}

/*The idea is to swap the first character with the end, advance to the next character and swapping repeatedly until it reaches the middle position. 
We calculate the middle position as n/2 .
​You should verify that the middle position works for both odd and even size of array.*/

public void reverse(char[] str) {
    int n = str.length;
    for (int i = 0; i < n / 2; i++) {
        swap(str, i, n - i - 1);
    }
}

/*Or we can also solve the problem using the two-pointer technique.*/

public void reverse(char[] str) {
    int i = 0, j = str.length - 1;
    while (i < j) {
        swap(str, i, j);
        i++;
        j--;
    }
}
/*Which approach do you think is less likely to introduce bugs?

Classic problems:

Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Two Sum II - Input array is sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Reverse Words in a String II
https://leetcode.com/problems/reverse-words-in-a-string-ii/

Rotate Array
https://leetcode.com/problems/rotate-array/

Valid Palindrome
https://leetcode.com/problems/valid-palindrome/

Container With Most Water
https://leetcode.com/problems/container-with-most-water/

Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/
*/