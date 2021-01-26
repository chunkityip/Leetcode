class Solution {
    public boolean isValid(String s) {
    HashMap<Character, Character> map = new HashMap<>();
    // putting Parentheses into map 
    map.put(')', '(');  
    map.put('}', '{');
    map.put(']', '[');

    //createing a Stack call stack
    Stack<Character> stack = new Stack<Character>(); 
    
    // also can be for (char c : s.toCharArray()){
    for (int i = 0; i < s.length(); i++) {   
      char c = s.charAt(i);

    // if map contains the closing bracket
      if (map.containsKey(c)) {                    

        //if the above is true, create a char call topElement, if stack is empty, put # , else put closing bracket
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != map.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}


or 
class Solution {
    public boolean isValid(String s) {
         
        Stack<Character> stack = new Stack<>(); 
         /* for example : [({})]
          push [ , ( , { into stack
         */
        for(char c : s.toCharArray()){       
        if(c=='[' || c=='(' || c=='{'){
            stack.push(c);   
        /* now the s have } , ) , ]. Because the last element of stack is '{' , so pop out the '{' , go to next character
               now the s have ) , ]. Because the last element of stack is '(' , so pop out the '(' , go to next character
               now the s have ]. Because the last element of stack is '[' , so pop out the '[' , go to next character
               now the stack is empty , so return stack.isEmpty() which is true
        */
        }else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
            stack.pop();
        }else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
            stack.pop();
        }else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
            stack.pop();
        //if there have no match , which mean isn't valid , return false
        }else{
            return false;
        }
    }
    return stack.isEmpty();
    }
}

        
