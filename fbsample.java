/*Sample Interview Questions & Solutions

By:Facebook CareersAugust 1, 2017

Below are three sample interview questions that give you a good idea of what Facebook interviewers may ask in a phone screen or onsite interview. Keep in mind that although we only list one sample solution per question, other solutions may exist. Happy studying!
Question 1: 2D Spiral Array
Find the pattern and complete the function: 
int[][] spiral(int n);
where n is the size of the 2D array.
Sample Result
input = 3
123
894
765

input = 4
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07

input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15
Solution
There are two general ways most people try to solve this problem. The most common is to find a pattern of how often you move each four directions. For example, on the 4x4 case it is 4,3,3,2,2,1. This kind of code usually has four for loops, each going one of the four directions. These kinds of solutions can very easily have bugs if you don't get the pattern exactly right or if you go too far. For example, the 1x1 case.

Another way to solve this problem is to greedily traverse in each direction until you must stop, then turn around and head in the other direction. The sample code below follows this approach and is generally the best way to solve this problem.
*/
//Sample Solution in Java
import java.util.Arrays;

public class Spiral {
  public static int[][] genSpiral(int n) {
   if (n<=0) {
    throw new IllegalArgumentException("N must be >0");
   }
   int[] dc = new int[]{1,0,-1,0};
   int[] dr = new int[]{0,1,0,-1};
   int dir = 0, val=0, r=0, c=0,limit=n*n;
   int[][] matrix = new int[n][n];
   while (val++ < limit) {
    matrix[r][c] = val;
    r += dr[dir];
    c += dc[dir];
    if (isInvalid(matrix,r, c)) {
     r-= dr[dir];
     c-=dc[dir];
     dir = (dir+1)%4;
     r+= dr[dir];
     c+= dc[dir];
    }
   }
   return matrix;
  }
  private static boolean isInvalid(int[][] m, int r, int c) {
   return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
  } 
}
//Note, however, you can also solve this problem using recursion- walk around the boarder and fill out the numbers with each iteration. Then, reduce the problem to a smaller square (reduced n by 2). Continue until you arrive at the base case of 1 or 0.

/*Question 2: Look and Say
Implement a function that outputs the Look and Say sequence:
1 
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211
Solution
This problem is fairly straightforward and should not take a long time to solve. However, be sure you do proper error checking of the input first! (Empty and invalid inputs should be taken into account). Additionally, you can ask yourself:
How does the ouput length scale?
What is the max single digit that can exist in the output?
What is the only starting sequence that never grows in length?
Sample Solution in PHP*/

<?php
print_look_and_say_seq(100);

function print_look_and_say_seq($count = 0) {
  $val = 1;
  for ($i = 1; $i <= $count; $i++) {
   echo "$val\n";
   $val = output_val($val);
  }
}

function output_val($input) {
  $input = "$input"; // Normalize from int to string
  if (strlen($input) == 1) {
   return "1$input";
  }

  $ret = '';
  $cur = $input[0];
  $count = 1;
  for ($i = 1; $i <= strlen($input); $i++) {
   if ($cur != $input[$i] || $i == strlen($input)) {
    $ret .= "$count$cur";
    $count = 1;
    $cur = $input[$i];
   } else {
    $count++;
   }
  }
  return $ret;
}

/*Question 3: Edit Distance
Write a function that returns whether two words are exactly "one edit" away using the following signature:
bool OneEditApart(string s1, string s2);
An edit is:
Inserting one character anywhere in the word (including at the beginning and end)
Removing one character
Replacing one character
Examples:
OneEditApart("cat", "dog") = false 
OneEditApart("cat", "cats") = true
OneEditApart("cat", "cut") = true
OneEditApart("cat", "cast") = true
OneEditApart("cat", "at") = true
OneEditApart("cat", "act") = false
Solution
There are many solutions to this problem. One optimal solution is to walk each string in unison, tracking if a difference has been encountered. If a second difference is encountered, return false. If one string is longer than the other, then the difference must mean it is an insertion, so skip a character in the longer string and continue. Additionally, there are symmetry and short circuit opportunities.
Sample Solution in C++*/

bool one_edit_apart(const string* s1, const string* s2) {
  if (s1->size() > s2->size())
    swap(s1, s2);
  if (s2->size() - s1->size() > 1)
    return false;
  bool saw_difference = false;
  for (size_t i = 0, j = 0; i < s1->size(); ++i, ++j) {
    if ((*s1)[i] != (*s2)[j]) {
      if (saw_difference) return false;
      saw_difference = true;
      if (s2->size() > s1->size()) {
        --i;
      }
    }
  }
  return saw_difference || s2->size() != s1->size();
}