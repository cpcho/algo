#Backtracking Approach

// https://stackoverflow.com/a/24372493

/*This structure might apply to many other backtracking questions, but here I am just going to demonstrate 
Subsets, Permutations, and Combination Sum.*/

#78. Subsets
/*Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> temp, int [] nums, int start) {
    list.add(new ArrayList<>(temp));
    for(int i = start; i < nums.length; i++){
        temp.add(nums[i]);
        backtrack(list, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
    }
}

90. Subsets II (contains duplicates)
/*Given a collection of integers that might contain duplicates, nums, 
return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, int start) {
    list.add(new ArrayList<>(temp));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        temp.add(nums[i]);
        backtrack(list, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
    }
} 

#46. Permutations
/*Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums) {
   if(temp.size() == nums.length){
      list.add(new ArrayList<>(temp));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(temp.contains(nums[i])) continue; // element already exists, skip
         temp.add(nums[i]);
         backtrack(list, temp, nums);
         temp.remove(temp.size() - 1);
      }
   }
} 

#47. Permutations II
/*Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, boolean [] used) {
    if(temp.size() == nums.length){
        list.add(new ArrayList<>(temp));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            temp.add(nums[i]);
            backtrack(list, temp, nums, used);
            used[i] = false; 
            temp.remove(temp.size() - 1);
        }
    }
}

#39. Combination Sum
/*Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, int remain, int start) {
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(temp));
    else{ 
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(list, temp, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            temp.remove(temp.size() - 1);
        }
    }
}

#40. Combination Sum II (can’t reuse same element)
/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C 
where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]*/
public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, int remain, int start) {
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(temp));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            temp.add(nums[i]);
            backtrack(list, temp, nums, remain - nums[i], i + 1);
            temp.remove(temp.size() - 1); 
        }
    }
} 

#131. Palindrome Partitioning
/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]*/
public List<List<String>> partition(String s) {
   List<List<String>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), s, 0);
   return list;
}

public void backtrack(List<List<String>> list, List<String> temp, String s, int start){
   if(start == s.length())
      list.add(new ArrayList<>(temp));
   else{
      for(int i = start; i < s.length(); i++){
         if(isPalindrome(s, start, i)){
            temp.add(s.substring(start, i + 1));
            backtrack(list, temp, s, i + 1);
            temp.remove(temp.size() - 1);
         }
      }
   }
}

public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 

#77. Combinations
/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        backtrack(list,new ArrayList<Integer>(),n,k,1);
        return list;
}

public void backtrack(List<List<Integer>> list,ArrayList<Integer> temp, int n, int k, int start) {
    if(temp.size()==k)
        list.add(new ArrayList<>(temp));
    else if (temp.size()>k)
        return;
        
    for(int i=start;i<=n;i++){
        temp.add(i);
        backtrack(list,temp,n,k,i+1);
        temp.remove(temp.size()-1);
    }
}