/* 5. LONGEST PALINDROMIC SUBSTRING  (Hard ,for me)

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

/* Solution 1 : Brute Force

Using one loop to creating the palindromic method. 
Checking the middle of the string array , adn then check if i as left equal to s.length() - i - 1  as right
For example : babad have 5 length , 5 / 2 = 2.
Therefore i will start at b. 5 - 0 - 1 = 4 , so s.length() - i - 1 will start at d
b a d a d
    ^   ^
    i   s.length() - i - 1
If it is palindromic , return true and keep looping,  else return false , stop the loop

Creating a string call answer set as "" and  empty integer call max
Using two loop to check first and second character by using palindromic method to check is palindromic or not. If yes , 
both of the loop keep looping. 
Creating a string call test by using substring method to display i and j substring.
If test by using palindromic method is correct and the length of test is bigger than max , which mean i and j are the same.
answer will be the substring of i and j , max will become answer.length()
*/

public boolean isPalindromic(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
    }
    return true;
}

public String longestPalindrome(String s){
    String answer = "";
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
            String test = s.substring(i ,j);
            if (isPalindromic(test) && test.length() > max);
            answer = s.substring(i ,j);
            max = Math.max(max, answer.length());
        }
    }
    return answer;
}
/* Time complexity : O(n3). Using one loop to check isPalindromic and two loop to set as i and j. Therefore, O(n3)
Space complexity: O(1)

/* Solution 2:  Dynamic Programming
By checking the string by backwording. 
*/
public String longestPalindrome(String s) {
    if (s == null || s.length() == 0)return s;
    int length = s.length();
    String answer = "";
    boolean[][]dp = new boolean[length][length];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <=2) || dp[i + 1][j - 1]);
            if (dp[i][j] && j - i + 1 > answer.length()) {
                    answer = s.substring(i , j + 1);
            }
        }
    } 
    return answer;
}


/* Time complexity : O (n2) by using two loop to check the same character 
Space complexity : by opening two extra space to check the same character
*/

/*There has a way to improve the above space complexity
We don't need to store dp , instead we only need to store 1 dp by backwording

https://www.youtube.com/watch?v=0xeBqanD5GQ&t=826s
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int left  = 0 , right = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                boolean isPali = dp[i + 1][j - 1] || (j - i <= 2);
                if (s.charAt(i) == s.charAt(j) && isPali) {
                    dp[i][j] = true;
                    
                    if (right - left < j - i) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left , right + 1);
    }
}


/* Solution 3 : Expand Around Center (Best solution)
by using a object call isPalindroic , set as left and right 
if (left is bigger or eqaul to 0 and right is smaller than length of s and s.charAt(left) equal to s.charAt(right)
left shift backword
right shift forward
Becasue the array will ether odd or even number , so we need to do R - L -1


in the main method , first , sanity check
createing a 2 integer , one call start , one call end
for i loop , i as 0
createing a integer call len 1 by using isPalindroic method , set left as i , set right also as i to assume it is odd array 
createing a integer call len 2 by using isPalindroic method , set left as i , set right also as i + 1 to assume it is evem array  
Because if there have one bigger than another , which mean we found the Palindroic,
So by create a integer call len to compare which one is better , len1 or len2 by using Math.max
if (len bigger end - start which will always true)
set start to i - (len - i) / 2
set end to i + len / 2

finally return s.substring (start , end + 1)

For example : babad

int len1 = expandAroundCenter(s,i,i);
b a d a d
^  
L 
^
J
is L == J? yes , len1 = 1

int len2 = expandAroundCenter(s,i,i+1);
b a d a d
^ ^ 
L J

is L == J? no 

if(len > end - start) {
    start = i- (len -1) /2;
    end = i + len / 2;
}
Because len as 1 > 0 - 0
start set to 0
end set to 1


Now the main method loop to 1

int len1 = expandAroundCenter(s,i,i);
Because the previous method L == J , L-- , J++
b a d a d
^   ^
i   J

is L == J? yes , len1 = 1

b a d a d
  ^ ^ 
  L J
is L == J? no 

if(len > end - start) {
    start = i- (len -1) /2;
    end = i + len / 2;
}
Because len as 1 !> 1 - 0
return the s.substring(0 , 2) which is bab

*/

class Solution {
    String ans = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s , i , i);
            helper(s , i , i+ 1);
        }
        return ans;
    }
    private void helper(String s , int left , int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String curr = s.substring(left + 1 , right);
        if (curr.length() > ans.length()) {
            ans = curr;
        }
    }
}