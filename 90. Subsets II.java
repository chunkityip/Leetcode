class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // avoid any duplicate subsets.
        Arrays.sort(nums);
        helper(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        ans.add(new ArrayList<>(curr));

        // remove duplicate subsets
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            helper(ans, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}