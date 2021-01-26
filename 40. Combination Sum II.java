/* 40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

/* The differents is Each number in candidates may only be used once in the combination , like a subsequent
Solution 1 : backtracking : 
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        backtracking(ans, curr , candidates , 0 , target);
        return ans;
    }
    private void backtracking(List<List<Integer>> ans , List<Integer> curr , int [] candidates , int startIndex, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = startIndex; i < candidates.length ; i++){
            //can't repeating the same index element 
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            curr.add(candidates[i]);
            //go forward because it can't keep duplicates
            backtracking(ans, curr , candidates, i + 1, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}