class Solution {
    public int removeDuplicates(int[] nums) {
        //santiy check 
        if(nums == null || nums.length == 0) return 0;  
        //create a integer call i , i =0
        int i=0;
        //for loop as j is 1 by nums length 
        for(int j=1; j<nums.length; j++){
            // if first value of nums not equal to second one which they are not Duplicates
            if(nums[i]!=nums[j]){
                i++;
                // the first value will becomethe second value
                    nums[i] = nums[j];
            }
        }
        return i +1;
    }
}

/* For example : nums = [1,1,2]

nums[i] as 1
nums[j] as 1

nums[i]!=nums[j] false

now nums[j] as 2
nums[i]!= nums[j] true
i++ as 1

nums[i] = nums[j]


return 2


[0,0,1,1,1,2,2,3,3,4]

nums[i] as 0
nums[j] as 0

