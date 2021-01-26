/* 14. Longest Common Prefix 



Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

Solution 1 : Horizontal scanning

By store all string and keep compareing following string by using indexOf() method 
(indexof will return the position of the first occurence of specified character(s) in a string)
Let say string[] strs ahve {leets , leetcode , leet , leeds}
First , store {leets} in a string call prefix.
Compare leets and leetcode
while prefix != 0 which can't found the character anymore , prefix.length will subtruct 1 util all string are the same
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null ||strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0 , prefix.length() - 1);
             }
        }
        return prefix;
    }
}
/* Time complexity : O(S) where S is the sum of all charactrs in all strings which the n as length and 
m as same character. S = n * m
Space complexity : O(1) we only used constant extra space

/*
Solution 2 : Vertical scanning (better soultion)

*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        for(int i=0; i<strs[0].length; i++){ 
            char c = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++){
                if (i == strs[j].length() || strs[j].charAt(i) != c){  
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0]
    }
}
/* Time complexity : O(S) where S is the sum of all charactrs in all strings. Although the time compexity
is the same as soultion 1. However , soultion 1 need to check all the character at all time 
but soultion 2 not really need to check all the character at all time becuase it only compare the first
character first and then second character to n character which will be n * minLen.

Space complexity: O(1), same as soultion 1.

/* Solution 3 : Divide and conquer by using recursion 
We split the problem into two subproblems:(left common prefix) and (right common prefix).
After founding each common prefix and then combine them to find the longest common prefix.

{leetcode , leet , lee , le}
        /           \
{leetcode, leet}   {lee, le}
        |              |
       {leet}        {le}
           \          /
            \        /
             \      /
              \    /
               {le}
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , str.length = 1);
    }
    // divide by two differnt part , left and right
    public String longestCommonPrefix(String [] strs, int left , int right) {
        if (left == right) return strs[left];
    } else {
        int mid = (left + right) / 2;
        String lcpleft = longestCommonPrefix(strs, left , mid);
        String lcpright = longestCommonPrefix(strs, mid+ 1, right);
        return commonPrefix(lcpleft, lcpright);
    }

    //putting  two common prefix into one which is longest common prefix
    public String commonPrefix(String left , String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0 , i);
            }
        }
        return left.substring(0 , min);
    }
}

