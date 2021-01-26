/* 7. Reverse Integer

When I saw the question , I have no idea how to slove it.
So I go back to see solution. The solution is very simple 

n = x % 10 
123 % 10 = 3  *Get the last integer 
x /=10  * Cause I already take out the 3, I need to divide by 3 so 123 will be 12 

12% 10 =2  * Get the last intger 
1% 10 = 2  * Get the last intger

reverse = reverse * 10 + n 

However , the problem ask about 32 bits signed integer which may cause overflow problem
It can use MAX_VALUE and MIN_VALUE can found out the overflow 

In Oracle, MAX_VALUE is A constant holding the maximum value an int can have, 2^31-1
           MIN_VALUE is A constant holding the minimum value an int can have, -2^31

In the solution, it also shows If reverse == MAX/10 , then temp = reverse * 10 + pop will overflow if and only if pop > 7
which mean  Max integer value is 2147783647 

"I don't think I can remember the max integer in the interview"

When I was watching this person code : https://www.cnblogs.com/grandyang/p/4125588.html
he was using if(abs(reverse) > Integer.MAX_VALUE /10) return 10 
It means if absolute number of reverse  bigger than Integer.MAX_VALUE /10, return 10 
Because he was using c++ , it should use Math.abs() method in java

*/

class Solution{
     public int reverse(int x) {
         int reverse = 0;
         while (x != null){
            int pop = x % 10;
            x /= 10;
            if (Math.abs(reverse) > Integer.MAX_VALUE /10) return 0
            answer = answer * 10 + pop;
         }
         return answer;                                    
}

