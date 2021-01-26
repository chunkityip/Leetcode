// Soultion 1 : detail in "Why I can't do it "
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String ans = "0";
        int index = 0;
        for (int i = num2.length() - 1; i >= 0; i--){
            int carry = 0;
            String ans_curr = "";
            int m_num2 = num2.charAt(i) - '0';
            for (int j = num1.length() -1; j >= 0; j--){
                int m_num1 = num1.charAt(j) - '0';
                /* mult =  3 * 6 + 0 = 18
                ans_curr = 18 % 10 + "0"+ "" = "8"
                carry = 18 / 10 = 1;
                */
                /* mult =  2 * 6 + 1 = 13
                ans_curr = 13 % 10 + "0"+ "8" = "38"
                carry = 13 / 10 = 1;
                */
                /* mult =  1 * 6 + 1 = 7
                ans_curr = 7 % 10 + "0"+ "38" = "738"
                carry = 7 / 10 = 0;
                */
                int mult = m_num2 * m_num1 + carry;
                ans_curr = mult % 10 + "" + ans_curr;
                carry = mult / 10;
            }
            if (carry > 0) {
                ans_curr = carry + "" + ans_curr;
            }
            //muliple (add) 10 to the next loop
            for (int k = 0; k < index; k++) {
                ans_curr = ans_curr + "0";
            }
            index++;
            //add all number 
            ans = sumString(ans , ans_curr);
        }
        return ans;
    }
    
    private String sumString(String num1 , String num2) {
        int carry = 0;
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        String ans = "";
        while (num1_index >= 0 || num2_index >= 0) {
            int x = num1_index >= 0 ? num1.charAt(num1_index) - '0' : 0;
            int y = num2_index >= 0 ? num2.charAt(num2_index) - '0' : 0;
            int sum = x + y + carry ;
            carry = sum / 10;
            ans = sum % 10 + "" + ans;
            num1_index--;
            num2_index--;
        }
        if (carry > 0) {
            ans = carry + "" + ans;
        }
        return ans;
    }
}

// Soultion 2 : detail in "Why I can't do it "
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int [] index = new int [n1 + n2];
        for (int i = n1 - 1; i >= 0; i--){
            for (int j = n2 - 1; j >= 0; j--){
                /* mul = 6 * 3 = 18
                   sum = 18 + index[2 + 2 + 1 = 5]
                   index[4] += 18 / 10 = 1.8 = 1
                   index[5] = 18 % 10 = 8
                   
                   index 0 1 2 3 4 5
                                 1 8
                 */
                
                /* mul = 6 * 2 = 12
                  sum = 12 + index[2 + 1 + 1 = 4]
                  index[3] += 12 / 10 = 1.2 = 1
                  index[4] = 12 % 10 = 2
                  
                  index 0 1 2 3 4 5
                                1 8
                              1 2
                */
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + index[i + j + 1];
                index[i + j] += sum / 10;
                index[i + j + 1] = sum % 10;
            }
        }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < index.length; i++) {
        if (i == 0 && index[i] == 0){
            continue;
            }
        sb.append(index[i]);
        }
    return sb.toString();
    }
}