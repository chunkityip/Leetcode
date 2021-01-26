/* Divide and conquer 

The idea is it will have three possialbe direection , the maximum subarray ethier in left , or right or mid
So set up the helper fucntion to set up leftsum , rightsum , crosssum 
set up the crosssum to add left and right to check is the maximum subarray in mid 
*/

class Solution {
    public int crossSum(int[] nums, int left, int right, int p) {
    if (left == right) return nums[left];

    int leftSubsum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i = p; i > left - 1; --i) {
      currSum += nums[i];
      leftSubsum = Math.max(leftSubsum, currSum);
    }

    int rightSubsum = Integer.MIN_VALUE;
    currSum = 0;
    for(int i = p + 1; i < right + 1; ++i) {
      currSum += nums[i];
      rightSubsum = Math.max(rightSubsum, currSum);
    }

    return leftSubsum + rightSubsum;
  }

  public int helper(int[] nums, int left, int right) {
    if (left == right) return nums[left];

    int p = (left + right) / 2;

    int leftSum = helper(nums, left, p);
    int rightSum = helper(nums, p + 1, right);
    int crossSum = crossSum(nums, left, right, p);

    return Math.max(Math.max(leftSum, rightSum), crossSum);
  }

  public int maxSubArray(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }
}

// Dynamic Programming
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0)return 0;
        //open a dp and the length of dp will be n 
        int [] dp = new int[n];
        //store two integer , one is to know which number to start name dp, one is to store the Maximum Subarray name max
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // if the last of the number small than before number , store it
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
            //if not , which it is bigger than the before number which it is the nubmer we look for , add it
                dp[i] = dp [i - 1] + nums[i];
            }
            max = Math.max(max , dp[i]);
        }
        return max;
    }
}

/* Time complexity : O(N)
   Space complexity: O(N) because we are opening the dp length 
*/

//Actually we don't need to open the new integer , just store dp[0] as nums[0]

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0)return 0;
        int max = nums[0], dp = nums[0];
        for (int i = 1; i < n; i++) {
            // if dp adding the following number still bigger than nums[i] , that number should to start at.
            dp = Math.max(dp + nums[i] , nums[i]);
            max = Math.max(max , dp);
        }
        return max;
    }
}

/* Time complexity : O(N)
   Space complexity: O(1) because we are opening the dp length 
*/



