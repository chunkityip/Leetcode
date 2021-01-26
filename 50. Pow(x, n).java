//50. Pow(x, n) 

class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        // check is n a negative number
        // if it is , it basically mean 1 / x
        // for example : 2 ^ - 3 = 0.125 , same as (1/2) ^ 3 = 0.125
        // therefore if n is negative , set isNegative to true , x divide by 1 and
        // change n to positive number (it also avoid overflow problem)
        // if n is -2147483648 , just changing negaitve to positive directly :
        // -2147483648 to 2147483648 will cast overflow. Therefore -2147483648 + 1 will
        // be -2147483647 and -(-2147483647) will be 2147483647 which avoid overflow
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            n = -(n + 1);
        }
        double ans = 1;
        double curr = x;

        while (n != 0) {
            // if n is odd number , just multiply ans and curr
            /*
             * for example : 2 ^ 5. 1. 5 % 2 is 1. Therefore , ans will be 2. n = 5 / 2 = 2.
             * 2. 4 % 2 isn't 1. Therefore , ans will be 4. n = 2 / 2 = 1. 3. 1 % 2 is 1.
             * Therefore , ans will be 8 * 1 , ans still 8 and n 1 / 2 is 0.5
             */
            if (n % 2 == 1) {
                ans *= curr;
            }
            curr *= curr;
            n /= 2;
        }
        if (isNegative) {
            ans *= x;
        }
        return ans;
    }
}