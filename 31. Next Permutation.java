/* 31. Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

The main idea is found the closest bigger number 
for exaple : 123
the closeest bigger number compare to 123 is 132 (look at 2 , 3 is the closeest bigger number)
Now need to swap to 213 , the closeest bigger number compare to 213 is 231 
(look at 1, 3 is the closeest bigger number)
Now need to swap to 312 , the closeest bigger number compare to 312 is 321
(look at 1, 3 is the closeest bigger number)
Now reverse to 123
*/
class solution {
    public void nextPermutation (int [] nums) {
        //found the smallest number
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //found the closeest bigger number
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums,i , j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int [] nums , int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i , j);
        }
    }

    private void swap(int [] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}