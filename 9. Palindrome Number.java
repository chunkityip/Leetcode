class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0 || x.isEmpty()) return true;
        int original = x,  palindrome , answer = 0;
        palindrome = x % 10;
        answer = answer * 10 + palindrome; 
        x /= 10;
        return (answer == original);
    }
}

/* isEmpty() is for String, not for integer 
    My solution didn't tell when should start , which is missing while loop (x!=0)
    One more thing : everythime when we think of math problem or integer swap or chnage problem,
think of overflow problem.
    if(x > Integer.MAX_VALUE / 10 ) return false
    if(x < Integer.MAX_VALUE /10 ) return false
    if(Math.abs(x) > Integer.MAX_VALUE /10 ) return false
    Or
    if(x < 0 ) return false. Image the x is -2 ^ 31 which is  -2147483648.  
    -2147483648 is smaller than 0, so it will return flase
    Also, positive integer overflow is 2147483647. x0 is 2 , x9 is 7. Therefore, it will only return false
*/

//Solution 1 
class Solution {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0 || x%10==0) return false  //thinking of x is 210. 210%10 = 0. It is not palindrome
        int palindrome = 0;
        while(x>palindrome){
            palindrome = palindrome * 10 + x %10;
            x /=10;
        }
        return palindrome == x || x == palindrome /10;
        //if x length /2 ==0 , x == reverted number
        //else x length/2!=0,  x == reverted nubmer /10 ; , like 010
    }
}

//Solution 2 
class Solution {
        public int reverse (int x){
        int pop, answer = 0;
        while(x!=0){
            pop = x % 10;
            x /=10 ;
            //Here is other solution, if(x > Integer.MAX_VALUE / 10) return 0;
            //if(x < Integer.MIN_VALUE / 10) return 0;
            //I prefer this way: 
            if (Math.abs(answer)> Integer.MAX_VALUE /10) return 0;
            answer = answer * 10 + x % 10;
        }
        return answer;
    }
    public boolean isPalindrome(int x){
        if (x < 0) return false;
        int rev = reverse(x);
        return x == rev;
}

//Here is my original idea to solution this problem:
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int original = x,  answer =0;
        while(x!=0){
            answer = answer * 10 + x %10;
            x/=10;
        }
        return original == answer;
    }
}

/* Time complexity : O(log{10}(n))We divided the input by 10 for every iteration
Space complexity : O(1).
