/* 6. ZigZag Conversion 

Giving a String call s, s= "PAYPALISHIRING", print s to zigzag

P   A   H   N
A P L S I I G
Y   I   R

then print out to "PAHNAPLSIIGYIR"


Solution 1 : Sort by Row
First , we need to design the non-empty rows to Zig-Zag Pattern by using Math.min (numRows , len(s))
Second, creating a integer call curRow set as 0 and boolean goingRown as false 
when curRow is 0 or curRow is equal to numRows - 1 , changing the goingDown ehter ture or false to design 
should the row go down or not
if it is goingDown, add 1 , else , subtract 1 

For example : s : PAYPALISHIRING , n : 3

currRow is 0 and goingDown is false 
add 'P' to row . Is currRow 0 or is currRow == numsRows - 1 ? yes, changing goingDown to true
add 1 to currRow
now currRow is 1 and goingDown is ture

P

currRow is 1 and goindDown is ture
add down to 'A' . Is currRow 0 or is currRow == numsRows - 1 ? no, goingDown still true
add 1 to currRow

p
A

currRow is 2 and goindDown is ture
add down to 'Y'. is currRow 0 or is currRow == numsRows - 1 ? yes, changing goingDown to true
subtract 1 to currRow
now currRow is 1 and goingDown is false which mean the next char will add up

P
A
Y

currRow is 1 and goindDown is false
add up to 'P' . Is currRow 0 or is currRow == numsRows - 1 ? no, goingDown still false
subtract 1  to currRow
now currRow is 0 and goingDown is false which mean the next char will still add up


P
A P
Y


currRow is 0 and goindDown is false
add up to 'A' . Is currRow 0 or is currRow == numsRows - 1 ? yes, changing goingDown to true
add 1  to currRow
now currRow is 1 and goingDown is true which mean the next char will add downwoard

P   A
A P
Y

...................... */

class Solution {
    public String convert(String s, int numRows) {
        char [] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        int n = s.length();
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        while (index < n) {
            for (int i = 0; i < numRows && index < n; i++) {
                sb[i].append(c[index++]);
            }
            for (int i = numRows - 2; i >= 1 && index < n; i--) {
                sb[i].append(c[index++]);
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}















/* Solution 2 : Visit by Row (Most people get this soltuon)
https://www.youtube.com/watch?v=NfBcHxRe8jo

0 |P   A|   H   N
1 |A P/L| S/I I G
2 |Y / I| / R
  |/    |/

We can see the cycle of it. Every 2 * numRows - 2 will go down again

Opening a StringBuilder
for  i loop as 0, i <s.length()
createing a integer call index , add the cycle as i % (2 * numRows - 2);
is the index as 0 smaller then numRows 3?  yes
so ,append p to sb[0]

go back to i loop as 1 
1 % 4 = 1

is the index as 1 samller then numRows 3 ? yes
so. append a to sb[1]

go back to i loop as 2
2 % 4 = 2

is the index as 2 samller then numRows 3 ? yes
so. append y to sb[2]

go back to i loop as 3
3 % 4 = 3

is the index as 3 samller then numRows 3 ? no , we need to do 2 * numRows as (3) - 2 - index as (3) which as 1
so. append p to sb[1]

0 P
1 A P
2 Y
*/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i <sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % ( 2 * numRows - 2);
            index = index < numRows ? index : 2 * numRows - 2 - index;
            sb[index].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}