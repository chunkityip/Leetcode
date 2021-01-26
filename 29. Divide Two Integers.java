/* 29. Divide Two Integers
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, 
which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 
32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that 
your function returns 231 − 1 when the division result overflows.

*/

/* The solution is following by the this video : https://www.youtube.com/watch?v=htX69j1jf5U
The idea is by using  Arithmetic signed shift (>>, <<)
For example : dividend = 10 which is bit 1010, divisor = 3 which is bit 0010
dividend - (divisor << 1 << x) = 10 - (3 << 1 << 0) = 10 - 6 = 4
                                 10 - (3 << 1 << 1) = 10 - 12 we can't so dividend will be 4
                                 store 2

dividend - (divisor << 1 << x) = 4 - (3 << 1 << 0) = 4 - 6 = 4  we can't
                                                    store 1

And then we add 2 + 1 = 3 and display it 
*/

class Solution {
    public int divide(int dividend, int divisor) {
        // the question ask to return 2 ^ 31 - 1 when the dividend is overflows
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // Because we already remove the only possialbe overflow case which is 2 ^ 31 -
        // 1. Therefore, we are no longer warry about overflow
        // By using Math.abs , we don't need to warry about dividend and divisor
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ans = 0;
        while (a - b >= 0) {

            int x = 0;
            /*
             * First loop run ,10 - (3 << 1 << 0) = 6 10 - (3 << 1 << 1) = 12 , no , we
             * can't 10 -12 so we stop the loop
             */
            /*
             * Secibd loop run , 4 - (3 << 1 << 0) = 6 so we stop the loop
             */
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            /*
             * First loop run , 1 bit is 0001 <<< 1 which be 0010 which as 2 Second loop run
             * , 1 bit is 0001 <<< 0 still 1 and add res which as 2 equal to 3.
             */
            ans += 1 << x;
            // 10 - 3 << 1 as 6 = 4
            // 4 - 3 << 0 as 3 = 1
            a -= b << x;
        }
        // After finishing the algorithm , we return the quotient positive or negative
        // if both of them are bigger 0, ans is postive
        // else , it is negative
        return (dividend >= 0) == (divisor >= 0) ? ans : -ans;
    }
}

/*
 * Time Complexity : O(log n).
 * 
 * As we loop over the bits of our dividend, performing an O(1) operation each
 * time, the time complexity is just the number of bits of the dividend: O(log
 * n).
 * 
 * Space Complexity : O(1).
 * 
 * We only use a fixed number of int variables, so the space complexity is O(1).
 */
