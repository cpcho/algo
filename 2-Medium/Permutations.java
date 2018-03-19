#46. Permutations (Medium)
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
         if(temp.contains(nums[i])) continue; // if element already exists, skip
         temp.add(nums[i]);
         backtrack(list, temp, nums);
         temp.remove(temp.size() - 1);
      }
   }
}