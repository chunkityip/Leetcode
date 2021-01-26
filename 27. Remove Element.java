class Solution {
    public int removeElement(int[] nums, int val) {
        //create a integer call i , set as 0 
        int i =0;  
        //for loop , j 
        for(int j=0; j<nums.length; j++){  
            // if the  nums j is not equal to val 
            if(nums[j]!=val){
                //swtich nums[i] to nums [j]
                //For example: nums : [3,2,2,3] , val is 3
                // nums[i] = 3 , nums[j]=3 , 3!=3 false
                // 3!=2 true, so nums[0] become 2 
                // i++ , i become 1 
                // it basically remove any value in nums equal to val
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
            
        }
        
    }
