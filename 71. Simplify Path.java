class Solution {
    public String simplifyPath(String path) {
        if (path.isEmpty()) return path;
        Stack<String> stack = new Stack<String>();
        //Once we using the split method , /a/./b/../../c/ will be a . b .. .. c
        //In unix , .. meaning to move the location backword , . mean to maintain the location 
        String[] com = path.split("/");
        for (String curr : com) {
            // when we found the "." , meaning to maintain the location ,so continue it.
            if (curr.equals(".") || curr.isEmpty()) {
                continue;
            //When we found the ".." , meaning to move the location backword
            } else if (curr.equals("..")) {
                //if stack have soemthing , pop it
                if(!stack.isEmpty()) {
                    stack.pop();
                    }
                } else {
                    stack.push(curr);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String curr : stack) {
                sb.append("/");
                sb.append(curr);
            }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}