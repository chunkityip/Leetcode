class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // going by the row , so dp[i - 1][0]
        // because we need to store the attribute for later compareing , so add
        // grid[i][0]
        // also , if we set i as 0 at the beginning , what if 0 - 1 ? it will cause
        // error
        // so , set i as 1
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // going by the column , so dp[0][j - 1]
        // because we need to store the attribute for later compareing , so add
        // grid[0][j]
        // also , if we set j as 0 at the beginning , what if 0 - 1 ? it will cause
        // error
        // so , set j as 1
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // now we need to compare which location is smaller by suing Math.min
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}