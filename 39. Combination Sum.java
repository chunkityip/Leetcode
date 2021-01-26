/* 39. Combination Sum
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/
/* Solution 1 : backtracking 
Detail at "why I can't do it"
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        
        //to make sure the array are sorted order so we can do backtracking
        Arrays.sort(candidates);
        
        List<Integer> curr = new ArrayList<>();
        backtracking(ans , curr , candidates, target , 0);
        
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> curr , int [] candidates , int target , int startindex) {
        //once it match , return it
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = startindex; i < candidates.length; i++) {
            //if the candidates is bigger than target , break it.
            if(candidates[i] > target) {
                break;
            }
            curr.add(candidates[i]);
            //keep bactracking until it match the tager or bigger the target
            backtracking(ans, curr , candidates , target- candidates[i], i);
            //becuase the question ask to without duplicates , so subtrack 1
            curr.remove(curr.size() - 1);
        }
    }
}

/* Solution 2 : dynamic programming (for later, still not good at dp)
By using 2 loop , opt and nums
When we check opt[0] by checking nums[0],[1],[2],[3] 
When we check opt[1] by checking nums[0],[1],[2],[3] 
when we check opt[2] by checking nums[0],[1],[2],[3] 
util we check opt[7]
*/

public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<List<Integer>>> ans = new ArrayList<>();
    Arrays.sort(nums);
    if (nums[0] > target) {
        return new ArrayList<List<Integer>>();
    }
    // 先初始化 ans[0] 到 ans[target]，因为每次循环是更新 ans,会用到 ans.get() 函数，如果不初始化会报错
    for (int i = 0; i <= target; i++) {
        List<List<Integer>> ans_i = new ArrayList<List<Integer>>();
        ans.add(i, ans_i);
    }

    for (int i = 0; i < nums.length; i++) {
        for (int sum = nums[i]; sum <= target; sum++) {
            List<List<Integer>> ans_sum = ans.get(sum);
            List<List<Integer>> ans_sub = ans.get(sum - nums[i]);
            //刚开始 ans_sub 的大小是 0，所以单独考虑一下这种情况
            if (sum == nums[i]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                ans_sum.add(temp);

            }
            //如果 ans.get(sum - nums[i])大小不等于 0，就可以按之前的想法更新了。
            //每个 ans_sub[j] 都加上 nums[i]
            if (ans_sub.size() > 0) {
                for (int j = 0; j < ans_sub.size(); j++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(ans_sub.get(j));
                    temp.add(nums[i]);
                    ans_sum.add(temp);
                }
            }
        }
    }
    return ans.get(target);
}




