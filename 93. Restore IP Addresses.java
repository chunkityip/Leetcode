class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        // because IP address have 4 parts , so 0 as the starting index , 4 as the
        // remain number
        helper(s, ans, 0, 4, "");
        return ans;
    }

    private void helper(String s, List<String> ans, int index, int remain, String curr) {
        // if 4 parts are done
        if (remain == 0) {
            // also if the number of index equal to s length , it is perfect ID address
            if (index == s.length()) {
                ans.add(curr);
            }
            return;
        }
        // because each part id number at least 1 and no more than 3 number , is between
        // 0 and 255
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            // because the id address only the first index can be 0
            // if the another index (2 to 3) are still 0 , it is inpossiable that can be ID
            // addess
            // "101" ok , "001" no
            if (i != 1 && s.charAt(index) == '0') {
                break;
            }
            String temp = s.substring(index, index + i);

            int num = Integer.valueOf(temp);
            // we need to control the number between 0 and 255 , so set num as small or
            // equal to 255
            // even though ID address have 4 parts , however , it only have 3 "." .
            // Therefore , if the ramain is 1 which mean this is the last(4)parts , no need
            // to add "." , else , add"."
            /*
             * For example ramin = 4 255. ramin = 3 255.255. ramin = 2 255.255.11. ramin = 1
             * 255.255.11.135
             */
            if (num <= 255) {
                helper(s, ans, index + i, remain - 1, curr + temp + (remain == 1 ? "" : "."));
            }
        }
    }
}