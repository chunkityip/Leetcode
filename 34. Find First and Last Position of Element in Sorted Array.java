// My idea : 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int []{-1, -1};
        int start = 0,  end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int i = mid - 1, j = mid -1;
                while(j <= end) {
                    if (nums[j] == target) {
                        j++;
                    }
                    return new int[] {i , j};
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int []{-1, -1};
    }
}

/* However , I didn't think of this probelm: the mid not always is begining of target. Therefore , we 
need search before the mid and after the mid by using two method.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int []{-1, -1};
        int start = foundStart(nums, target);
        int end = foundEnd(nums, target);
        
        return new int [] {start , end};
    }
    private int foundStart(int[] nums, int target) {
        int index = - 1, start = 0,  end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
           if (nums[mid] == target) index = mid;
        }
        return index;
    }
    
     private int foundEnd(int[] nums, int target) {
        int index = - 1, start = 0,  end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
           if (nums[mid] == target) index = mid;
        }
        return index;
    }
}
