class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        // Gray Code formula : G(n) = i ^ (i / 2) which mean1 << n = i ^ (i >> 1)
        for (int i = 0; i < (1 << n); i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}