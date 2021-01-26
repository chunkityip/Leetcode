/*  17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

// Solution 1 : Backtracking (Recursion)
class Solution {
    Map<String, String> phone=new HashMap<String,String>(){{put("2","abc");put("3","def");put("4","ghi");put("5","jkl");put("6","mno");put("7","pqrs");put("8","tuv");put("9","wxyz");

    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}

// another way of doing this
class Solution {
    private String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<String>();
        }
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {

        if (offset == digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

}

    /*
     * Solution 2 : iteration
     * 
     * Let say digits is "23". first loop over : a , b ,c second loop first run : a
     * remove , adding d, e , f to the list : b ,c ad ,ae ,af second loop second run
     * : b rmove , adding d , e , f to the list : c , ad ae af bd be bf second loop
     * three run : c remove , adding d, e ,f to the list : ad ae af bd be bf cd ce
     * cf now digits is empty , return ans , end
     */

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                // remove the first letter
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    // adding together
                    ans.add(t + s);
            }
        }
        return ans;
    }

    /*
     * Time complexity : O(3 ^ N x 4 ^ M) put("2","abc"); <- 3^N put("3", "def");<-
     * 3^N put("4","ghi"); <- 3^N put("5","jkl"); <- 3^N put("6","mno"); <- 3^N
     * put("7","pqrs");<- 4^N put("8","tuv"); <- 3^N put("9","wxyz");<- 4^N where N
     * is the number of digits in the input that maps to 3 letters (2 : abd, and M
     * is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and
     * N+M is the total number digits in the input.
     * 
     * Space complexity : O(3 ^ N x 4 ^ M) Since one has to keep 3 ^ N x 4 ^ M
     * Solution.
     */

    // Soultion 3 : StringBuilder
class Solution {
    String [] letter = {"", "" ,"abc", "def", "ghi", "jkl", "mno" , "pqrs", "tuv" , "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        StringBuilder sb = new StringBuilder();
            helper(digits , 0 , sb , ans);
        return ans;
    }
    private void helper(String digits , int index , StringBuilder sb , List<String> ans) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return ;
        }
        String letters = letter[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            sb.append(c);
            helper(digits , index + 1, sb , ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}