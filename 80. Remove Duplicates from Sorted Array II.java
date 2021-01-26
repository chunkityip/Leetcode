class Solution {
    public int removeDuplicates(int[] nums) {
        //because it allows two same number 
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            //if the following number isn't same as first and second number , keep looping 
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}