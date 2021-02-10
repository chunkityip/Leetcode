class Solution {
    public int numTrees(int n) {
        if (n == 0)
            return 0;
        // why add 1 ? Becayse node 0 also a Node , so node 0 is 1
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // i is right , j is left
        // left will only have 0 to n - 1 nodes . J start at node 0
        // right will only have n - 1 to 0 nodes. I start at node n - 1.Because we
        // already have dp[0] and dp[1]. so I start at 2++
        // *** Notes that we set the starting note in i is 2 and the smallest node in
        // right is 1 which is node 0 , so we need to subtrack 1 itleft. Therefore ,
        // right - left - 1 will get node 0
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}