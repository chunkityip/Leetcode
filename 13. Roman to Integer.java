/* Roman to Integer 


Solution : the left to right pass by using HashMap
First , We can use hashmap to store the roman symbol and value.
Second, compare the first index and second index
Becuase in roman symbol , for example: IV is 4. I is 1 , V is 5 
when the first index smaller than second one , 5-1 = 4
when the first index bigger than second one, 5+1 = 6
Now here is the code:
*/

class Solution{
    public int romanToInt(String s){
       HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int last = s.length();
        int answer = map.get(s.charAt(last - 1));
        for (int i = last - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                answer += map.get(s.charAt(i));
            } else {
                answer -= map.get(s.charAt(i));
            }
        }
        return answer;
        
    }
}
/* Time complexity: O(1)
Space complexity : O(2)
*/

// Solution 2: the left to right pass by using switch 
class Solution {
    
    public int number (char c) {
        int ans = 0;
        switch(c){
            case'I' : return 1;
            case'V' : return 5;
            case'X' : return 10;
            case'L' : return 50;
            case'C' : return 100;
            case'D' : return 500;
            case'M' : return 1000;
        }
        return ans;
    }
    
    
    public int romanToInt(String s) {
    if(s== null || s.length() ==0)return 0;
       int n = s.length();
       int answer = number(s.charAt(n - 1));
       for (int i = n - 2; i >= 0; i--) {
           if (number(s.charAt(i)) >= number(s.charAt(i + 1))) {
               answer += number(s.charAt(i));
           } else {
               answer -= number(s.charAt(i));
           }
       }
        return answer;
    }
}
