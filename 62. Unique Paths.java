//from https://www.cnblogs.com/kubidemanong/p/11854724.html

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        //going right
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        //going down
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        //adding right and down paths together
        //the reason of i is 1 and j also is becauseing we alreading add 1 right and 1 down path into above loop
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        
    }
}

//Better time completxy 

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];

        // going right
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        // adding right and down paths together into 1d array
        // dp[i - 1] mean column
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[m - 1];
    }
}