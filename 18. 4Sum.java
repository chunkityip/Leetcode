class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // because the problem need to sum 4 number , if not having 4 number , how can
        // we sum?
        if (nums.length < 4)
            return ans;
        Arrays.sort(nums);
        // because we need i + 3 number so if nums length smaller than 3, no need loop
        // again
        // skip i pointer duplicates
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // because we need i + j + 2 number so if nums length smaller than 2, no need
            // loop again
            // skip j pointer duplicates
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        return ans;
    }
}

/*
 * Time Complexity : O(n^3) Space Compexity: O(n)
 */
