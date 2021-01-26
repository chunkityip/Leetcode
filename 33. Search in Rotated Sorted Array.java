/* Solution 1 : 
Change the other side to 2 ^ 31 - 1 or - 2 ^ 31
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = nums[mid];
            //to check is target and nums[mid] is in same side or not
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                curr = nums[mid];
            } else {
                //change the other side to ether 2 ^ 31 -1 or -2 ^ 31
                curr = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
            }
            
            if (curr < target) {
                start = mid + 1;
            } else if (curr > target) {
                end = mid - 1;
            } else {
                return mid;
            }        
        }
        return -1;
    }
}

/* Solution 2 :
There will at least one side are sorted , just using that side 
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            //which mean the start is rotated sorted and nums[end] will be sorted array
            } else if (nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            } else {
                //opposite 
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}