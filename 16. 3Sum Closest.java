/* 16. 3Sum Closest 

/* Soultion : Brute Force 

by using 3 loop , keeing searching the answer 
Also, by using sub = Math.abs(sub -ans) to store the answer and then compare at each loop
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sub = Integer.MAX_VALUE , ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < sub ) {
                        ans = nums[i] + nums[j] + nums[k];
                        sub = Math.abs(ans - target);
                    }
                }
            }
        }
        return ans;
    }
}
/* Time Complexity : O(n3)
Space Complexity: O(1)


Solution 2 : Two Pointer

[-1,2,1,-4]
  ^ ^    ^

Three pointer sum together, first one is nums[i], second one call low, i+1 , third one call high, nums.length-1
if sum - target < sub (sub = Integer.MAX_VALUE, to avoid overflow) , which mean it didn't overflow
putting three pointer into sum 
sub = Math.abs(sub-target)

if these three pointer sum together is bigger than target, move the high left
else, move the low pointer right 

*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, minGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    ans = sum;
                    minGap = gap;
                }
                if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return ans;
    }
}

/* Time Complexity : O(n2)
Space Complexity: O(n)

*/
if (i == 0 || nums[i] != nums[i - 1])
while (low < high && nums[low] == nums[low - 1]) {
                    low++;
}
