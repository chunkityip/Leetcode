//Binary Search. The idea of it is divid the sorted array by 2 to find the solution.


public int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    if (nums.length == 0) {
        return 0;
    }
    while (start <= end) {
        //to avoid overflow problem, try to use start = (end 0 start)/2 instead of using (start+end)/2
        //for more detail, check 3.20.2020 in step1
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return start;
}
