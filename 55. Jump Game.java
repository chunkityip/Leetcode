//55. Jump Game 

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max)
                return false;
            int curr = i + nums[i];
            max = Math.max(max, curr);
        }
        return max >= nums.length - 1;
    }
}
