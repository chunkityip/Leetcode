/* 8. String to Integer (atoi)
So basically the question need to think of 2 sitation :
1. once we found the whitespace, keep look it util we see a integer number with + / - sign
2. if the number is overflow, return Integer.MAX_VALUE or Integer.MIN_VALUE
*/
class Solution{
    public int myAtoi(String str) {
    int sign = 1;
        int ans = 0, pop = 0;
        boolean hasSign = false; //代表是否开始转换数字
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && !hasSign) {
                sign = -1;
                hasSign = true;
                continue;
            }
            if (str.charAt(i) == '+' && !hasSign) {
                sign = 1;
                hasSign = true;
                continue;
            }
            if (str.charAt(i) == ' ' && !hasSign) {
                continue;
            }

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasSign = true;
                pop = str.charAt(i) - '0';
                 //和上道题判断出界一个意思只不过记得乘上 sign 。
                if (ans * sign > Integer.MAX_VALUE / 10 || (ans * sign == Integer.MAX_VALUE / 10 && pop * sign > 7))
                    return Integer.MAX_VALUE;
                if (ans * sign < Integer.MIN_VALUE / 10 || (ans * sign == Integer.MIN_VALUE / 10 && pop * sign < -8))
                    return Integer.MIN_VALUE;
                ans = ans * 10 + pop;
            } else {
                return ans * sign;
            }
        }
        return ans * sign;
    }
}

// or (better and easier to do)
https://www.youtube.com/watch?v=vvua0G0eqsM&t=369s

public static int myAtoi(String str) {
	public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        char firstchar = str.charAt(0);
        int start = 0 , sign = 1, len = str.length();
        long ans = 0;
        
        if (firstchar == '-') {
            sign = -1;
            start++;
        }
        
        if (firstchar == '+') {
            sign = 1;
            start++;
        }
        
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) ans * sign;
            }
            ans = ans * 10 + str.charAt(i) - '0';
            if (sign == 1 && ans > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if (sign == -1 && ans > Integer.MAX_VALUE)return Integer.MIN_VALUE;
            }
        return (int) ans * sign;
    }
}

//or 
class Solution {
    public int myAtoi(String s) {
        int n =  s.length(), i = 0 , sign = 1 , ans = 0;
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                sign = ( s.charAt(i++) == '-') ? -1 : 1;
            }
        while (i < n && s.charAt(i) >='0' && s.charAt(i) <= '9') {
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE  %10 ) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + (s.charAt(i++) - '0');
        }
        return ans * sign;
    }
}