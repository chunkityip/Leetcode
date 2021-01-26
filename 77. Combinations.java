class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(ans, new ArrayList<>(), nums, 0, k);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index, int count) {
        if (count == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(ans, curr, nums, i + 1, count - 1);
            curr.remove(curr.size() - 1);
        }
    }
}


//Another Solution is much faster but harder to thinking of 
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // 1 is for strating pointer
        helper(1 , ans ,new ArrayList<>(), n , k);
        return ans;
    }
    
    private void helper(int start , List<List<Integer>> ans , List<Integer> curr , int n , int k) {
        if(curr.size() == k) {
            ans.add(new ArrayList(curr));
            return;
        }
        /* Attaclly we don't need count to n , For example , n = 5 , k = 4, curr.size() == 1
        ,all we need is (4 - 1 = 3) number. When i loop to 4 , what we need to add is just 4 and 5. The curr.size() are still 1 + 2 = 3*/
        for (int i = start; i <= n - (k - curr.size()) + 1; i++) {
            curr.add(i);
            helper(i + 1, ans , curr , n ,k);
            curr.remove(curr.size() - 1);
        }
    }
}