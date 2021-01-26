/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

/* Solution 1 : Brute Force
Very simple algorithms. By using 2 loop , i point to first index , j point to second index.
If both sum same as target , just display the index by opening the new integer array 
*/

class Solution {
    public int [] twoSum (int [] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int [] {i , j};
                }
            }
        }
         throw new IllegalArugementExceptiuon("No two sum solution");
    }
}
/* Time Complexity: O(N2) We are finding each lement by looping rest of the array. If it have n nums, it mean it means n time which is O(n)
Don't forget we still have another loop. So the time complexcity is O(N2) which is quadratic time.

Space Completxity : O(1)
*/


/* Solution 2 : Two-pass Hash Table
By using HashMap, no need to use 2 loop.
Open i loop, i as 0
First , put the nums[i] as key , i as value into HashMap
Description for HashMap put method () : Associates the specified value with the specified key in this map.

Open the same i loop again
open the new integer call curr , curr equal to target - nums[i]
if map get the curr element and the curr not same as i. The reason of making sure i isn't same as curr is becaue :
***you may not use the same element twice***
if yes , return the new array { i , curr} bu using HashMap get method
Description for HashMap get method () : Returns the "value" to which the specified key is mapped, or null if this map contains no mapping for the key.

***Because the get method display the value , therefore , I need to display the index which is i into map , not to key ***you
*/

class Solution {
    public int [] twoSum (int [] nums, int target) {
        // putting nums[i] to key , putting i to value
        HashMap <Integer, Integer> map = new HashMap <>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);    
        }     
        for (int i = 0; i < nums.length; i++) {
            int curr = target - nums[i];
            if (map.containsKey(curr) && map.get(curr) != i) {
                return new int[] {i, map.get(curr)};
            }  
        }
        throw new IllegalArugementException ("No Such of thing");
    }
}
/* Time complexity : O(n). We traverse the list containing n elements exactly twice. 
Since the hash table reduces the look up time to O(1), the time complexity is O(n).

Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, 
which stores exactly n elements.
*/



/* Solution 3 : One-pass Hash Table
We don't need to open i loop twice. We can first check if curr is in the map or not
if not, putting the nums[i] and i into map

First , map have nothing.
And then do i loop
When we create a integer curr which is equal to target as 9 - nums[i] as 2 = 7 , we ask if 7 in map or not
Because map have nothing , so , we putting curr as key which is 2 , i which is 0 as index
Go back to i loop , now curr = 2 because target as 9 - nums[i] as 7 = 2
we ask if 2 in map or not. Yes , it contains . So we can return  curr and i 
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = target - nums[i];
            if (map.containsKey(curr)) {
                return new int[] {map.get(curr) , i};
            }
            map.put(nums[i] , i);
        }
        throw new IllegalArgumentException ();
    }
}

/* Time complexity : O(n). We traverse the list containing nn elements only once. 
Each look up in the table costs only O(1) time.

Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, 
which stores at most nn elements.
*/



/* Sloution 4 (My though) : HashSet (Wrong)
Is that possialbe that using Set instent of using map becuase I was confuse what should I put into key and value
Because HashSet only add value, which is much easier .
Never mind, HashSet is slower than HashMap
*/







