/* 12. Integer to Roman 

It comes from the anothers solution: https://leetcode.wang/leetCode-12-Integer-to-Roman.html

Solution 1 : greedy algorithms(best)
Store all the possialbe roman symbol and value 
What do I mean of possialbe roman? Here is the question node: 

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

It means all possiable roman value is 1000,900,500,400,100,90,50,40,10,9,5,4,1
which is M for 1000, CM for 900, D for 500, CD for 400 , C for 100 , XC for 90
L for 50 , XL for 40, X for 10 , IX for 9, , V for 5, IV for 4 , I for 1 

when nums is bigger than value[0] which is 1000
nums -= 1000
add 1000 roman symbol into sb

*/
class Solution {
    int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length && num >= 0; i++) {
            while (value[i] <= num) {
                num -= value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}

/*
 * Time complexity: O(1). Because the romen nubmer have a limit number and we
 * bascially printing all the necessary roman number between 1 to 1000.
 * Thereofore, it runs o(1000) which is O(1)
 * 
 * Space complexity : O(1)
 * 
 * /* Solution 2: Hardcode Digits Another way to slove the problem is simply to
 * price all the possialbe number into the possiable roman gorup
 * 
 * thousands -> M hundreds ->CM , D ,CD ,C tens -> XC , L , XL , X ones -> IX, V
 * , IV , I
 * 
 * Moreover , by using those : return M[num/1000] + C[(num%1000)/100]+
 * X[(num%100)/10] + I[num%10];
 * 
 * For example : 5 M[5/1000 = 0]AS NULL + C[(5%1000)/100 = 0] AS NULL +
 * X[(num%100)/10] AS NULL + I[5%10] AS 5 , founging the I[5] which is V.
 * 
 * display : V
 * 
 */
class Solution {
    public String intToRoman(int num) {
    //which is 0, 1000,2000,3000
    String [] M = {"","M","MM","MMM"}; 
    //which is 0,100,200,300...
    String [] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    //which is 0,10,20,30...
    String [] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    //which is 0,1,2,3...
    String [] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; 
    
    return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
}

/* Time complexity :O(1)
Space complexity: O(1)

/* The reason of using soultion 1 is much better than soultion 2 is if 
Roman Numerals were to be extended like 5000 or even 39999 ?
                                       _    _____
For the solution 1 we only need to add V or XXXIXCMXCIX
But for the soultion 2 , we need to add more number. 
Approach 2 becomes more and more difficult to manage, the more symbols we add.