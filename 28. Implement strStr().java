public int strStr(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index, santly check
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        
        for (int i = 0; i < haystack.length(); i++) {
            // if i + needle length still bigger than haystack length, break the loop
            if (i + needle.length() > haystack.length()) break;
            
            for (int j = 0; j < needle.length(); j++) {
                //compare at each time 
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }
        
        return -1;

        /* For example , haystack = "hello" , needle = "ll"
        haystack(0+0) != needle.charAt(0)  which is h != l , true
        break ,go back to j loop

        haystack(0+1) != needle.charAt(1)  which is e != l , true
        break , j loop run out , go back to i loop

        haystack(1+0) != needle.charAt(0)  which is e != l , true
        break, go back to j loop

        haystack(1+1) != needle.charAt(1)  which is l != l false
        go to second if statement
        if (1 == 2-1) true
        return 2

        return -1 if for loop no match at all 

    }