/* 3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

/* Solution 1 : Brute Force 
By using 3 loop and HashSet to check the longest substring

create a new integer call answer as 0
i loop, i as 0 
j loop , j as i + 1
** if unique(s, i , j)is ture,  answer = Math.max (answer , j - i)
return answer 

** create a boolean method call unique set as String s , int start as i and int end as j
creating a empty character HashSet 
another i loop as start 
create a new char call ch as s.charAt(i)
if set contains ch , return false 
else , add ch to set
once it finish , return true
*/

class Main {
public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (unique(s, i , j)){
                    answer = Math.max (answer , j -i);    
                } 
            }
        }
        return answer;
    }
    
    public boolean unique(String s , int start , int end) {
        HashSet <Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}

/* Time complexity : O(n3)
Space complexity : O(min(n,m)). We are using set to check if the character unqiue or not. Because it will have no same character in set.
Therefore , if the length of string is m , the time of set is O(m).
Assume the if the length of string is smaller than m which is n . Therofre, set will also become O(n)
In conclusion , it will O (min(m,n))
*/

/* Solution 2 : Sliding Window
By using 3 loop , instead we should only check if s[i] in s[0,3] or not. str[0,5] , str[0,6] , str[0,7] will have same character 
***
a b c a b c a
^   ^
i   j
is i == j ? no, j++

a b c a b c a
^     ^
i     j
is i == j ? yes , i ++

a b c a b c a
  ^   ^
  i   j
is i == j ? no, j++

a b c a b c a
  ^     ^
  i     j

It bascilly mean shifting the window between i and j substring

create a empty hashset 
also create three empty integer call answer , i and j 

while i is samller than s.length and j is samller than s.length
if set didn't contains s.charAt(j) , add s.charAt(j++) into set (is i == j ? no, j++)
then answer equal to Math.max (answer , j - i) to see which is bigger
else if set did contains s.charAt(j) , remove s.charAt(i++) is i == j ? yes , i ++
finally , return the answer 
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

/* Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by ii and jj
Space complexity : O (min(m , n)). Same as solution 1.

/* Solution 3 : Sliding Window Optimized. The solution 2 are using 2n step. Instead we can only do n step by using HashMap and ASCII
create a empty HashMap (Key as Character , Value as Integer)
create a empty intger call answer;
Set j as 0 , i as 0 loop
if map contains the s.charAt(j)
i will be become Math.max (map.get(s.charAt(j)), i)
if map didn't contains the s.charAt(j)
answer = Math.max (answer , j - i + 1);
put the s.charAt(j) as key , j + 1 as index into map
finally , return answer;

For example :
a b c a b c a
^
j

is j contains as key in map? no , short the value j as key , j + 1 as index into HashMap
now answer become 1

a b c a b c a
  ^
  j

is j contains as key in map? no , short the value j as key , j + 1 as index into HashMap
now answer become 2

a b c a b c a
    ^
    j

is j contains as key in map? no , short the value j as key , j + 1 as index into HashMap
now answer become 3

a b c a b c a
      ^
      j
is j contains as key in map? yes , i set to the c

a b c a b c a
    ^ ^
    i j
the answer still is 3, return answer
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        HashMap <Characet , Integer> map = new HashMap<>();
        for (int i = 0 , j = 0; j < s.length(); j++){
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            answer = Math.max (answer , j - i + 1);
            map.put(s.charAt(j, j + 1));
        }
        return answer;
    }
}

// Instead of using HashMap, we can use ASCII code 
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
}
/* Time complexity : O(n). Index j will iterate n times.
Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
Space complexity (Table): O(m). m is the size of the charset.
*/






