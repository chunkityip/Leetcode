class Solution {
    public void sortColors(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0)
            return;
        // putting red as left , blue as right
        int red = -1;
        int blue = nums.length;
        int i = 0;
        while (i < blue) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                // giving new space to new blue pointer from white
                // swap the new blue pointer and the original blue pointer
                blue--;
                swap(nums, i, blue);
            } else {
                // giving new space to new red pointer from white
                // swap the new rede pointer and the original red pointer
                red++;
                swap(nums, i, red);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int color) {
        int temp = nums[i];
        nums[i] = nums[color];
        nums[color] = temp;
    }
}

// Time Complexity : O(N)
// Space Complexity: O(1)