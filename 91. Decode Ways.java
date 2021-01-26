class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];

        // because the two digits number will only have 2 ways to decode , so we store
        // first digits as 1 and second digits as 1
        // if there have more than 2 digits number , we can add up 2 immediately
        dp[0] = 1;
        dp[1] = 1;

        // if the third number isn't 0 , add up to dp
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }

            // now we are checking is then number bigger than 26.
            // If it is bigger than 26 , there is no way we can decode as 1 number
            // For example : 25 , we can decode as 1 number or 2 number.
            // 36 , we can't decode as 1 number , it only can decode as 2 number
            int num = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}