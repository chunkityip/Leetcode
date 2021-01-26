/* 15. 3Sum 

Solution 1 : Brute force
By keep seaching 3 loop , i , j , k is see is i + j + k equal to 0 or not ?
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
 
                        if(!resultList.contains(list)){
                            resultList.add(list);
                        }
                    }
                }
            }
        }
        return resultList;
    }
}

/* Time complexity : O(n3)
Space complexity : O(n)



Solution 2 : Two pointer
By using two pointer to found out unique triplets.
Moreover, the most different is can't contains duplicat triplets, 
which mean we need to check each value can't be same. 

Because two pointer techinque can only use for sorted array. 
We can use : Arrays.sort()

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        //avoid contain duplicate triplets
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
            helper(ans , i , nums);
            //
            }
        }
        return ans;
    }
    private void helper(List<List<Integer>> ans, int i , int [] nums) {
        int low = i + 1 , high = nums.length - 1;
        //
        while (low < high) {
        //
            int target = nums[i] + nums[low] + nums[high];
                if (target < 0) {
                    low++;
                } else if (target > 0) {
                    high--;
                } else {
                    //
                    ans.add(Arrays.asList(nums[i] , nums[low++] , nums[high--]));
            //if there have uplicate triplets between low and high, keep it low
            while (low < high && nums[low] == nums[low - 1]) {
                low++;
                }
            }
        }
    }
}
/* Time complexity : O(n2)
   Space complexity: O(logN)


Soultion 3 : HashSet
The idea is same as TwoSum and the Two pointer, by using set to store the data, once if contains the data, those number is correct answer and need to store in new array

The only trick is –nums[i] – nums[j] 
Because we are looking for 0 and the array will have negative number such as – 4, - 1
Therefore, by using –nums[i] – nums[j], negative become positive number subtract negative (positive number), will come a 0 
(Just exchange the position) 
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        //avoid contain duplicate triplets
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
            helper(ans , i , nums);
            //
            }
        }
        return ans;
    }
    private void helper(List<List<Integer>> ans, int i , int [] nums) {
      HashSet<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int curr = -nums[i] - nums[j];
            if (set.contains(curr)) {
                ans.add(Arrays.asList(nums[i], nums[j] , curr));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            set.add(nums[j]);
        }
    }
}

/* Time complexity : O(N2)
   Space complexity : O(N)

Solution 4 : No sorted 
The above solution are using sort method. What about not using sort method?

We need to open two HashSet and one HashMap
One HashSet call duplicate: it stores the first value. Skips the quale value 

One HashSet call found: it stores the pair found. No same value pair are added in result. If two value are same then the 3rd value will also be same

One HashMap call map: it stores the value 2nd against the index of 1st value

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}

