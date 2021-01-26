/* 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

Solution 1 : Backtracking 
Detail at "Why I can't do it".
First we open the open and close both set as integer 0, 
if the open smaller than n . backtracking(open + 1)
If the close smaller than open , backtracking(close + 1)
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", n, n);
        return ans;
    }

    private void helper(List<String> ans, String curr, int open, int close) {
        // for balance , if not , we will display like "(()))(" or ")))((("
        if (open > close)
            return;
        if (open == 0 && close == 0) {
            ans.add(curr);
            return;
        }
        if (open > 0) {
            helper(ans, curr + "(", open - 1, close);
        }
        if (close > 0) {
            helper(ans, curr + ")", open, close - 1);
        }
    }
}

/*
 * Solution 2 : Closure Number No matter what possibility , open will always
 * starting first and then need to have close to match. So just give a open (
 * and close ) call alex (now n need to subtract 1 because I already opening 1
 * Parentheses.) Now we just need to think , either we need to generate
 * Parentheses inside alex or after alex. ( left ) right ^ alex ^
 * 
 * Therefore, we can do the for loop as a. left will be a and right will be n –
 * i – 1. When i as 0 which mean all 2 Parentheses will add at right n - 0 - 1 =
 * 2
 * 
 * ()()() ()(())
 * 
 * Now i loop to 1 , left will be 1 and right will 3 – 1 – 1 = 1 ( () ) ()
 * 
 * Now i loop to 2 , left will be 1 and right will 3 – 1 – 2 = 0 which no more
 * right ( ()() ) ( (()) )
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i))
                    ;
                for (String right : generateParenthesis(n - i - 1))
                    ;
                ans.add("(" + left + ")" + right);
            }
        }
        return ans;
    }
}
