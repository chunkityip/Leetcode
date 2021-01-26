// Soultion : backtracking 
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        backtracking(ans , new ArrayList<>(), nums);
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, List<Integer> track , int [] nums) {
        if(track.size() == nums.length) {
            //Noted that we need to do a deep copy because we are doing backtracking which mean we are changing the number 
            //When we do shallow copy , it will affact the obejcet num itself , for shallow copy , ans.add(track);
            ans.add(new ArrayList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtracking(ans , track , nums);
            // when we finish [1,2,3] and [1,3,2], we need to remove 1 so we can do [2, , ]
            track.remove(track.size() - 1);
        }
    }
}