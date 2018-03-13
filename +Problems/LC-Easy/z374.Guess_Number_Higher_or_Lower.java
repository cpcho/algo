#374. Guess Number Higher or Lower

/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Example:
n = 10, I pick 6.

Return 6.*/

/*Hint: Here “My” means the number which is given for you to guess 
not the number you put into guess(int num).

We can apply Binary Search to find the given number. We start with the mid number. 
We pass that number to the guessguess function. If it returns a -1, it implies that 
the guessed number is larger than the required one. Thus, we use Binary Search for numbers 
lower than itself. Similarly, if it returns a 1, we use Binary Search for numbers higher 
than itself.*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
public class Solution extends GuessGame {
	public int guessNumber(int n) {
		int left = 1, right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int res = guess(mid);
			if (res == 0) {
				return mid;
			} else if (res < 0) {
				// Game master's num is lower, so my number is higher.
				right = mid - 1;
			} else {
				left = mid + 1;

			}
		}
		return -1;
	}
}
/*
O(log_2(n)) time. Binary Search is used.
O(1) space. No extra space is used.
*/